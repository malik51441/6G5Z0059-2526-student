package uk.ac.mmu.game.applicationcode.scoringStrategies;

import uk.ac.mmu.game.applicationcode.domainmodel.values.DiceRoll;
import uk.ac.mmu.game.applicationcode.domainmodel.values.Score;

public class DoubleEvenScoringStrategy implements ScoringStrategies {

    @Override
    public Score calculateScore(Score currentScore, DiceRoll roll) {

        if (roll.getValue() % 2 == 0 ) {
            return currentScore.add(roll.getValue() * 2);
        }

        return currentScore.add(roll.getValue());
    }


}
