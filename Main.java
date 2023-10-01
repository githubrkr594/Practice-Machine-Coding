package snakeLadder;

import snakeLadder.model.Entities;
import snakeLadder.service.SnakeLadderService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Entities entities = Entities.getInstance();

        int numberOfSnakes = scanner.nextInt();
        while (numberOfSnakes>0) {
            int startPosition = scanner.nextInt();
            int endPosition = scanner.nextInt();
            entities.setSnakes(startPosition, endPosition);
            numberOfSnakes--;
        }

        int numberOfLadder = scanner.nextInt();
        while (numberOfLadder>0) {
            int startPosition = scanner.nextInt();
            int endPosition = scanner.nextInt();
            entities.setLadders(startPosition, endPosition);
            numberOfLadder--;
        }

        int numberOfPlayers = scanner.nextInt();
        int i=0;
        while (numberOfPlayers>0){
            i++;
            String name = scanner.next();
            entities.setPlayers(i, name);
            numberOfPlayers--;
        }

        SnakeLadderService snakeLadderService = new SnakeLadderService(6);
        String wonPlayerName = snakeLadderService.playGame();

        System.out.println(wonPlayerName + " wins the game ");
    }
}
