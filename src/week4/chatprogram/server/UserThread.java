package week4.chatprogram.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UserThread implements Runnable {

    private Server server;
    private OutputStreamWriter output;
    private InputStreamReader input;

    public UserThread(Socket socket, Server server) {
        this.server = server;
        try {
            output = new OutputStreamWriter(socket.getOutputStream());
            input = new InputStreamReader(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }
}
