package week4.chatprogram.client2;

import java.io.*;
import java.net.Socket;

public class ClientThread2 implements Runnable{

    private ClientView2 view;
    private BufferedReader input;
    private BufferedWriter output;

    public ClientThread2(String host, int port, String name, ClientView2 view) {
        this.view = view;
        try {
            Socket socket = new Socket(host, port);
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch (IOException e){
            e.printStackTrace();
        }
        sendMessage(name);
    }

    @Override
    public void run() {
        String line;
        try {
            while ((line = input.readLine()) != null){
                System.out.println("Received new line: " + line);
                view.updateChatHistory(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message){
        try {
            System.out.println("Writing message to server: " + message);
            output.write(message + "\n");
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
