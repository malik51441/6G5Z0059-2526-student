package uk.ac.mmu.game.applicationcode.scoringStrategies;

import uk.ac.mmu.game.applicationcode.domainmodel.values.DiceRoll;
import uk.ac.mmu.game.applicationcode.domainmodel.values.Score;
import uk.ac.mmu.game.applicationcode.scoringStrategies.ScoringStrategies;

public class SimpleScoringStrategy implements ScoringStrategies {

    @Override
    public Score calculateScore(Score currentScore, DiceRoll roll) {
        return currentScore.add(roll.getValue());
    }

}
