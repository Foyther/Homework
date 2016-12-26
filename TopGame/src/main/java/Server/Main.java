package Server;

import Client.ClientThread;
import Client.Room;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Nurislam on 24.12.2016.
 */
public class Main {
    public static final int PORT = 1234;
    private static ArrayList<Room> rooms;
    private static CyclicBarrier cyclicBarrier;
    private static Settings match = new Settings(new SettingsClient(), new SettingsClient());


    public static void main(String[] args) {
        ServerSocket socketListener = null;
        cyclicBarrier = new CyclicBarrier(2);
        try {
            socketListener = new ServerSocket(PORT);
            int i = 1;
            while (i < 3) {
                i++;
                Socket client = socketListener.accept();
                if(i == 1) {
                    new ClientThread(client, cyclicBarrier, true, match); //Создаем новый поток, которому передаем сокет
                } else new ClientThread(client, cyclicBarrier, false, match);

            }
            while (true){}
        } catch (SocketException e) {
            System.err.println("Socket exception");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O exception");
            e.printStackTrace();
        } finally {
            try {
                socketListener.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void write(String str){
        System.out.println(str);
    }

    public static ArrayList<Room> getRooms() {
        return rooms;
    }

    public static CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public static Settings getMatch() {
        return match;
    }

}
