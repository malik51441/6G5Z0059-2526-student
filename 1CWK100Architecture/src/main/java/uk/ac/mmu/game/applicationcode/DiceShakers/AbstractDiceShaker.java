package uk.ac.mmu.game.applicationcode.DiceShakers;

import java.util.Random;

public abstract class AbstractDiceShaker {
    private final Random random = new Random();

    protected int shakeSingleDie () {
        return random.nextInt(1, 7);
    }

    public abstract int shake();
}
