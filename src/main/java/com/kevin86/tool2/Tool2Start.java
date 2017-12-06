package com.kevin86.tool2;

import com.kevin86.utils.ConfigUtils;


public class Tool2Start {

    public static void main(String[] args) {
        ConfigUtils.readProperties();
        Pro2Manager.getInstance().proBatchClass();
    }
}
