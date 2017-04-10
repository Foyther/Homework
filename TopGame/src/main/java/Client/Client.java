package Client;

import Server.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

/**
 * Created by Nurislam on 24.12.2016.
 */
public class Client extends JPanel implements KeyListener, ActionListener {
    private static final String ADDRESS = "localhost";
    private static Socket s;
    private static ObjectOutputStream oout;
    private static ObjectInputStream oin;

    private static Settings settings;
    private static SettingsClient clientDate;


    private boolean upPressed = false;
    private boolean downPressed = false;

    public Client() {
        setBackground(Color.BLACK);

        setFocusable(true);
        addKeyListener(this);

        //call step() 60 fps
        Timer timer = new Timer(1000/60, this);
        timer.start();
    }

    public static boolean isReady(){
        if(settings != null && clientDate != null){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
//        javax.swing.SwingUtilities.invokeLater(Client::draw);

        try {

            s = new Socket(ADDRESS, Main.PORT);
            oin = new ObjectInputStream(s.getInputStream());
            oout = new ObjectOutputStream(s.getOutputStream());

            Object readSett = oin.readObject();
            if(readSett instanceof Settings){
                settings = (Settings) readSett;
            }

            Object readSettClient = oin.readObject();
            if(readSettClient instanceof SettingsClient){
                clientDate = (SettingsClient) readSettClient;
            }



            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        if(isReady()) {
                            draw();
                            break;
                        }
                    }
                }
            });
            thread.start();



            while (true) {
                oout.writeObject(clientDate);

                Object readSett2 = oin.readObject();
                if(readSett2 instanceof Settings){
                    settings = (Settings) readSett2;
                }

                Object readSettClient2 = oin.readObject();
                if(readSettClient2 instanceof SettingsClient){
                    clientDate = (SettingsClient) readSettClient2;
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void draw() {
        JFrame frame = new JFrame("Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Client());
        frame.setBounds(200, 200, 500, 600);
        frame.setVisible(true);
    }

    private void step() throws IOException {
        if (settings.isPlaying()) {
            //move player
            if (upPressed) {
                if (clientDate.getPlayerY() - settings.getPaddleSpeed() > 0) {
                    clientDate.setPlayerY(clientDate.getPlayerY()-settings.getPaddleSpeed()); //playerTwoY -= paddleSpeed;
                }
            }
            if (downPressed) {
                if (clientDate.getPlayerY() - settings.getPaddleSpeed() + clientDate.getPlayerHeight() < getHeight()) {
                    clientDate.setPlayerY(clientDate.getPlayerY()+settings.getPaddleSpeed()); //playerTwoY += paddleSpeed;
                }
            }
        }
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            step();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(Color.WHITE);

        if (settings.isPlaying()) {


            int playerOneRight = settings.getFirst().getPlayerX() + settings.getFirst().getPlayerWidth();
            int playerTwoLeft = settings.getSecond().getPlayerX();

            //draw dashed line down center
            for (int lineY = 0; lineY < getHeight(); lineY += 50) {
                g.drawLine(250, lineY, 250, lineY + 25);
            }

            //draw "goal lines" on each side
            g.drawLine(playerOneRight, 0, playerOneRight, getHeight());
            g.drawLine(playerTwoLeft, 0, playerTwoLeft, getHeight());

            //draw the scores

            g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
            g.drawString(String.valueOf(Score.first), 100, 100);
            g.drawString(String.valueOf(Score.second), 400, 100);

            //draw the ball
            g.fillOval(settings.getBallX(), settings.getBallY(), settings.getDiameter(), settings.getDiameter());

            //draw the paddles
            g.fillRect(settings.getFirst().getPlayerX(), settings.getFirst().getPlayerY(), settings.getFirst().getPlayerWidth(), settings.getFirst().getPlayerHeight());
            g.fillRect(settings.getSecond().getPlayerX(), settings.getSecond().getPlayerY(), settings.getSecond().getPlayerWidth(), settings.getSecond().getPlayerHeight());

        } else if (settings.isGameOver()) {

            g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
            g.drawString(String.valueOf(Score.first), 100, 100);
            g.drawString(String.valueOf(Score.second), 400, 100);

            if (Score.first > Score.second) {
                g.drawString("Player 1 Wins!", 165, 200);
            } else {
                g.drawString("Player 2 Wins!", 165, 200);
            }
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (settings.isPlaying()) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = true;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        if (settings.isPlaying()) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = false;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = false;
            }
        }
    }
}
