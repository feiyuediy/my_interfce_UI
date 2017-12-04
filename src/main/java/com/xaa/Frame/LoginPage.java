package com.xaa.Frame;

import com.xaa.Utils.LoginApi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    JTextField username;
    JPasswordField jPasswordField;
    JButton loginButtion;
    JButton cancelButton;

    public LoginPage(){
        super("登录");

        //等到容器
        Container container = getContentPane();
        container.setLayout(new GridLayout(4,2,2,2));
        setLocationRelativeTo(getOwner());

        username = new JTextField(16);
        jPasswordField = new JPasswordField(16);
        loginButtion = new JButton("登录");

        //环境
        container.add(new JLabel("      环境："));
        JComboBox<String> comboBox=new JComboBox<String>();
        comboBox.addItem("测试环境");
        comboBox.addItem("开发环境");
        comboBox.addItem("预发布环境");
        comboBox.addItem("正式环境");


        loginButtion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String evn = comboBox.getSelectedItem().toString();
                System.out.println(evn);
                String user = username.getText();
                String  pw = new String(jPasswordField.getPassword());
                try{
                    LoginApi loginApi = new LoginApi(evn,user,pw);
                    new MainFrame(loginApi.getToken());
                    LoginPage.this.setVisible(false);
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(LoginPage.this,"账号密码不正确");
                }
            }
        });
        cancelButton = new JButton("退出");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        container.add(comboBox);

        container.add(new JLabel("      用户名："));
        container.add(username);
        container.add(new JLabel("      密码："));
        container.add(jPasswordField);
        container.add(loginButtion);
        container.add(cancelButton);

        setResizable(false);
        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new LoginPage();
    }
}
