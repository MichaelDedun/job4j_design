package ru.job4j.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.log.UsageLog4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean runServer = true;
            while (runServer) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String msg = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        str = str.toLowerCase();
                        if (str.contains("hello") || str.contains("exit")) {
                            msg = str.substring(str.indexOf("=") + 1, str.indexOf("http") - 2);
                            switch (msg.toLowerCase()) {
                                case "hello":
                                    msg = "Hello, dear friend !";
                                    break;
                                case "exit":
                                    msg = "See you soon ...";
                                    runServer = false;
                                    break;
                            }
                        } else {
                            msg = str;
                        }
                        break;
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(msg.getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
    }

}
