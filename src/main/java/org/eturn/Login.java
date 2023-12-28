package org.eturn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JPanel{
    private static final long serialVersionUID = 2L;
    public Login() {
        JFrame frame = new JFrame("Login");
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        JPanel jpButton = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 800);

        JTextArea textMainTop1 = new JTextArea("Авторизация");
        Font MainFont1 = new Font(null, Font.BOLD, 15);
        textMainTop1.setFont(MainFont1);
        JTextArea textMainTop2 = new JTextArea("Логин:");
        JTextField addLog = new JTextField();
        JTextArea textDescription = new JTextArea("Пароль:");
        JTextField addPass = new JTextField();
        JButton loginButton = new JButton("войти");

        jp.add(textMainTop1);
        jp.add(textMainTop2);
        jp.add(addLog);
        jp.add(textDescription);
        jp.add(addPass);
        jp.add(loginButton);
        frame.getContentPane().add(BorderLayout.NORTH, jp);
        frame.getContentPane().add(BorderLayout.CENTER, jpButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage main = new MainPage();
                jp.removeAll();
                jp.add(main);
                jp.revalidate();
                jp.repaint();
            }
        });
        add(jp);
    }
}
