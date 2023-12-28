package org.eturn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextArea jta = new JTextArea(
            "Scroll bar will appear, when much text");
    public Main() {
        Container c = getContentPane(); // клиентская область окна
        c.setLayout(new BorderLayout()); // выбираем компоновщик
        // добавляем какие-нибудь дочерние элементы
        //MyComponent child = new MyComponent();
        Login log = new Login();
        c.add(log);
        // -------------------------------------------
        // настройка окна
        setTitle("Example window"); // заголовок окна
        // желательные размеры окна
        setPreferredSize(new Dimension(640, 480));
        // завершить приложение при закрытии окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // устанавливаем желательные размеры
        setVisible(true); // отображаем окно
    }

    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getActionCommand().equals("Add text"))
            jta.append(" Add text\\n");
        if (arg0.getActionCommand().equals("Clear text"))
            jta.setText("");

        // если ссылки на объекты сохранены можно сравнивать
        // по объектам, например для JButton jbOK= new JBUtton("Ok");
        // то сравнение будет таким
        //    if(arg0.getSource().equals(jbOK))
    }


    public static void main(String[] args) {
//        System.out.println("Hello world!");
        new Main();
    }
}