package uk.ac.mmu.game.applicationcode.Decorator;

import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;

public class LoggingDiceShakerDecorator extends DiceShakerDecorator{
    public LoggingDiceShakerDecorator(DiceShaker wrapped) {
        super(wrapped);
    }

    @Override
    public int shake(){
        int result = super.shake();
        System.out.println("  [Logging] Dice rolled: " + result);
        return result;
    }
}
