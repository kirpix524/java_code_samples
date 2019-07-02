package ru.surovcevnv.codesamples;

import com.mysql.cj.jdbc.JdbcStatement;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.JDBCType;
import java.util.ArrayList;

public class NetSample extends JFrame {

    public NetSample() {
        setTitle("Net sample");
        setBounds(100, 100, 1000, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                initServer();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                initClient();
            }
        }).start();
    }

    private void initServer() {
        try (
                ServerSocket serverSocket = new ServerSocket(8888);
                Socket socket = serverSocket.accept()
            ) {
            serverSocket.setSoTimeout(3000);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String b = in.readUTF();
            System.out.println("Server accepted data: " + b);
            out.writeUTF(b+ " echo");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void initClient() {
        try ( Socket socket = new Socket("127.0.0.1", 8888)) {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String msg = "Message from client";
            System.out.println("Client sends data: "+msg);
            out.writeUTF(msg);
            String ans = in.readUTF();
            System.out.println("Client recieved data: "+ans);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
