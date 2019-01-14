package com.example.demo.swing;

import javax.swing.*;
import java.awt.*;

public class DeviceSignalSwing {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("设备信号生成器");
        jFrame.setBounds(300, 100, 500, 433);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.white);
        placeComponent(jPanel);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    private static void placeComponent(JPanel jPanel) {
        jPanel.setLayout(null);
        JLabel deviceIdLabel = new JLabel("DeviceId:");
        JTextField deviceIdText = new JTextField(20);
        JLabel versionLabel = new JLabel("Version:");
        JTextField versionText = new JTextField(20);
        deviceIdLabel.setBounds(10, 20, 200, 25);
        deviceIdText.setBounds(100, 20, 200, 25);
        versionLabel.setBounds(10, 40, 200, 25);
        versionText.setBounds(100, 40, 200, 25);
        jPanel.add(deviceIdLabel);
        jPanel.add(deviceIdText);
        jPanel.add(versionLabel);
        jPanel.add(versionText);
        JButton createSignal = new JButton("Create Signal");
        createSignal.setBounds(180, 190, 130, 25);
        jPanel.add(createSignal);
    }
}
