import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by EddyJ on 6/23/16.
 */
public class Leaderboard {
    private int numberWins;
    String loser = null;
    String winner = null;
    Map<String, Integer> records = new HashMap<>();
    private static final String SAVEFILE = "player.json";

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Map<String, Integer> getRecords() {
        return records;
    }

    public void setRecords(HashMap<String, Integer> records) {
        this.records = records;
    }

    public int getNumberWins() {
        return numberWins;
    }

    public void setNumberWins(int numberWins) {
        this.numberWins = numberWins;
    }

    public Object addPlayer(Player player){
        return records.put(player.getName(), numberWins);
    }

    public void savePlayer(Map records) throws IOException {
        File saveFile = new File(SAVEFILE);
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(records);
        FileWriter fw = new FileWriter(saveFile);
        fw.write(json);
        fw.close();
    }

    public static Map loadPlayer(Map records) throws FileNotFoundException {
        File loadFile = new File(SAVEFILE);
        Scanner scanner = new Scanner(loadFile);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();

        JsonParser parser = new JsonParser();
        records = parser.parse(contents, HashMap.class);
        return records;
    }


    public Map updatePlayers(Game game, Map<String, Integer> updateRecord){
        boolean updateWinner = false;
        boolean updateLoser = false;
        for(String name : updateRecord.keySet()){
            if(name.equalsIgnoreCase(getLoser())){
                updateRecord.put(name, updateRecord.get(name)- 1);
                updateLoser = true;
            }else if(name.equalsIgnoreCase(getWinner())){
                updateRecord.put(name, updateRecord.get(name)+ 1);
                updateWinner = true;
            }
        }
        if (updateRecord.isEmpty())
            System.out.println("The file has no data.");
        if(!updateLoser){
            updateRecord.put(game.getLoser(), 1);
        }
        if(!updateWinner){
            updateRecord.put(game.getWinner(), 1);
        }
        return updateRecord;
    }


}
