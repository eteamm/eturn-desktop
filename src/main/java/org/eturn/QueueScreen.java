package org.eturn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QueueScreen extends JFrame 
{
    private JLabel queueNameLabel;
    private JLabel queueInfoLabel;
    private JList<String> queueMembersList;
    private DefaultListModel<String> queueMembersModel;
    private JButton editButton;
    private JButton deleteButton;

    public QueueScreen(String queueName, int queueSize, ArrayList<String> queueMembers) 
    {
        setTitle("Queue Screen");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        queueNameLabel = new JLabel("Queue Name: " + queueName);
        queueInfoLabel = new JLabel("Queue Size: " + queueSize);
        queueMembersModel = new DefaultListModel<>();
        for (String member : queueMembers) {
            queueMembersModel.addElement(member);
        }
        queueMembersList = new JList<>(queueMembersModel);
        JScrollPane scrollPane = new JScrollPane(queueMembersList);
        deleteButton = new JButton("Delete");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(queueNameLabel, BorderLayout.NORTH);
        add(queueInfoLabel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        editButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMember = queueMembersList.getSelectedValue();
                System.out.println("Editing member: " + selectedMember);
            }
        });

        deleteButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = queueMembersList.getSelectedIndex();
                if (selectedIndex != -1) {
                    queueMembersModel.remove(selectedIndex);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String args[]) 
    {
        String queueName = "Example Queue";
        int queueSize = 5;
        ArrayList<String> queueMembers = new ArrayList<>();
        queueMembers.add("Member 1");
        queueMembers.add("Member 2");
        queueMembers.add("Member 3");
        queueMembers.add("Member 4");
        queueMembers.add("Member 5");

        SwingUtilities.invokeLater(() -> new QueueScreen(queueName, queueSize, queueMembers));
    }
}