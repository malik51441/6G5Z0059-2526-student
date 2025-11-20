package uk.ac.mmu.game.applicationcode.DiceShakers;

import java.util.Random;

public class RandomSingleDiceShaker implements DiceShaker{

    private final Random random = new Random();

    @Override
    public int shake() {
        return random.nextInt(1,7);
    }
}
