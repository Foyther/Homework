package Server;

import Server.Settings;

/**
 * Created by Nurislam on 25.12.2016.
 */
public class Engine {
    static Settings settingOfTheGame;

    static synchronized public boolean check(boolean isFirst, SettingsClient sc){
        if(isFirst){
            settingOfTheGame.setFirst(sc);
        } else
            settingOfTheGame.setSecond(sc);

        int first = Score.first;
        int second = Score.second;
        proccessGame();
        if(first != Score.first || second != Score.second){
            return true;
        }
        return false;
    }

    static public void proccessGame(){
        //where will the ball be after it moves?
        int nextBallLeft = settingOfTheGame.getBallX() + settingOfTheGame.getBallDeltaX();
        int nextBallRight = settingOfTheGame.getBallX() + settingOfTheGame.getDiameter() + settingOfTheGame.getBallDeltaX();
        int nextBallTop = settingOfTheGame.getBallY() + settingOfTheGame.getBallDeltaY();
        int nextBallBottom = settingOfTheGame.getBallY() + settingOfTheGame.getDiameter() + settingOfTheGame.getBallDeltaY();

        int playerOneRight = settingOfTheGame.getFirst().getPlayerX() + settingOfTheGame.getFirst().getPlayerX();
        int playerOneTop = settingOfTheGame.getFirst().getPlayerY();
        int playerOneBottom = settingOfTheGame.getFirst().getPlayerY() + settingOfTheGame.getFirst().getPlayerHeight();

        float playerTwoLeft = settingOfTheGame.getSecond().getPlayerX();
        float playerTwoTop = settingOfTheGame.getSecond().getPlayerY();
        float playerTwoBottom = settingOfTheGame.getSecond().getPlayerY() + settingOfTheGame.getSecond().getPlayerHeight();

        //ball bounces off top and bottom of screen
        if (nextBallTop < 0 || nextBallBottom > 600) {
            settingOfTheGame.setBallDeltaY(settingOfTheGame.getBallDeltaY()*(-1));
        }

        //will the ball go off the left side?
        if (nextBallLeft < playerOneRight) {
            //is it going to miss the paddle?
            if (nextBallTop > playerOneBottom || nextBallBottom < playerOneTop) {

                Score.second++;

                if (Score.second == 3) {
                    settingOfTheGame.setPlaying(false);
                    settingOfTheGame.setGameOver(true);
                }

                settingOfTheGame.setBallX(250);
                settingOfTheGame.setBallY(250);
            } else {
                settingOfTheGame.setBallDeltaX(settingOfTheGame.getBallDeltaX()*(-1));
            }
        }

        //will the ball go off the right side?
        if (nextBallRight > playerTwoLeft) {
            //is it going to miss the paddle?
            if (nextBallTop > playerTwoBottom || nextBallBottom < playerTwoTop) {

                Score.first++;

                if (Score.first == 3) {
                    settingOfTheGame.setPlaying(false);
                    settingOfTheGame.setGameOver(true);
                }

                settingOfTheGame.setBallX(250);
                settingOfTheGame.setBallY(250);
            } else {
                settingOfTheGame.setBallDeltaX(settingOfTheGame.getBallDeltaX()*(-1));
            }
        }

        //move the ball
        settingOfTheGame.setBallX(settingOfTheGame.getBallX()+settingOfTheGame.getBallDeltaX()); //ballX += ballDeltaX;
        settingOfTheGame.setBallY(settingOfTheGame.getBallY()+settingOfTheGame.getBallDeltaY());//ballY += ballDeltaY;
    }

    public static Settings getSettingOfTheGame() {
        return settingOfTheGame;
    }

    public static void setSettingOfTheGame(Settings settingOfTheGame) {
        Engine.settingOfTheGame = settingOfTheGame;
    }

}
