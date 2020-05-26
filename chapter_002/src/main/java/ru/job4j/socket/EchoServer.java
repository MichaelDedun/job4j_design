package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean runServer = true;
            while (runServer) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("Bye")) {
                            System.out.println("server has been stopped");
                            out.write("server has been stopped\r\n\\".getBytes());
                            runServer = false;
                        }
                    }
                    if (!server.isClosed()) {
                        out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                    }
                }
            }
        }
    }

}
