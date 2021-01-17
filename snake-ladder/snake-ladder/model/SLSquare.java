package model;

import java.util.ArrayList;
import java.util.List;

public class SLSquare {
    private int id;
    private List<Player> currentPlayers;
    private boolean isSnake;
    private boolean isLadder;
    private Pair snakeTail;
    private Pair ladderTarget;
    private Pair position;

    public SLSquare(int id, Pair position){
        this.position = position;
        this.id = id;
        currentPlayers = new ArrayList<Player>();
        isSnake = false;
        isLadder = false;
        snakeTail = null;
        ladderTarget = null;
    }
    public List<Player> getCurrentPlayer() {
        return currentPlayers;
    }

    public void setCurrentPlayer(List<Player> currentPlayers) {
        this.currentPlayers = currentPlayers;
    }

    public boolean isSnake() {
        return isSnake;
    }

    public void setSnake(boolean isSnake) {
        this.isSnake = isSnake;
    }

    public boolean isLadder() {
        return isLadder;
    }

    public void setLadder(boolean isLadder) {
        this.isLadder = isLadder;
    }

    public Pair getSnakeTail() {
        return snakeTail;
    }

    public void setSnakeTail(Pair snakeTail) {
        this.snakeTail = snakeTail;
    }

    public Pair getLadderTarget() {
        return ladderTarget;
    }

    public void setLadderTarget(Pair ladderTarget) {
        this.ladderTarget = ladderTarget;
    }

    public Pair getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }
}
