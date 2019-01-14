package com.example.demo.swing;


import javax.swing.*;
import java.awt.*;

public class JFrameDemo1 extends JFrame {

    public JFrameDemo1() {
        setTitle("Java第一个GUI程序");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jLabel = new JLabel("这是使用JFrame类创建的窗口");
        Container c = getContentPane();
        c.add(jLabel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JFrameDemo1();
    }
}
