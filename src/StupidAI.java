import java.util.Random;

/**
 * Created by EddyJ on 6/22/16.
 */
public class StupidAI extends AbstractPlayer{
    Random random = new Random();

    public StupidAI(String name) {
        super(name);
    }

    @Override
    public int chooseSticks() {
        System.out.format("%s  How many sticks do you take? [1/2/3]\n",getName());
        System.out.println("----------------------------------------------------------------------");
        return random.nextInt(3) + 1;
    }

}
