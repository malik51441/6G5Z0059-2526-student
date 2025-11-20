package uk.ac.mmu.game.applicationcode.observers;

import uk.ac.mmu.game.applicationcode.domainmodel.values.DiceRoll;
import uk.ac.mmu.game.applicationcode.domainmodel.values.PlayerName;
import uk.ac.mmu.game.applicationcode.domainmodel.values.Score;

public interface GameEventListener {
    void onGameStarted(PlayerName playerName);

    void onRollMade(PlayerName playerName, DiceRoll roll, Score score);

    void onGameEnded(PlayerName playerName, Score finalScore);


}
