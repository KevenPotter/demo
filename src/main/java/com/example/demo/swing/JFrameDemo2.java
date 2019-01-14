package com.example.demo.swing;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo2 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Java第二个GUI程序");
        jFrame.setBounds(300, 100, 400, 200);
        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel("这是放在JPanel上的标签");
        jPanel.setBackground(Color.white);
        jPanel.add(jLabel);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }
}
