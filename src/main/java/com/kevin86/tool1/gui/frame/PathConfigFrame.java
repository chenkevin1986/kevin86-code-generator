package com.kevin86.tool1.gui.frame;

import com.kevin86.utils.ConfigUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by chengang on 2016/3/15.
 */
public class PathConfigFrame extends JFrame implements ActionListener {
    public static final String srcStr = "src";

    public PathConfigFrame(){}

    private JButton pjtPath = new JButton("       项目路径      ");
    private JTextField pjjt = new JTextField(15);

    private JButton xmlPath = new JButton("        xml包名       ");
    private JTextField xmljt = new JTextField(15);

    private JButton mapperPath = new JButton("    mapper包名   ");
    private JTextField mapperjt = new JTextField(15);

    private JButton modelPath = new JButton("     model包名     ");
    private JTextField modeljt = new JTextField(15);

    private JButton servicePath = new JButton("    service包名    ");
    private JTextField servicejt = new JTextField(15);

    private JButton serviceimplPath = new JButton("serviceImpl包名");
    private JTextField serviceimpljt = new JTextField(15);

    private JFileChooser jfc ;// 文件选择器

    public void initGui(){
        this.setTitle("项目和包的路径设置");
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));

        JPanel yPanel = new JPanel(new BorderLayout(0,20));
        yPanel.setLayout(new BoxLayout(yPanel, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        pjtPath.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(pjtPath);pjtPath.addActionListener(this);
        panel1.add(Box.createHorizontalStrut(10));
        pjjt.setAlignmentX(Component.CENTER_ALIGNMENT);
        ConfigUtils.addSetProperites(pjjt,"project_path","");
        panel1.add(pjjt);pjjt.setEditable(false);
        yPanel.add(panel1);

        yPanel.add(Box.createVerticalStrut(10));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        xmlPath.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(xmlPath);xmlPath.addActionListener(this);
        panel2.add(Box.createHorizontalStrut(10));
        xmljt.setAlignmentX(Component.CENTER_ALIGNMENT);
        ConfigUtils.addSetProperites(xmljt,"mapperxml_package","");
        panel2.add(xmljt);xmljt.setEditable(false);
        yPanel.add(panel2);

        yPanel.add(Box.createVerticalStrut(10));
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        mapperPath.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel3.add(mapperPath);mapperPath.addActionListener(this);
        panel3.add(Box.createHorizontalStrut(10));
        mapperjt.setAlignmentX(Component.CENTER_ALIGNMENT);
        ConfigUtils.addSetProperites(mapperjt,"mapper_package","");
        panel3.add(mapperjt);mapperjt.setEditable(false);
        yPanel.add(panel3);

        yPanel.add(Box.createVerticalStrut(10));
        JPanel panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
        modelPath.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel4.add(modelPath);modelPath.addActionListener(this);
        panel4.add(Box.createHorizontalStrut(10));
        modeljt.setAlignmentX(Component.CENTER_ALIGNMENT);
        ConfigUtils.addSetProperites(modeljt,"model_package","");
        panel4.add(modeljt);modeljt.setEditable(false);
        yPanel.add(panel4);

        yPanel.add(Box.createVerticalStrut(10));
        JPanel panel5 = new JPanel();
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));
        servicePath.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel5.add(servicePath);servicePath.addActionListener(this);
        panel5.add(Box.createHorizontalStrut(10));
        servicejt.setAlignmentX(Component.CENTER_ALIGNMENT);
        ConfigUtils.addSetProperites(servicejt,"service_package","");
        panel5.add(servicejt);servicejt.setEditable(false);
        yPanel.add(panel5);

        yPanel.add(Box.createVerticalStrut(10));
        JPanel panel6 = new JPanel();
        panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));
        serviceimplPath.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel6.add(serviceimplPath);serviceimplPath.addActionListener(this);
        panel6.add(Box.createHorizontalStrut(10));
        serviceimpljt.setAlignmentX(Component.CENTER_ALIGNMENT);
        ConfigUtils.addSetProperites(serviceimpljt,"serviceimpl_package","");
        panel6.add(serviceimpljt);serviceimpljt.setEditable(false);
        yPanel.add(panel6);
        mainPanel.add(yPanel, BorderLayout.PAGE_START);
        this.add(mainPanel);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(pjtPath))
            chooseProjectPath();
        if(e.getSource().equals(xmlPath))
            xmlPath();
        if (e.getSource().equals(mapperPath))
            mapperPath();
        if (e.getSource().equals(modelPath))
            modelPath();
        if (e.getSource().equals(servicePath))
            servicePath();
        if (e.getSource().equals(serviceimplPath))
            serviceimplPath();

    }

    private void chooseProjectPath(){
        jfc = new JFileChooser(pjjt.getText());
        //FileSystemView fsv = new DirectoryRestrictedFileSystemView(new File("D:\\"));
        jfc.setFileSelectionMode(1);// 单一文件夹
        int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
        if (state == 1) {
            return;//撤销则返回
        }else{
            File f = jfc.getSelectedFile();
            ConfigUtils.updateProperties(pjjt,"project_path",f.getAbsolutePath());
        }
    }

    private void xmlPath(){
        jfc = new JFileChooser(getStanderPath(xmljt));
        jfc.setFileSelectionMode(1);// 单一文件夹
        int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
        if (state == 1) {
            return;//撤销则返回
        }else{
            File f = jfc.getSelectedFile();
            ConfigUtils.updateProperties(xmljt,"mapperxml_package",getStanderPackage(f.getAbsolutePath()));
        }
    }

    private void mapperPath(){
        jfc = new JFileChooser(getStanderPath(mapperjt));
        jfc.setFileSelectionMode(1);// 单一文件夹
        int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
        if (state == 1) {
            return;//撤销则返回
        }else{
            File f = jfc.getSelectedFile();
            ConfigUtils.updateProperties(mapperjt,"mapper_package",getStanderPackage(f.getAbsolutePath()));
        }
    }

    private void modelPath(){
        jfc = new JFileChooser(getStanderPath(modeljt));
        jfc.setFileSelectionMode(1);// 单一文件夹
        int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
        if (state == 1) {
            return;//撤销则返回
        }else{
            File f = jfc.getSelectedFile();
            ConfigUtils.updateProperties(modeljt,"model_package",getStanderPackage(f.getAbsolutePath()));
        }
    }

    private void servicePath(){
        jfc = new JFileChooser(getStanderPath(servicejt));
        jfc.setFileSelectionMode(1);// 单一文件夹
        int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
        if (state == 1) {
            return;//撤销则返回
        }else{
            File f = jfc.getSelectedFile();
            ConfigUtils.updateProperties(servicejt,"service_package",getStanderPackage(f.getAbsolutePath()));
        }
    }

    private void serviceimplPath(){
        jfc = new JFileChooser(getStanderPath(serviceimpljt));
        jfc.setFileSelectionMode(1);// 单一文件夹
        int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
        if (state == 1) {
            return;//撤销则返回
        }else{
            File f = jfc.getSelectedFile();
            ConfigUtils.updateProperties(serviceimpljt,"serviceimpl_package",getStanderPackage(f.getAbsolutePath()));
        }
    }

    private String getStanderPath(JTextField jt){
        String project_path = System.getProperty("project_path");
        String text = jt.getText();
        if (text.isEmpty()){
            return project_path;
        }
        if (text.split("\\\\").length <= 1 ){
            text = text.replaceAll("\\.","/");
            System.out.println(text);
            return project_path+"/"+srcStr+"/"+text;
        }
        return text;
    }

    private String getStanderPackage(String path){
        if (path.split("\\\\").length > 1){
            path = path.substring(path.lastIndexOf(srcStr)+4);
            System.out.println(path);
            return path.replaceAll("\\\\","\\.");
        }
        return "";
    }
}
