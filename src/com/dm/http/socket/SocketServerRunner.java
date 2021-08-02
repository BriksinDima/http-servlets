package com.dm.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class SocketServerRunner {

    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(7777);
            var socket = serverSocket.accept();
            var dataOutputStream = new DataOutputStream(socket.getOutputStream());
            var dataInputStream = new DataInputStream(socket.getInputStream())) {
            System.out.println("Client request " + dataInputStream.readUTF());
            dataOutputStream.writeUTF("Hello from server!");
        }
    }
}
