package week4.chatprogram.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket socket;

    public static void main(String[] args){ Server server = new Server(); }

    public Server() {
        try {
            serverSocket = new ServerSocket(8000);
            socket = serverSocket.accept();

            Thread userThread = new Thread(new UserThread(socket, this));
            userThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
