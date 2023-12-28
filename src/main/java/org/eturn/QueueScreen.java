package org.eturn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import org.eturn.data.Position;
public class QueueScreen extends JPanel 
{
    private static final long serialVersionUID = 2L;
    public QueueScreen()
    {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel queuePanel = new JPanel(new GridLayout(0, 1));
        
        JLabel queueNameLabel = new JLabel("Queue Name: MyQueue");
        panel.add(queueNameLabel, BorderLayout.NORTH);
        panel.add(queuePanel, BorderLayout.CENTER);
        ArrayList<Position> positions = new ArrayList<Position>();
        Position p1 = new Position(1L, "Ваня", "2391", false, 1, 12L);
        Position p2 = new Position(2L, "Юра", "2391", false, 2, 13L);
        positions.add(p1);
        positions.add(p2);
        Long curID = 12L; // наш принимаемый айди из файла
        for (Position position : positions) 
        {
            JPanel elementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JButton deleteButton = new JButton("Delete");
            JLabel label = new JLabel(position.getName());
            elementPanel.add(label);
            elementPanel.add(deleteButton);
            queuePanel.add(elementPanel);
            if (curID == position.getUserId()) // тут нужно сделать принятие юзер айди из файла, 
            //чтобы удалять конкретную позицию(т.е. человек удаляет свою позицию - делаем не для админа, а для пользователя)
            {
                deleteButton.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent e) 
                    {
                        queuePanel.remove(elementPanel);
                        revalidate();
                        repaint();
                    }
                });
            }
        }
        JButton jb = new JButton("назад");
        add(jb);
        jb.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                removeAll();
                MainPage main = new MainPage();
                add(main);
                revalidate();
                repaint();
            }
        });

        add(panel);
        setSize(300, 600);
        setVisible(true);
    }
}