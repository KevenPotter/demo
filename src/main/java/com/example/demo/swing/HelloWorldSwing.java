package com.example.demo.swing;

import javax.swing.*;

public class HelloWorldSwing {
    /**
     * 创建并显示GUI.处于线程安全的考虑,这个方法在时间调用线程中调用
     */
    private static void createAndShowGUI() {
        // 确保一个漂亮的外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);
        // 创建及设置窗口
        JFrame jFrame = new JFrame("Hello World Swing");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 添加"Hello World"标签
        JLabel jLabel = new JLabel("Hello World");
        jFrame.getContentPane().add(jLabel);
        // 显示窗口
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        // 显示应用GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
