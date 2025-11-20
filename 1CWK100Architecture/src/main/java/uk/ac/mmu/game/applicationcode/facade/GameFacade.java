package uk.ac.mmu.game.applicationcode.facade;

import uk.ac.mmu.game.GameBoard;
import uk.ac.mmu.game.applicationcode.DiceShakerFactory.DiceShakerFactory;
import uk.ac.mmu.game.applicationcode.DiceShakerFactory.DoubleDiceShakerFactory;
import uk.ac.mmu.game.applicationcode.DiceShakerFactory.FixedDiceShakerFactory;
import uk.ac.mmu.game.applicationcode.DiceShakerFactory.SingleDiceShakerFactory;
import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;
import uk.ac.mmu.game.applicationcode.Game;
import uk.ac.mmu.game.applicationcode.observers.ConsoleGameEventListener;

public class GameFacade {
    private DiceShakerFactory factory;
    private final ConsoleGameEventListener consoleGameEventListener = new ConsoleGameEventListener();

    public GameFacade(DiceShakerFactory factory) {
        this.factory = factory;
    }

    public Game createGameWithSingleDice() {
        this.factory = new SingleDiceShakerFactory();

        DiceShaker diceShaker = factory.create();

        Game game = new Game(diceShaker);
        game.addListener(consoleGameEventListener);

        return game;
    }

    public Game createGameWithDoubleDice() {
        this.factory = new DoubleDiceShakerFactory();

        DiceShaker diceShaker = factory.create();

        Game game = new Game(diceShaker);
        game.addListener(consoleGameEventListener);

        return game;
    }

    public Game createGameWithFixedDice() {
        this.factory = new FixedDiceShakerFactory();

        DiceShaker diceShaker = factory.create();

        Game game = new Game(diceShaker);
        game.addListener(consoleGameEventListener);

        return game;
    }

    public int playSimpleGame() {
        DiceShaker shaker = factory.create();
        GameBoard board = new GameBoard();
        
        while (!board.isHome() || board.getMoves() == 0) {
            int roll = shaker.shake();
            board.advance(roll);
        }
        
        return board.getMoves();
    }

}
