package com.example.investmentapp.gui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class UserRegistrationGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;

    public UserRegistrationGUI(){
        setTitle("Регистрация пользователя");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,2));

        JLabel usernameLabel = new JLabel("Имя пользователя");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Пароль");
        passwordField = new JPasswordField();
        JLabel emailLabel = new JLabel("Электронная почта");
        emailField = new JTextField();

        JButton registerButton = new JButton("Зарегистрироваться");
        registerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                registerUser();
            }
        });

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(emailLabel);
        add(emailField);
        add(registerButton);

        pack(); // Автоматическая подстройка размеров окна
        setVisible(true);
    }

    private void registerUser(){
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();

        try{
            URL url = new URL("http://localhost:8080/api/register");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = String.format("{\"username\":\"%s\",\"password\":\"%s\",\"email\":\"%s\"}", username, password, email);
            try(OutputStream os = conn.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input,0,input.length);
            }

            int responseCode = conn.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                JOptionPane.showMessageDialog(this,"Пользователь успешно зарегистрирован!");
            }else{
                //Чтение сообщения об ошибке из ответа сервера

                StringBuilder errorResponse = new StringBuilder();
                try(BufferedReader in = new BufferedReader(new InputStreamReader(conn.getErrorStream()))){
                    String inputLine;
                    while((inputLine = in.readLine()) != null){
                        errorResponse.append(inputLine);
                    }
                }
                JOptionPane.showMessageDialog(this,"Ошибка регистрации:"+ responseCode + "\n" + errorResponse.toString());
            }

            conn.disconnect();
        }catch (Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,"Произошла ошибка" + ex.getMessage());
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(UserRegistrationGUI::new);
    }
    
}
