package service;

import java.util.Random;

import model.Player;
import repository.GameRepository;
import repository.PlayerRepository;

public class GameService {
    private GameRepository gameRepo;
    private PlayerRepository playerRepo;

    public GameService(){
        gameRepo = GameRepository.getInstance();
        playerRepo = PlayerRepository.getInstance();
    }

    public void addPlayerToDB(Player p){
        playerRepo.addPlayer(p);
    }
    public void removePlayerFromDB(int pid){
        playerRepo.removePlayer(pid);
    }
    public void addPlayerToGame(int pid){
        gameRepo.addPlayerToGame(pid);
    }
    public void removePlayerFromGame(int pid){
        gameRepo.removePlayerFromGame(pid);
    }

    public void startGame(){
        gameRepo.startGame();
        while(gameRepo.isStarted() && gameRepo.isFinished() == false){
            gameRepo.getCurrentChance();
            int rollDice = new Random().nextInt(6) + 1;
            System.out.println("Rolled dice: "+rollDice);
            gameRepo.move(rollDice);
            System.out.println("_________________");
        }
    }

}
