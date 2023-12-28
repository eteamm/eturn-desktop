package org.eturn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class QueueScreen extends JPanel 
{
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private static final long serialVersionUID = 2L;
    public QueueScreen()
    {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel queuePanel = new JPanel(new GridLayout(0, 1));
        
        JLabel queueNameLabel = new JLabel("Queue Name: MyQueue");
        panel.add(queueNameLabel, BorderLayout.NORTH);
        panel.add(queuePanel, BorderLayout.CENTER);
        for (int i = 1; i <= 10; i++) 
        {
            JPanel elementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JButton deleteButton = new JButton("Delete");
            JLabel label = new JLabel("Element " + i);
            elementPanel.add(label);
            elementPanel.add(deleteButton);
            queuePanel.add(elementPanel);
            
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