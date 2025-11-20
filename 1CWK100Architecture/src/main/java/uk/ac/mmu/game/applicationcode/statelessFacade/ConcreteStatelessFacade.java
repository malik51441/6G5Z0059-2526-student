package uk.ac.mmu.game.applicationcode.statelessFacade;


import uk.ac.mmu.game.GameBoard;
import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;
import uk.ac.mmu.game.applicationcode.DiceShakers.RandomSingleDiceShaker;

class ConcreteStatelessFacade implements StatelessFacade {
    @Override
    public int play() {
        DiceShaker shaker = new RandomSingleDiceShaker();
        GameBoard board = new GameBoard();
        while(!board.isHome() || board.getMoves() ==0)
        {
            board.advance(shaker.shake());
        }
        return board.getMoves();
    }
}
