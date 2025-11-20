package uk.ac.mmu.game.applicationcode.scoringStrategies;

import uk.ac.mmu.game.applicationcode.domainmodel.values.DiceRoll;
import uk.ac.mmu.game.applicationcode.domainmodel.values.Score;

public interface ScoringStrategies {
    Score calculateScore(Score currentScore, DiceRoll roll);
}
