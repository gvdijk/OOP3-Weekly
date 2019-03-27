package week4.chatprogram.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private HashSet<ServerThread> clients;

    public static void main(String[] args){ Server server = new Server(); }

    public Server() {
        clients = new HashSet<>();
        try {
            serverSocket = new ServerSocket(8000);
            while (true) {
                socket = serverSocket.accept();
                ServerThread newUser = new ServerThread(socket, this);
                clients.add(newUser);
                Thread userThread = new Thread(newUser);
                userThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(ServerThread user){
        clients.remove(user);
    }

    public void broadcast(String message){
        for(ServerThread user : clients){
            user.sendMessage(message);
        }
    }
}
