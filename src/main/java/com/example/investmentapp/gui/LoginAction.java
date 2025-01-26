package com.example.investmentapp.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAction implements ActionListener {

    private LoginWindow loginWindow;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginAction(LoginWindow loginWindow, JTextField usernameField, JPasswordField passwordField) {
        this.loginWindow = loginWindow;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Проверка логина и пароля (здесь можно добавить вашу логику аутентификации)
        if (authenticate(username, password)) {
            loginWindow.dispose(); // Закрываем окно входа
            new MainAppWindow(); // Открываем главное окно
        } else {
            JOptionPane.showMessageDialog(loginWindow,
                    "Неверное имя пользователя или пароль",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    private boolean authenticate(String username, String password) {
        // логика аутентификации.
        // Например, проверить имя пользователя и пароль с теми, что хранятся в базе данных.
        return "user".equals(username) && "12345".equals(password); // Пример проверки
    }

}
