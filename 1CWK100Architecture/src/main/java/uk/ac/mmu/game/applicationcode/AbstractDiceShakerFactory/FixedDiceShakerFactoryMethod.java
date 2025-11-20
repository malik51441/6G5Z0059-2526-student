package uk.ac.mmu.game.applicationcode.AbstractDiceShakerFactory;

import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;
import uk.ac.mmu.game.applicationcode.DiceShakers.FixedDiceShaker;

public class FixedDiceShakerFactoryMethod extends AbstractDiceShakerFactory {

    @Override
    protected DiceShaker factoryMethod() {
        return new FixedDiceShaker();
    }
    
    @Override
    protected String getDescription() {
        return "Fixed dice shaker (for testing)";
    }
}

