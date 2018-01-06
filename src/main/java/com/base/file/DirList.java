package com.base.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 过滤文件的使用的类
 */
public class DirList {
    /**
     * 过滤的方法---简单版本
     * @param afn  使用作用域内的其他的对象的时候必须是finally
     * @return
     */
    public static FilenameFilter filter(final String afn) {
        return new FilenameFilter() {
            String fn = afn;

            @Override
            public boolean accept(File dir, String name) {
                String f = new File(name).getName().toString();
                return f.indexOf(fn) != -1;
            }
        };
    }

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(filter(args[0]));
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
