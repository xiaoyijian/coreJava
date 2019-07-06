package com.xyj.proxy;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import javax.lang.model.element.Modifier;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.xyj.proxy.pojo.Animal;
import com.xyj.proxy.pojo.BigCar;
import com.xyj.proxy.pojo.Car;
import com.xyj.proxy.pojo.Cat;

/**
 * @author xiaoyijian
 * @date 2019/05/31
 */
public class Proxy {
    private final static String SOURCE_PATH = "/tmp/";

    public static Object newProxyInstance(Class clazz) throws IOException {
        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("TimeProxy")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(clazz);
        FieldSpec fieldSpec = FieldSpec.builder(clazz, "animal", Modifier.PRIVATE).build();
        typeSpecBuilder.addField(fieldSpec);
        MethodSpec constructorSpec = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(clazz, "animal")
                .addStatement("this.animal = animal")
                .build();
        typeSpecBuilder.addMethod(constructorSpec);

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType())
                    .addStatement("long start = $T.currentTimeMillis()", System.class)
                    .addCode("\n")
                    .addStatement("this.animal." + method.getName() + "()")
                    .addCode("\n")
                    .addStatement("long cost = System.currentTimeMillis() - start", System.class)
                    .addStatement("$T.out.println(\"time cost:\" + cost)", System.class)
                    .build();
            typeSpecBuilder.addMethod(methodSpec);
        }
        JavaFile javaFile = JavaFile.builder("com.xyj.proxy", typeSpecBuilder.build()).build();

        javaFile.writeTo(new File(SOURCE_PATH));
        JavaCompiler.compile(new File(SOURCE_PATH + "/com/xyj/proxy/TimeProxy.java"));

        return null;
    }

    public static void loadClass() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        URL[] urls = new URL[] { new URL("file:" + SOURCE_PATH) };
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class<?> clazz = urlClassLoader.loadClass("com.xyj.proxy.TimeProxy");
        Constructor<?> constructor = clazz.getConstructor(Animal.class);
        Animal animal = (Animal) constructor.newInstance(new Cat());
        animal.sleep();
        animal.play();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Proxy.newProxyInstance(Car.class);
        URL[] urls = new URL[] { new URL("file:" + SOURCE_PATH) };
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class<?> clazz = urlClassLoader.loadClass("com.xyj.proxy.TimeProxy");
        Constructor<?> constructor = clazz.getConstructor(Car.class);
        Car car = (Car) constructor.newInstance(new BigCar());
        car.move();
    }
}
