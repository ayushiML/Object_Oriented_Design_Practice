package model;

public class Player {
    private int id;
    private String name;
    private int win;
    private int totalGame;
    private Pair position;
    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.totalGame = 0;
        this.win = 0;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getTotalGame() {
        return totalGame;
    }

    public void setTotalGame(int totalGame) {
        this.totalGame = totalGame;
    }

    public Pair getPosition() {
        return position;
    }

    public void setPosition(Pair currentPosition) {
        this.position = currentPosition;
    }
}
