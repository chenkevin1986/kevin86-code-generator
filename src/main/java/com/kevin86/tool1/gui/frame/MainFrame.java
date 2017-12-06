package com.kevin86.tool1.gui.frame;

import com.kevin86.tool1.mybatis.ui.ProPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = -5967446092351576860L;
	
	private MainFrame(){}
	private static final class Singleton{
		protected static final MainFrame instance = new MainFrame();
	}
	public static MainFrame getInstance(){
		return Singleton.instance;
	}
	
	
	public void init(){
		this.setTitle("游戏软件开发项目管理信息系统专用开发工具");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//Image image = new ImageIcon("../kevin.png").getImage();
		//this.setIconImage(image);
		this.setJMenuBar(addMenus());
		this.add(addTab());
		this.setVisible(true);
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//关闭窗口操作
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				closeWindow();
			}
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void closeWindow() {
		int result = JOptionPane.showConfirmDialog(null,"正在运行中，确定要退出？","确认退出", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(result == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
	JMenuItem configMenu;
	/**菜单工具栏*/
	private JMenuBar addMenus(){
		JMenu fileMenu = new JMenu("文件");
		JMenuItem openMenu = new JMenuItem("打开并自动保存");
		openMenu.addActionListener(this);
		JMenuItem exitMenu = new JMenuItem("退出");
		exitMenu.addActionListener(this);
		fileMenu.add(openMenu);fileMenu.add(exitMenu);
		
		JMenu config = new JMenu("设置");
		configMenu = new JMenuItem("项目与包路径设置");
		configMenu.addActionListener(this);
		config.add(configMenu);
		
		JMenu help = new JMenu("帮助");
		JMenuItem helpMenu = new JMenuItem("帮助");
		helpMenu.addActionListener(this);
		help.add(helpMenu);
		JMenuBar br = new JMenuBar(); 
		br.add(fileMenu);br.add(config);br.add(help);
		return br;
	}
	
	
	private Component addTab() {
		final JTabbedPane tab = new JTabbedPane();
		tab.addTab("生成架构", ProPanel.getInstance().initUI());
		tab.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				int selectIndex  = tab.getSelectedIndex();
				if(selectIndex == 0){
					System.out.println("0000");
				}else if(selectIndex == 1){
					System.out.println("1111");
				}else if(selectIndex == 2){
					System.out.println("2222");
				}
			}
		});
		return tab;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("打开并保存路径")){
			System.out.println("2222");
		}
		if(e.getActionCommand().equals("退出")){
			closeWindow();
		}
		if(e.getActionCommand().equals("设置")){
			System.out.println("3333");
		}
		if(e.getActionCommand().equals("帮助")){
			System.out.println("444555");
		}
		if(e.getSource().equals(configMenu)){
			new PathConfigFrame().initGui();
		}
		
	}




}
