package uk.ac.mmu.game.applicationcode.DiceShakerFactory;

import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;
import uk.ac.mmu.game.applicationcode.DiceShakers.RandomSingleDiceShaker;

public class SingleDiceShakerFactory implements DiceShakerFactory {

    @Override
    public DiceShaker create() {
        return new RandomSingleDiceShaker();
    }

}
