package uk.ac.mmu.game.applicationcode.AbstractDiceShakerFactory;

import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;
import uk.ac.mmu.game.applicationcode.DiceShakers.RandomDoubleDiceShaker;

public class DoubleDiceShakerFactoryMethod extends AbstractDiceShakerFactory {

    @Override
    protected DiceShaker factoryMethod() {
        return new RandomDoubleDiceShaker();
    }
    
    @Override
    protected String getDescription() {
        return "Double dice shaker (rolls 2-12)";
    }
}

