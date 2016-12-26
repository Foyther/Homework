package Client;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Nurislam on 25.12.2016.
 */
public class ClientSocket {
    private Socket socket;
    private ObjectOutputStream oos;

    public ClientSocket(Socket socket, ObjectOutputStream oos) {
        this.socket = socket;
        this.oos = oos;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public ObjectOutputStream getThisObjectOutputStream() {
        return this.oos;
    }
}
