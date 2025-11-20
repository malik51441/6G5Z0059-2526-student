package uk.ac.mmu.game.applicationcode.observers;

import uk.ac.mmu.game.applicationcode.domainmodel.values.DiceRoll;
import uk.ac.mmu.game.applicationcode.domainmodel.values.PlayerName;
import uk.ac.mmu.game.applicationcode.domainmodel.values.Score;

public class NullGameEventListener implements GameEventListener {

//    used for testing
    @Override
    public void onGameStarted(PlayerName playerName) {
    }

    @Override
    public void onRollMade(PlayerName playerName, DiceRoll roll, Score score) {
    }

    @Override
    public void onGameEnded(PlayerName playerName, Score finalScore) {
    }
}

