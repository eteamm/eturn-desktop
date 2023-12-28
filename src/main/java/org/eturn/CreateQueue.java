package org.eturn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateQueue extends JPanel {

    public CreateQueue() {

        JFrame frame = new JFrame("Create Queue");
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        JPanel jpButton = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 800);

        JTextArea textMainTop1 = new JTextArea("Создать");
        Font MainFont1 = new Font(null, Font.BOLD, 15);
        textMainTop1.setFont(MainFont1);
        JTextArea textMainTop2 = new JTextArea("название очереди:");
        JTextField addName = new JTextField();
        JTextArea textDescription = new JTextArea("описание очереди:");
        JTextField addDescription = new JTextField();
        JButton createButton = new JButton("создать");
        JButton cancelButton = new JButton("отмена");

        jp.add(textMainTop1);
        jp.add(textMainTop2);
        jp.add(addName);
        jp.add(textDescription);
        jp.add(addDescription);
        jp.add(createButton);
        jp.add(cancelButton);
        frame.getContentPane().add(BorderLayout.NORTH, jp);
        frame.getContentPane().add(BorderLayout.CENTER, jpButton);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditeQueue edite = new EditeQueue();
                jp.removeAll();
                jp.add(edite);
                jp.revalidate();
                jp.repaint();
            }
        });
        add(jp);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage main = new MainPage();
                jp.removeAll();
                jp.add(main);
                jp.revalidate();
                jp.repaint();
            }
        });
    }
}
