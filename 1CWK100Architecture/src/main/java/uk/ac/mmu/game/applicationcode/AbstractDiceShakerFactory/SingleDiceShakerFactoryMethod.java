package uk.ac.mmu.game.applicationcode.AbstractDiceShakerFactory;

import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;
import uk.ac.mmu.game.applicationcode.DiceShakers.RandomSingleDiceShaker;

public class SingleDiceShakerFactoryMethod extends AbstractDiceShakerFactory {

    @Override
    protected DiceShaker factoryMethod() {
        return new RandomSingleDiceShaker();
    }
    
    // Override the hook method to provide custom description
    @Override
    protected String getDescription() {
        return "Single dice shaker (rolls 1-6)";
    }
}

