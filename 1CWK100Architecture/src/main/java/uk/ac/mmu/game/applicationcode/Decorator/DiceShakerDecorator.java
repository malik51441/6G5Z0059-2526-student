package uk.ac.mmu.game.applicationcode.Decorator;

import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;

public abstract class DiceShakerDecorator implements DiceShaker{

    protected final DiceShaker wrapped;

    public DiceShakerDecorator(DiceShaker wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public int shake() {
        return wrapped.shake();  // Delegate to wrapped object
    }
}
