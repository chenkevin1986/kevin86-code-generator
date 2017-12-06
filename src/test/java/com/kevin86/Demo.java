package com.kevin86;

import com.kevin86.utils.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Demo {
    @Test
    public void test1(){
//        String app_user_info = StringUtils.humpNaming("app_user_info");
//        System.out.println(app_user_info);
        String path = "/Volumes/dev2/IdeaProjects/code-generator/config/t2/db2.properties";
        File file = new File(path);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            System.out.println(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(file);
    }
}
