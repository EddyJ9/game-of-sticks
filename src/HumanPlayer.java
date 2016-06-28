import java.util.Scanner;

/**
 * Created by EddyJ on 6/21/16.
 */
public class HumanPlayer extends AbstractPlayer{
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
    }


    @Override
    public int chooseSticks() {
        int rval = 0;
        while(!(rval >= 1 && rval <= 3)) {
            System.out.format("%s  How many sticks do you take? [1/2/3]\n",getName());
            System.out.println("----------------------------------------------------------------------");
            rval = Integer.parseInt(scanner.nextLine());
            if (!(rval >= 1 && rval <= 3)) {
                System.out.println("Please enter a vaild number [1/2/3]");
            }
        }
        return rval;
    }

}