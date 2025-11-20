package uk.ac.mmu.game.applicationcode.DiceShakers;

public class ConcreteDoubleDiceShaker extends AbstractDiceShaker {
    @Override
    public int shake() {
        return shakeSingleDie() + shakeSingleDie() ;
    }
}
