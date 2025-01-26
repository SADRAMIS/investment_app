package com.example.investmentapp.gui;

import javax.swing.*;
import java.awt.*;

public class MainAppWindow extends JFrame {
    public MainAppWindow(){
        setTitle("Главное окно приложения");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Добро пожаловать в приложение для инвестиций", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);

        JButton logoutButton = new JButton("Выйти");
        logoutButton.addActionListener(e -> {
            dispose();
            new LoginWindow();
        });

        add(logoutButton,BorderLayout.SOUTH);

        setVisible(true);

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(MainAppWindow::new);
    }
}
