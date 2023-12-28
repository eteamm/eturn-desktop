package org.eturn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditeQueue extends JPanel{
    private static final long serialVersionUID = 2L;
    public EditeQueue() {
        setLayout(new BorderLayout());
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        JButton jb = new JButton("Сохранить");
        jp.add(jb);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                    Frame frame = findActiveFrame();
//                    if (frame!=null){
//                        frame.removeAll();
                MainPage main = new MainPage();
                jp.removeAll();
                jp.add(main);
                jp.revalidate();
                jp.repaint();
//                        frame.revalidate();
//                        frame.repaint();
//                    }
            }
        });
        add(jp);
    }
}
