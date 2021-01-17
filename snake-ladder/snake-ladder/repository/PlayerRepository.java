package repository;

import java.util.ArrayList;
import java.util.List;
import model.Player;

public class PlayerRepository {
    private List<Player> players;
    private static volatile PlayerRepository instance;
 
    public static  PlayerRepository getInstance(){
        if(instance == null){
            synchronized(PlayerRepository.class){
                if(instance == null){
                    instance = new PlayerRepository();
                }
            }
        }
        return instance;
    }

    private PlayerRepository(){
        players = new ArrayList<>();
    }

    public void addPlayer(Player p){
        if(findPlayer(p.getId()) == null){
            players.add(p);
        }else{
            System.out.println("Player is already added in system.");
        }
    }

    public void removePlayer(int pid){
        players.remove(findPlayer(pid));
    }

    public Player findPlayer(int id){
        for(Player p: players){
            if(p.getId() == id)return p;
        }
        return null;
    }
}
