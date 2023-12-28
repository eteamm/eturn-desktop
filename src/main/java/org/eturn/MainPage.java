package org.eturn;

import org.eturn.data.Turn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class MainPage extends JPanel {
    private static final long serialVersionUID = 2L;

    private Frame findActiveFrame() {
        Frame[] frames = JFrame.getFrames();
        for (int i = 0; i < frames.length; i++) {
            if (frames[i].isVisible()) {
                return frames[i];
            }
        }
        return null;
    } // ищет текущий фрэйм, который работает сейсчас


    public MainPage() {
        setLayout(new BorderLayout());
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        JButton jb = new JButton("Создать очередь");
        jp.add(jb);
        JButton exitButton = new JButton("Выйти");
        jp.add(exitButton);

        ArrayList<String> name_list = new ArrayList<>(); // Массив, где лежит ФИО, статус и группа
        name_list.add("Самоваров Иван");
        name_list.add("Студент"); // Пока добавляю это вручную
        name_list.add("2391");
        JLabel label1 = new JLabel();

        String text = ""; // Запихиваю данные из массива в одну переменную
        for(int i = 0; i < name_list.size(); i++){
            text = text + name_list.get(i);
            if(i < name_list.size() - 2){
                text = text + ", ";
            }
        }

        JLabel label2 = new JLabel("ПОЛЬЗОВАТЕЛЬ:");
        label1.setText(text); // Вывожу эту переменную
        jp.add(label2);
        jp.add(label1);
        JLabel label5 = new JLabel(" ");
        jp.add(label5);
        JLabel label3 = new JLabel("ОЧЕРЕДИ:");
        jp.add(label3);
        List<Turn> allQueue = new ArrayList<>();
        Turn turn = new Turn(0, "Eturn", "Проект", "Андрей", 0, 10);
        Turn turn2 = new Turn(1, "ТОЭ", "Лабы", "Купова", 1, 17);
        allQueue.add(turn);
        allQueue.add(turn2);

        for (Turn i: allQueue) {
            text = "";
            text = "НАЗВАНИЕ: " + i.getName() + "    СОЗДАТЕЛЬ: " + i.getCreator() + "    ОПИСАНИЕ: " + i.getDescription() + "    КОЛИЧЕСТВО УЧАСТНИКОВ: " + i.getCountUsers() + " человек";
            JLabel label4 = new JLabel();
            label4.setText(text);
            label4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    jp.removeAll();
                    EditeQueue edite = new EditeQueue();
                    jp.add(edite);
                    jp.revalidate();
                    jp.repaint();
                }
            });
            jp.add(label4);
            add(jp);
        }
        jb.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    jp.removeAll();
                    CreateQueue create = new CreateQueue();
                    jp.add(create);
                    jp.revalidate();
                    jp.repaint();
                }
        });
        add(jp);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.removeAll();
                Login log = new Login();
                jp.add(log);
                jp.revalidate();
                jp.repaint();
            }
        });
    }
}
