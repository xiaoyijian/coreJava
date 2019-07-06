package com.xyj.proxy;

import java.io.File;
import java.io.IOException;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * @author xiaoyijian
 * @date 2019/05/31
 */
public class JavaCompiler {

    public static void compile(File javaFile) throws IOException {
        javax.tools.JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMananger = javaCompiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> iterable = fileMananger.getJavaFileObjects(javaFile);
        javax.tools.JavaCompiler.CompilationTask task = javaCompiler.getTask(null, fileMananger, null, null, null, iterable);
        task.call();
        fileMananger.close();
    }
}
