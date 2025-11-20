package uk.ac.mmu.game.applicationcode.domainmodel;

import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;

public class FixedDiceShaker implements DiceShaker {

    private final int[] shakes = new int[]{
            1, 2, 3, 4, 5, 6
    };

    private int index = 0;

    @Override
    public int shake() {
        int value = shakes[index];
        index = (index + 1) % shakes.length;
        return value;
    }
}
