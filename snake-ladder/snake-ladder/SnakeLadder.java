import model.Player;
import service.GameService;

public class SnakeLadder{
    public static void main(String[] args) {
        GameService gameService = new GameService();
        
        // add player to database
        gameService.addPlayerToDB(new Player(1, "shivam"));
        gameService.addPlayerToDB(new Player(2, "ayushi"));

        gameService.addPlayerToGame(1);
        gameService.addPlayerToGame(2);

        gameService.startGame();
    }
}