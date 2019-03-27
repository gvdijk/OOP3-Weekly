package week4.chatprogram.server;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {

    private String name;
    private Socket socket;
    private Server server;
    private BufferedWriter output;
    private BufferedReader input;

    public ServerThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        try {
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = input.readLine();
            System.out.println("Established connection with new user: " + name);
            server.broadcast(name + " has joined the chat!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String line;
        try {
            while ((line = input.readLine()) != null){
                System.out.println("Received message: " + line);
                if(line.endsWith("ByeBye")){
                    server.broadcast(name + " has left the chat :(");
                    break;
                }
                server.broadcast(name + ": " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //End of the connection
        System.out.println("User " + name + " Disconnecting");
        server.removeUser(this);
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        String chatMessage = message + "\n";
        try {
            output.write(chatMessage);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
