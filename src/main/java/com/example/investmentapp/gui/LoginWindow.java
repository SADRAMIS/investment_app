package com.example.investmentapp.gui;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginWindow(){
        setTitle("Вход в систему");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2));

        JLabel usernameLabel = new JLabel("Имя пользователя:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Пароль");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Войти");
        loginButton.addActionListener(new LoginAction(this,usernameField,passwordField));

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(LoginWindow::new);
    }
}
