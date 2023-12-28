package org.eturn;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

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

        Action actionLog = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                File file = new File("Login.txt");
                try (Writer writer = new BufferedWriter(new FileWriter(file)))
                {
                    writer.write(addLog.getText());
                }
                catch (IOException err)
                {
                    err.printStackTrace();
                }
            }
        };
        addLog.addActionListener(actionLog);

        String login = "";
        try
        {
            FileReader fr = new FileReader("Login.txt");
            BufferedReader reader = new BufferedReader(fr);
            login = reader.readLine();
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
        System.out.println(login);

        JTextArea textDescription = new JTextArea("Пароль:");
        JTextField addPass = new JTextField();

        Action actionPass = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                File file = new File("Pass.txt");
                try (Writer writer = new BufferedWriter(new FileWriter(file)))
                {
                    writer.write(addPass.getText());
                }
                catch (IOException err)
                {
                    err.printStackTrace();
                }
            }
        };
        addPass.addActionListener(actionPass);

        String password = "";
        try
        {
            FileReader fr = new FileReader("Pass.txt");
            BufferedReader reader = new BufferedReader(fr);
            password = reader.readLine();
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
        System.out.println(password);

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
