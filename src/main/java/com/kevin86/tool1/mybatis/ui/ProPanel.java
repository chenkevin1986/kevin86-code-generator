package com.kevin86.tool1.mybatis.ui;

import com.kevin86.tool1.mybatis.MyBatisPathConfig;
import com.kevin86.tool1.mybatis.manager.ProManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengang on 2016/3/15.
 */
public class ProPanel implements ActionListener {

    private ProPanel(){
    }



    private static final class Singleton{
        protected static final ProPanel excelUi = new ProPanel();
    }
    public static ProPanel getInstance(){
        return Singleton.excelUi;
    }

    public Component initUI(){
        return createTotalPanel();
    }
    private Component createTotalPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(checkboxPancel1(),BorderLayout.NORTH);
        mainPanel.add(checkboxPancel2(),BorderLayout.CENTER);
        mainPanel.add(inputPanel(),BorderLayout.SOUTH);
        return mainPanel;
    }
    private JButton jb = new JButton("确认生成");
    private JTextField jt = new JTextField(15);

    public JPanel inputPanel(){
        JPanel p1 = new JPanel();
        p1.setBorder(new EmptyBorder(0,0,200,0));
        p1.add(jt,BorderLayout.WEST);
        jt.setToolTipText("输入tableName");
        p1.add(jb,BorderLayout.CENTER);
        jb.addActionListener(this);
        return p1;
    }
    JCheckBox cb0,cb1, cb2, cb3, cb4,cb5;
    static List<Integer> cbNums = new ArrayList<Integer>();
    static List<JCheckBox> cbs = new ArrayList<JCheckBox>();
    static {
        for (int i = 0; i < 6; i++) {
            cbNums.add(i);
        }
    }
    public JPanel checkboxPancel1(){
        JPanel p1 = new JPanel();
        p1.setBorder(new EmptyBorder(0,20,0,0));
        cb0 = new JCheckBox("全选",true);cb0.addActionListener(this);p1.add(cb0);cbs.add(cb0);
        cb1 = new JCheckBox("生成xml",true);cb1.addActionListener(this);p1.add(cb1);cbs.add(cb1);
        cb2 = new JCheckBox("生成mapper类",true);cb2.addActionListener(this);p1.add(cb2);cbs.add(cb2);
        return p1;
    }

    public JPanel checkboxPancel2(){
        JPanel p2 = new JPanel();
        p2.setBorder(new EmptyBorder(0,20,0,0));
        cb3 = new JCheckBox("生成Model类",true);cb3.addActionListener(this);p2.add(cb3);cbs.add(cb3);
        cb4 = new JCheckBox("生成service类",true);cb4.addActionListener(this);p2.add(cb4);cbs.add(cb4);
        cb5 = new JCheckBox("生成serviceImp类",true);cb5.addActionListener(this);p2.add(cb5);cbs.add(cb5);
        return p2;
    }

    final MyBatisPathConfig config = new MyBatisPathConfig();

    private void product(){
        ProManager.getInstance().proPjtMapperXml(config,jt.getText(),cbNums);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jb)){
            product();
        }
        if(e.getSource().equals(cb0)){
            if(cb0.isSelected()){
                if (cbNums.size()< 6){
                    cbNums.clear();
                    for (int i = 0; i < cbs.size(); i++) {
                        JCheckBox box = cbs.get(i);
                        box.setSelected(true);
                        if (!cbNums.contains(Integer.valueOf(i))){
                            cbNums.add(i);
                        }
                    }
                }
            }else{
                for (int i = 0; i < cbs.size(); i++) {
                    JCheckBox box = cbs.get(i);
                    box.setSelected(false);
                }
                cbNums.clear();
            }
        }
        if (e.getSource().equals(cb1)){
            selectBoxEvent(cb1);
        }
        if (e.getSource().equals(cb2)){
            selectBoxEvent(cb2);
        }
        if (e.getSource().equals(cb3)){
            selectBoxEvent(cb3);
        }
        if (e.getSource().equals(cb4)){
            selectBoxEvent(cb4);
        }
        if (e.getSource().equals(cb5)){
            selectBoxEvent(cb5);
        }
        System.err.println(cbNums);
    }

    private void selectBoxEvent(JCheckBox commonBox){
        if (commonBox.isSelected()){
            for (int i = 0; i < cbs.size(); i++) {
                JCheckBox box = cbs.get(i);
                if (box == commonBox){
                    if (!cbNums.contains(Integer.valueOf(i))){
                        cbNums.add(i);
                    }
                    commonBox.setSelected(true);
                    break;
                }
            }
            addAllSelectBtn();
        }else {
            for (int i = 0; i < cbs.size(); i++) {
                JCheckBox box = cbs.get(i);
                if ( box == commonBox){
                    if (cbNums.contains(Integer.valueOf(i))){
                        cbNums.remove(Integer.valueOf(i));
                    }
                    commonBox.setSelected(false);
                    break;
                }
            }
            if (cb0.isSelected()){
                cbNums.remove(Integer.valueOf(0));
                cb0.setSelected(false);
            }
        }
    }

    private void addAllSelectBtn(){
        if (cbNums.size()==5){
            if (!cbNums.contains(Integer.valueOf(0))){
                cbNums.add(0);
            }
            cb0.setSelected(true);
        }
    }


}
