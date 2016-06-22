import java.util.Scanner;

/**
 * Created by EddyJ on 6/21/16.
 */
public class Player {
    private String name;
    private Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int chooseSticks() {
        int rval = 0;
        while(!(rval >= 1 && rval <= 3)) {
            System.out.format("%s  How many sticks do you take? [1/2/3]\n",getName());
            rval = Integer.parseInt(scanner.nextLine());
            if (!(rval >= 1 && rval <= 3)) {
                System.out.println("Please enter a vaild number [1/2/3]");
            }
        }
        return rval;
    }

}