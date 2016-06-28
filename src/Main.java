import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by EddyJ on 6/21/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Player player1 = new HumanPlayer("Player1");
        Player player2 = new StupidAI("StupidAI");
        Game game = new Game(player1, player2);
        Leaderboard leaderboard = new Leaderboard();
        Map<String, Integer> updateRecord = new HashMap<>();


        game.stickTotal();
        game.runGame();
        updateRecord = Leaderboard.loadPlayer(updateRecord);
        leaderboard.updatePlayers(game, updateRecord);
        leaderboard.savePlayer(updateRecord);


    }
}
