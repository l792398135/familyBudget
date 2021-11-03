package com.ruoyi.quartz.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImgFileUtils {
    static List<File> filelist = null;

    public static List<File> getAllFile(String filePath){
        filelist=new ArrayList<>();
        getFileList(filePath);
        return filelist;
    }

    public static void getFileList(String strPath) {
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
                } else {
                    filelist.add(files[i]);
                }
            }
        }
    }
}
