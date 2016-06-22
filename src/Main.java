/**
 * Created by EddyJ on 6/21/16.
 */
public class Main {
    public static void main(String[] args) {
        Player player1 = new HumanPlayer("Player1");
        Player player2 = new StupidAI("StupidAI");
        Game game = new Game(player1, player2);

        game.stickTotal();
        game.runGame();

    }
}
