package snakeLadder.model;

import java.util.HashMap;

public class Entities {
    private HashMap<Integer, Integer> snakes;
    private HashMap<Integer, Integer> ladders;
    private HashMap<Integer, String>  players;
    private static Entities instance = null;

    public Entities() {
        this.snakes = new HashMap<Integer, Integer>();;
        this.ladders = new HashMap<Integer, Integer>();
        this.players = new HashMap<Integer, String>();
    }

    public void setSnakes(int startPosition, int endPosition) {
        this.snakes.put(startPosition, endPosition);
    }

    public void setLadders(int startPosition, int endPosition) {
        this.ladders.put(startPosition, endPosition);
    }

    public  void setPlayers(int startPosition, String name) {
        this.players.put(startPosition, name);
    }

    public  HashMap<Integer, Integer> getSnakes() {
        return snakes;
    }

    public  HashMap<Integer, Integer> getLadders() {
        return ladders;
    }

    public  HashMap<Integer, String> getPlayers() {
        return players;
    }

    public static Entities getInstance() {
        if(instance==null){
            instance =  new Entities();
        }
        return instance;
    }
}
