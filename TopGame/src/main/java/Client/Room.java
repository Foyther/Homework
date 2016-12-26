package Client;

/**
 * Created by Nurislam on 25.12.2016.
 */
public class Room {
    ClientSocket first;
    ClientSocket second;

    public Room(ClientSocket first, ClientSocket second) {
        this.first = first;
        this.second = second;
    }

    public ClientSocket getFirst() {
        return first;
    }

    public ClientSocket getSecond() {
        return second;
    }
}
