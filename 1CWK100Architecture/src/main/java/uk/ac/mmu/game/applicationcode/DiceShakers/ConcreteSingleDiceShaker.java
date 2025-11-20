package uk.ac.mmu.game.applicationcode.DiceShakers;

public class ConcreteSingleDiceShaker extends AbstractDiceShaker {
    @Override
    public int shake() {
        return shakeSingleDie();
    }
}
