package org.eturn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QueueScreen {
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Queue Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
                    frame.revalidate();
                    frame.repaint();
                }
            });
        }
        
        frame.add(panel);
        frame.pack();
        frame.setSize(300, 600);
        frame.setVisible(true);
    }
}