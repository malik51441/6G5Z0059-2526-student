package uk.ac.mmu.game.applicationcode;

import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;
import uk.ac.mmu.game.applicationcode.domainmodel.values.DiceRoll;
import uk.ac.mmu.game.applicationcode.domainmodel.values.PlayerName;
import uk.ac.mmu.game.applicationcode.domainmodel.values.Score;
import uk.ac.mmu.game.applicationcode.observers.GameEventListener;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<GameEventListener> listeners = new ArrayList<>();
    private final DiceShaker diceShaker;
    private PlayerName currentPlayer;
    private Score currentScore;

    public Game(DiceShaker diceShaker) {
        this.diceShaker = diceShaker;
        this.currentScore = Score.ZERO;
    }

    public void addListener(GameEventListener gameEventListener) {

        listeners.add(gameEventListener);
    }
    public void removeListener(GameEventListener gameEventListener) {

        listeners.remove(gameEventListener);
    }

    private void notifyGameStarted(PlayerName playerName) {
        for (GameEventListener listener : listeners) {
            listener.onGameStarted(playerName);
        }
    }

    private void notifyRollMade(PlayerName playerName, DiceRoll roll, Score score) {
        for (GameEventListener listener : listeners) {
            listener.onRollMade(playerName, roll, score);
        }
    }

    private void notifyGameFinished(PlayerName playerName, Score finalScore) {
        for (GameEventListener listener : listeners) {
            listener.onGameEnded(playerName, finalScore);
        }
    }

    public void start(PlayerName playerName){
        this.currentPlayer = playerName;
        this.currentScore = Score.ZERO;
        notifyGameStarted(playerName);
    }

    public void rollDice() {
        if (currentPlayer == null) {
            throw new IllegalStateException("Game not started");
        }

        int rollValue = diceShaker.shake();
        DiceRoll roll = new DiceRoll(rollValue);
        currentScore = currentScore.add(roll.getValue());

        notifyRollMade(currentPlayer, roll, currentScore);
    }

    public void finish() {
        if (currentPlayer == null) {
            throw new IllegalStateException("Game not started");
        }
        notifyGameFinished(currentPlayer, currentScore);
    }

    public Score getCurrentScore() {
        return currentScore;
    }
}
