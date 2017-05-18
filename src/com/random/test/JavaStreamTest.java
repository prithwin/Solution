package com.random.test;

import sun.net.TelnetInputStream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pr250155 on 5/17/17.
 */
public class JavaStreamTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        while(true) {
            Socket socket = serverSocket.accept();
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            InputStreamReader reader = new InputStreamReader(bis);
            char[] buffer = new char[100000];
            reader.read(buffer);
            String url = new String(buffer);
            System.out.println(url);
            byte[] response = "HTTP/1.1 200 OK\nContent-Length: 51\nContent-Type: text/html\nConnection: Closed\n<html><head></head><body>chowbakasoma</body></html>".getBytes();
            bos.write(response);
            bos.flush();
            socket.close();
        }

    }
}
