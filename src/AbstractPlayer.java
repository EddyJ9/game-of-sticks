/**
 * Created by EddyJ on 6/22/16.
 */
public abstract class AbstractPlayer implements Player {
    private String name;

    public AbstractPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }


}
