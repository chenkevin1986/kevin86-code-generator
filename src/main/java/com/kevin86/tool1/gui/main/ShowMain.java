package com.kevin86.tool1.gui.main;

import com.kevin86.tool1.gui.frame.MainFrame;
import com.kevin86.utils.ConfigUtils;

public class ShowMain {
	public static void main(String[] args) {
		ConfigUtils.readProperties();
		MainFrame.getInstance().init();
	}

}
