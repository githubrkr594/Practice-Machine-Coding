package snakeLadder.service;

import snakeLadder.model.Dice;
import snakeLadder.model.Entities;

import java.util.HashMap;

public class SnakeLadderService {
    HashMap<String, Integer> playerLatestPosition;
    Entities entities;
    Dice dice;

    public SnakeLadderService(int n) {
        this.playerLatestPosition = new HashMap<>();
        this.entities = Entities.getInstance();
        this.dice = new Dice(n);
    }

    public String playGame() {
        initializePlayGame();
        int i =0;
        do{
            i++;
            if(i> entities.getPlayers().size()) {
                i=1;
            }
            StringBuffer stringBuffer = new StringBuffer();
            String playerName = entities.getPlayers().get(i);

            stringBuffer.append(playerName);

            int numberDice = dice.getNumberOfDice();
            int endPosition = playerLatestPosition.get(playerName)+numberDice ;

            if(!checkDiceGreaterThanHundred(endPosition)){

                stringBuffer.append(" rolled a ").append(numberDice);
                stringBuffer.append(" and moved from  ").append(playerLatestPosition.get(playerName));
                if(entities.getSnakes().get(endPosition)!=null){
                    stringBuffer.append(" to ").append(entities.getSnakes().get(endPosition));
                    stringBuffer.append(" after a snake dinner ");
                    playerLatestPosition.put(playerName, entities.getSnakes().get(endPosition));
                }
                else if(entities.getLadders().get(endPosition)!=null){

                    stringBuffer.append(" to ").append(entities.getLadders().get(endPosition));
                    stringBuffer.append(" after a ladder ride ");
                    playerLatestPosition.put(playerName, entities.getLadders().get(endPosition));

                }
                else{
                    stringBuffer.append(" to ").append(endPosition);
                    playerLatestPosition.put(playerName, endPosition);
                }
            }
            System.out.println(stringBuffer);
        }while (!playerWonGame(entities.getPlayers().get(i)));

        return entities.getPlayers().get(i);
    }

    private boolean checkDiceGreaterThanHundred(int endPosition) {
        return endPosition>100;
    }

    private boolean playerWonGame(String s) {
        return playerLatestPosition.get(s) == 100;
    }

    private void initializePlayGame() {
        for(int i = 0; i < entities.getPlayers().size(); i++){
            playerLatestPosition.put(entities.getPlayers().get(i+1), 0);
        }
    }


}
