package uk.ac.mmu.game.applicationcode.DiceShakerFactory;

import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;
import uk.ac.mmu.game.applicationcode.DiceShakers.RandomDoubleDiceShaker;

public class DoubleDiceShakerFactory implements DiceShakerFactory {

    @Override
    public DiceShaker create() {
        return new RandomDoubleDiceShaker();
    }

}
