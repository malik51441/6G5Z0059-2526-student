package uk.ac.mmu.game.applicationcode.mediator;

import uk.ac.mmu.game.GameBoard;

public class GameBoardColleague implements Colleague {

    private final GameMediator gameMediator;
    private final GameBoard gameBoard;

    public GameBoardColleague(GameMediator gameMediator, GameBoard gameBoard) {
        this.gameMediator = gameMediator;
    }
}
