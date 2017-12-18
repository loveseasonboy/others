package com.autoClassPath;

import javafx.beans.binding.StringBinding;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * 获取当前文件下的properties 文件中的字段
 */
public class ClassPath {
    public static void main(String[] args) {
        //1.最好的方式
        //获取当前的文件的文件流
        InputStream resourceAsStream =
                Thread.currentThread().getContextClassLoader().getResourceAsStream("config/db.properties");
        Properties properties = new Properties();
        //2.
        try {
            properties.load(resourceAsStream);
            String property = properties.getProperty("mysql.name");
            System.out.println(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //先获取路径
        //classpath:config/*/*.properties 的简单实现
        String dataSourceUrl = "classpath:config/*/*s.properties";
        String classpath = "classpath";
        if (dataSourceUrl.contains(classpath)) {
            String lastUrl = dataSourceUrl.substring(classpath.length() + 1, dataSourceUrl.length());
            String[] urls = lastUrl.split("/");
            //获取最后的文件名称非文件包名称
            //定义一个变量来判断文件名称是*，还是包含* 如config*,*selvelt等
            boolean checkName = false;//判断是否是*
            boolean checkContain = false;//判断是否包含*
            String fileName = urls[urls.length - 1].substring(0, urls[urls.length - 1].indexOf("."));
            if ("*".equals(fileName) && fileName.length() == 1) {
                checkName = true;//文件名称是*的所有的文件
            } else if (fileName.indexOf("*") > -1 && fileName.length() > 1) {
                checkContain = true;
            }
            System.err.println(fileName);


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < urls.length; i++) {
                String url = urls[i];
                //判断获取到的是不是* 如果不是*就拼接地址 如果不是就拿出来便利这个包及其包中的名称
                //TODO 如果是文件的开头就是不满足的如 conf* 这样的文件名称
                if (!"*".equals(url)) {
                    if (i == 0) {
                        sb.append(url);
                    } else {
                        sb.append("/" + url);
                    }
                } else {
                    //File file = new File();
                }

            }

        }
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        System.out.println(url);
    }
}
