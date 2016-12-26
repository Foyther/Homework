package Server;

/**
 * Created by Nurislam on 25.12.2016.
 */
public class Settings {
    public Settings(SettingsClient first, SettingsClient second) {
        this.first = first;
        first.setPlayerX(25);
        this.second = second;
        second.setPlayerX(465);
    }

    private boolean playing = true;
    private boolean gameOver = false;

    private int ballX = 250;
    private int ballY = 250;
    private int diameter = 20;
    private int ballDeltaX = -1;
    private int ballDeltaY = 3;

    SettingsClient first;
    SettingsClient second;

    private int paddleSpeed = 5;

    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public SettingsClient getFirst() {
        return first;
    }

    public void setFirst(SettingsClient first) {
        this.first = first;
    }

    public SettingsClient getSecond() {
        return second;
    }

    public void setSecond(SettingsClient second) {
        this.second = second;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getBallX() {
        return ballX;
    }

    public void setBallX(int ballX) {
        this.ballX = ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public void setBallY(int ballY) {
        this.ballY = ballY;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getBallDeltaX() {
        return ballDeltaX;
    }

    public void setBallDeltaX(int ballDeltaX) {
        this.ballDeltaX = ballDeltaX;
    }

    public int getBallDeltaY() {
        return ballDeltaY;
    }

    public void setBallDeltaY(int ballDeltaY) {
        this.ballDeltaY = ballDeltaY;
    }


    public int getPaddleSpeed() {
        return paddleSpeed;
    }

    public void setPaddleSpeed(int paddleSpeed) {
        this.paddleSpeed = paddleSpeed;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public void setPlayerOneScore(int playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerTwoScore(int playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }
}
