package Client;

import Server.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Nurislam on 24.12.2016.
 */
public class ClientThread extends Thread {

    public final static String HELLO_MESSAGE = "User joined to the chat";

    private Socket socket;
    private boolean isFirst;
    private CyclicBarrier cyclicBarrier;
    private Settings settings;


    public ClientThread(Socket socket, CyclicBarrier cyclicBarrier, boolean isFirst, Settings settings) {
        this.socket = socket;
        this.cyclicBarrier = cyclicBarrier;
        this.isFirst = isFirst;
        this.settings = settings;
    }


    public void run() {
        try {
            int i = isFirst ? 1 : 2;
            Main.write("User " + 2 + " connected!");
            ObjectInputStream inputStream = new ObjectInputStream(this.socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(this.socket.getOutputStream());

            outputStream.writeObject(settings);
            if (isFirst) {
                outputStream.writeObject(settings.getFirst());
            } else
                outputStream.writeObject(settings.getSecond());

            while (true) {
                Object readSettClient = inputStream.readObject();
                if (Engine.check(isFirst, (SettingsClient) readSettClient)) {
                    outputStream.writeObject(settings);
                    if (isFirst) {
                        outputStream.writeObject(settings.getFirst());
                    } else outputStream.writeObject(settings.getSecond());
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

