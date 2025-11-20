package uk.ac.mmu.game.applicationcode.movementStrategies;

import uk.ac.mmu.game.applicationcode.domainmodel.values.DiceRoll;
import uk.ac.mmu.game.applicationcode.domainmodel.values.Score;

public interface movementStrategies {
    Score move(Score currentScore, DiceRoll roll);
}
