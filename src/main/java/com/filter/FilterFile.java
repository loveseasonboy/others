package com.filter;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterFile {

    private List<String> profixFilePath = new ArrayList<String>();
    private String prefixName;//文件前缀
    private File filePath;//文件路基
    private String sufixName;//文件后缀

    public static void main(String[] args) {
        File file = new File("D:\\fiter");
        FilterFile filterFile = new FilterFile("application", file);
        filterFile.init();
        System.out.println(filterFile.profixFilePath);
    }

    public FilterFile(String prefixName, File filePath) {
        this.prefixName = prefixName;
        this.filePath = filePath;
    }

    public FilterFile(String prefixName, File filePath, String sufixName) {
        this.prefixName = prefixName;
        this.filePath = filePath;
        this.sufixName = sufixName;
    }

    /**
     * 获取指定前缀的文件名称
     *
     * @param file
     * @param prefixName
     * @return
     */
    public void prefixFileList(File file, final String prefixName) {
        File[] files = file.listFiles();
        for (File fle : files) {
            //判断下一个文件是否文件夹和文件
            if (fle.isDirectory()) {
                prefixFileList(new File(fle.getPath()), prefixName);
            } else {
                File fiter = fle;
                if (fle.getName().startsWith(prefixName)) {
                    profixFilePath.add(fle.getPath());
                }
            }
        }
    }

    /**
     * 过滤后缀文件
     */
    public void sufixFileList() {
        if (sufixName != null && !"".equals(sufixName)) {
            //此处使用迭代器处理不容易出错
            Iterator<String> iterator = profixFilePath.iterator();
            while (iterator.hasNext()) {
                String fileName = iterator.next();
                String fileSufix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
                if (!sufixName.equals(fileSufix)) {
                    iterator.remove();//迭代器删除，不会报数组下标越界的错
                }
            }
        }
    }

    //初始化过滤文件
    void init() {
        prefixFileList(filePath, prefixName);//过滤文件的前缀
        sufixFileList();//过滤文件后缀
    }

    public List<String> getProfixFilePath() {
        return profixFilePath;
    }

    public void setProfixFilePath(List<String> profixFilePath) {
        this.profixFilePath = profixFilePath;
    }
}
