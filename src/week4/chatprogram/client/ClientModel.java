package week4.chatprogram.client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientModel {

    Socket socket;
    String host;
    int port;
    DataInputStream input;
    DataOutputStream output;

    public ClientModel(String host, int port) {
        this.host = host;
        this.port = port;
        init();
    }

    private void init(){
        try {
            socket = new Socket(host, port);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String message){
        try {
            output.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveMessage(){

    }
}
