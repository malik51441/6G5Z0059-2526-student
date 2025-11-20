package uk.ac.mmu.game.applicationcode.Decorator;

import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;

public class CountingDiceShakerDecorator extends DiceShakerDecorator {

    private int rollCount = 0;

    public CountingDiceShakerDecorator(DiceShaker wrapped) {
        super(wrapped);
    }

    @Override
    public int shake() {
        rollCount++;
        int result = super.shake();
        System.out.println("  [Counting] Roll #" + rollCount + ": " + result);
        return result;

    }

    public int getRollCount() {
        return rollCount;
    }
}
