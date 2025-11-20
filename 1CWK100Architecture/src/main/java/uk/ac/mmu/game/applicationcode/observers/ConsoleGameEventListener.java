package uk.ac.mmu.game.applicationcode.observers;

import uk.ac.mmu.game.applicationcode.domainmodel.values.DiceRoll;
import uk.ac.mmu.game.applicationcode.domainmodel.values.PlayerName;
import uk.ac.mmu.game.applicationcode.domainmodel.values.Score;

public class ConsoleGameEventListener implements GameEventListener {
    @Override
    public void onGameStarted(PlayerName playerName) {
        System.out.println("🎮 Game started for player: " + playerName);
    }

    @Override
    public void onRollMade(PlayerName playerName, DiceRoll roll, Score score) {
        System.out.println("🎲 " + playerName + " rolled " + roll + " → Score: " + score);
    }

    @Override
    public void onGameEnded(PlayerName playerName, Score finalScore) {
        System.out.println("🏁 Game finished! " + playerName + " final score: " + finalScore);
    }
}

