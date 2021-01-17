package repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Pair;
import model.Player;
import model.SLSquare;

public class GameRepository {

    private SLSquare[][] SLBoard;
    private List<Player> playerList;
    private PlayerRepository playerRepo;
    private int maxPlayer = 4;
    private int row = 5;
    private int col = 6;
    private boolean isFinished = false;
    private boolean isStarted = false;
    private static volatile GameRepository  instance;
    private Iterator<Player> currentChance;
    private Player currentPlayer;

    public static GameRepository getInstance(){
        if(instance == null){
            synchronized(GameRepository.class){
                if(instance == null){
                    instance = new GameRepository();
                }
            }
        }
        return instance;
    }
    private GameRepository(){
        playerRepo = PlayerRepository.getInstance();
        initializeBoard();
    }

    public void addPlayerToGame(int pid){
        if(isStarted){
            System.out.println("Can't perform operation, game is running");

            return;
        }
        if(playerList.size() == maxPlayer){
            System.out.println("Player limit reached for this game");
            return;
        }
        Player p = playerRepo.findPlayer(pid);
        if(p != null){
            p.setPosition(new Pair(row-1, 0));
            SLBoard[row-1][0].getCurrentPlayer().add(p);
            playerList.add(p);
        }else{
            System.out.println("Player not found in the database");
        }
    }
    public void removePlayerFromGame(int pid){
        if(isStarted){
            System.out.println("Can't perform operation, game is running");
            return;
        }
        playerList.remove(playerRepo.findPlayer(pid));
    }

    private void initializeBoard(){
        SLBoard = new SLSquare[5][6];
        int totalSq = row*col;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                SLBoard[i][j] = new SLSquare(totalSq, new Pair(i,j));
                totalSq--;
            }
        }
        playerList = new ArrayList<>();
        fillSnakesAndLadder();
        System.out.println("Game is initialized, please add player to game");
    }

    private void fillSnakesAndLadder(){
        /*
        Snakes:
        1. tail : (4,0) mouth: (0,2)
        2. tail : (4,3) mouth: (1,3)
        3. tail : (3,3) mouth: (1,5)
        4. tail : (3,5) mouth: (2,4)
        */
        setSnake(0, 2, new Pair(4,0));
        setSnake(1, 3, new Pair(3,3));
        setSnake(1, 5, new Pair(3,5));
        setSnake(2, 4, new Pair(4,3));

        /*
        Ladders:
        1. src : (4,2) dest: (1,2)
        2. src : (4,4) dest: (3,4)
        3. src : (3,1) dest: (0,1)
        4. src : (1,4) dest: (0,4)
        */
        setLadder(4, 2, new Pair(1,2));
        setLadder(4, 4, new Pair(3,4));
        setLadder(3, 1, new Pair(0,1));
        setLadder(1, 4, new Pair(0,4));

    }
    private void setSnake(int i, int j, Pair target){
        SLBoard[i][j].setSnake(true);
        SLBoard[i][j].setSnakeTail(target);
    }
    private void setLadder(int i, int j, Pair target){
        SLBoard[i][j].setLadder(true);
        SLBoard[i][j].setLadderTarget(target);
    }

    public int noOfPlayers(){
        return playerList.size();
    }
    public void startGame(){
        if(isStarted){
            System.out.println("Game is already running.");
            return;
        }
        if(playerList.size() < 2){
            System.out.println("Minimum 2 player required.");
            return;
        }
        isStarted = true;
        currentChance = playerList.iterator();
    }
    public void resetGame(){
        isStarted = false;
        isFinished = false;
        initializeBoard();
    }
    public boolean isFinished() {
        return isFinished;
    }
    public  void move(int roll){
        if(currentPlayer != null && !isFinished){
            SLSquare sq = getDestSquare(currentPlayer.getPosition().getI(), currentPlayer.getPosition().getJ(), roll);
            if(sq == null){
                System.out.println("Can't move");
                return;
            }
            if(sq.isSnake()){
                System.out.println("Bitten by snake");
                SLBoard[currentPlayer.getPosition().getI()][currentPlayer.getPosition().getJ()].getCurrentPlayer().remove(currentPlayer);
                sq.getCurrentPlayer().add(currentPlayer);
                currentPlayer.setPosition(sq.getSnakeTail());
                System.out.println("Player: "+ currentPlayer.getId() + currentPlayer.getName() + " hase moved to "+ sq.getSnakeTail().toString());

            }
            else if(sq.isLadder()){
                System.out.println("Taking the ladder");
                SLBoard[currentPlayer.getPosition().getI()][currentPlayer.getPosition().getJ()].getCurrentPlayer().remove(currentPlayer);
                sq.getCurrentPlayer().add(currentPlayer);
                currentPlayer.setPosition(sq.getLadderTarget());
                System.out.println("Player: "+ currentPlayer.getId() + currentPlayer.getName() + " hase moved to "+ sq.getLadderTarget().toString());

            }
            else{
                SLBoard[currentPlayer.getPosition().getI()][currentPlayer.getPosition().getJ()].getCurrentPlayer().remove(currentPlayer);
                sq.getCurrentPlayer().add(currentPlayer);
                currentPlayer.setPosition(sq.getPosition());
                System.out.println("Player: "+ currentPlayer.getId() + currentPlayer.getName() + " hase moved to "+ sq.getPosition().toString());
            }
            if(SLBoard[0][col-1].getCurrentPlayer().size() > 0){
                isFinished = true;
                System.out.println("Game Over");
                System.out.println("Player: "+ currentPlayer.getId() + " " + currentPlayer.getName() + " is the winner");
            }
        }
    }
    private SLSquare getDestSquare(int i, int j, int roll){
        int destJ;
        boolean rowInc = false;
        boolean ltr = ((i+1)%2) == (row%2);
        if(!ltr){
            destJ = j - roll;
            if(destJ < 0 ){
                destJ = (destJ + col) % col;
                rowInc = true;
            }
        }else{
            destJ = j + roll;
            if(destJ >= col ){
                destJ = col - (destJ % col) - 1;
                rowInc = true;
            } 
        }
        if(rowInc){
            if(i-1 >= 0)return SLBoard[i-1][destJ];
            else return null;
        }else{
            return SLBoard[i][destJ];
        }
    }
    public void getCurrentChance(){
        if(!isStarted || currentChance == null){
            System.out.println("Game is not started");
            return;
        }

        if(currentChance.hasNext()){
            currentPlayer = currentChance.next();
            System.out.println("Player :"+currentPlayer.getId() + " " + currentPlayer.getName() +" please roll dice");
        }

        if(!currentChance.hasNext()){
            currentChance = playerList.iterator();
        }
    }

    public boolean isStarted() {
        return isStarted;
    }
}
