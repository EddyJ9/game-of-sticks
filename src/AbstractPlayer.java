import java.util.HashMap;

/**
 * Created by EddyJ on 6/22/16.
 */
public abstract class AbstractPlayer implements Player {
    private String name;
    HashMap<String, Integer> record = new HashMap<>();

    public AbstractPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String setName(){
        return this.name;
    }



}
