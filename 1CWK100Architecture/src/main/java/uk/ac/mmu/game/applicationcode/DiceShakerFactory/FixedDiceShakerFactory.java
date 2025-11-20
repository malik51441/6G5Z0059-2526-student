package uk.ac.mmu.game.applicationcode.DiceShakerFactory;


import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;
import uk.ac.mmu.game.applicationcode.DiceShakers.FixedDiceShaker;

public class FixedDiceShakerFactory implements DiceShakerFactory {

    @Override
    public DiceShaker create() {
        return new FixedDiceShaker();
    }

}
