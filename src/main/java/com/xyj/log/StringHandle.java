package com.xyj.log;

import java.io.*;

/**
 * Created by xiaoyijian on 2016/8/3.
 */
public class StringHandle {
    public static void main(String[] args) throws Exception {
        String pathName = "D:\\1.txt";
        FileInputStream fis = new FileInputStream(pathName);
        InputStreamReader reader = new InputStreamReader(fis,"GBK");
        BufferedReader br = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer();
        String line = "";
        while((line = br.readLine()) != null){
            sb.append(line);
        }
        br.close();
        String result = sb.toString().replaceAll(" ", "").replaceAll("\"","'");
        System.out.println(result);

    }
}
