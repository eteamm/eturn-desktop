package org.eturn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eturn.data.Turn;
import org.eturn.data.User;
import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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


    public MainPage()  {
        String UserID = "";
        try
        {
            FileReader fr = new FileReader("UserID.txt");
            BufferedReader reader = new BufferedReader(fr);
            UserID = reader.readLine();
        }
        catch (IOException e)
        {
            System.err.println(e);
        }

        System.out.println(UserID);
        HttpClient client1 = HttpClient.newHttpClient();
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create("http://90.156.229.190:8089/turn?userId="+UserID+"&type=edu&access=participates"))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .build();
        CompletableFuture<HttpResponse<String>> responseGlobal1 = client1.sendAsync(request1, HttpResponse.BodyHandlers.ofString());
        String body1=null;
        try {
            body1=responseGlobal1.thenApply(HttpResponse::body).get(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
        List<Turn> turns = null;
        ObjectMapper objectMapper1=new ObjectMapper();
        try {
            turns = Arrays.asList(objectMapper1.readValue(body1, Turn[].class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        setLayout(new BorderLayout());
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        JButton jb = new JButton("Создать очередь");
        jp.add(jb);
        JButton exitButton = new JButton("Выйти");
        jp.add(exitButton);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://90.156.229.190:8089/user/"+UserID))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .build();
        CompletableFuture<HttpResponse<String>> responseGlobal = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        String body=null;
        try {
            body=responseGlobal.thenApply(HttpResponse::body).get(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper objectMapper=new ObjectMapper();
        User user = null;
        try {
            user = objectMapper.readValue(body, User.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String name = user.getName();
        JLabel label1 = new JLabel();

        String text = user.getName()+" "+user.getGroup(); // Запихиваю данные из массива в одну переменную


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

        for (Turn i: turns) {
            text = "";
            text = "НАЗВАНИЕ: " + i.getName() + "    СОЗДАТЕЛЬ: " + i.getCreator() + "    ОПИСАНИЕ: " + i.getDescription() + "    КОЛИЧЕСТВО УЧАСТНИКОВ: " + i.getCountUsers() + " человек";
            JLabel label4 = new JLabel();
            label4.setText(text);
            label4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    File file = new File("turnID.txt");
                    try (Writer writer = new BufferedWriter(new FileWriter(file)))
                    {
                        String str = String.valueOf(i.getId());
                        writer.write(str);
                    }
                    catch (IOException err)
                    {
                        err.printStackTrace();
                    }
                    jp.removeAll();
                    QueueScreen q = new QueueScreen();
                    jp.add(q);
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
