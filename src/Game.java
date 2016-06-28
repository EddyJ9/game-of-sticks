import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by EddyJ on 6/21/16.
 */
public class Game {
    private Player player1;
    private Player player2;
    private int sticks;
    private Player currentPlayer = null;
    String loser = null;
    String winner = null;
    private Scanner scanner = new Scanner(System.in);

    public Game(Player player1, Player player2){
        this.player1 = currentPlayer = player1;
        this.player2 = player2;
    }

    public int getSticks() {
        return sticks;
    }

    public String getLoser() {
        return loser;
    }

    public String getWinner() {
        return winner;
    }

    public String setLoser(Player name) {
        return loser = name.getName();
    }

    public String setWinner(Player name) {
        return winner = name.getName();
    }

    public int stickTotal(){
        sticks = 0;
        System.out.println("Let's play Game of Sticks!!!!!!");
        do {
            System.out.println("How many sticks would you like to begin with? (10-100)");
            sticks = Integer.parseInt(scanner.nextLine());
        if(sticks >= 10 && sticks <= 100){
            System.out.format("There are %d sticks on the board\n", sticks);
        }
        else{
            System.out.println("Please choose a number between 10 and 100");
        }
    }while(!(sticks >= 10 && sticks <= 100));
        return sticks;
    }

    public void switchPlayer(){
        if(currentPlayer == player1){
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }

    public Player runGame() throws FileNotFoundException {
        int choice = currentPlayer.chooseSticks();
        while(sticks > 0 && sticks - choice > 0){
            sticks = sticks - choice;
            System.out.format("%s took %d sticks\n", currentPlayer.getName(), choice);
            System.out.format("There are %d sticks left on the board\n", sticks);
            if(sticks == 1 || (sticks - choice) > sticks){
                switchPlayer();
            }
            else{
                switchPlayer();
                choice = currentPlayer.chooseSticks();
            }
        }
        System.out.format("I'm sorry %s but you lose.\n", currentPlayer.getName());
        setLoser(currentPlayer);
        switchPlayer();
        setWinner(currentPlayer);
        return currentPlayer;

    }


}
