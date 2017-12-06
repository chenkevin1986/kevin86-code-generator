package com.kevin86.utils;

import java.io.IOException;

/**
 * Created by chengang on 2016/1/29.
 */
public class CmdOrder {

    public static boolean execProcess(String ... cmds){
        boolean sucess = false;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmds);
            process.waitFor();
            if(process.exitValue() != 0 ){
                System.out.println("指令执行中断或错误！");
            }else{
                sucess = true;
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        return sucess;
    }
}
