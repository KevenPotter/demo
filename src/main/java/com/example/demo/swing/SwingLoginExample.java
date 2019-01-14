package com.example.demo.swing;

import javax.swing.*;

public class SwingLoginExample {
    public static void main(String[] args) {
        // 创建JFrame实例
        JFrame jFrame = new JFrame("Login Example");
        // 设置宽高值
        jFrame.setSize(350, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 创建面板,这个类似于HTML的DIV标签.我们可以创建多个面板并在JFrame中指定位置.面板中我们可以添加文本字段,按钮及其他组件
        JPanel jPanel = new JPanel();
        // 添加面板
        jFrame.getContentPane().add(jPanel);
        // 调用用户定义的方法并添加组件到面板
        placeComponent(jPanel);
        // 设置界面可见
        jFrame.setVisible(true);
    }

    private static void placeComponent(JPanel jPanel) {
        // 布局部分我们这边不多做介绍,这边设置布局为null
        jPanel.setLayout(null);
        // 创建JLabel
        JLabel userLabel = new JLabel("User:");
        // 这个方法定义了组件的位置.setBounds(x,y,width,height)x和y指定左上角的新位置,由width和height指定新的大小
        userLabel.setBounds(10, 20, 80, 25);
        jPanel.add(userLabel);
        // 创建文本域用于用户输入
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        jPanel.add(userText);
        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 165, 25);
        jPanel.add(passwordLabel);
        // 这个类似用于输入的文本域.但是输入的信息会以点号代替.用于包含密码的安全性
        JPasswordField jPasswordField = new JPasswordField(20);
        jPasswordField.setBounds(100, 50, 165, 25);
        jPanel.add(jPasswordField);
        // 创建登录按钮
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        jPanel.add(loginButton);
    }
}
