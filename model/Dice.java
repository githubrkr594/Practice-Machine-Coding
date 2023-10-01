package snakeLadder.model;

import java.util.Random;

public class Dice {
    private final int numberOfDice;
    private static final int MIN=1;
    Random random;


    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
        random = new Random();
    }

    public int getNumberOfDice() {
        return random.nextInt(numberOfDice)+MIN;
    }
}
