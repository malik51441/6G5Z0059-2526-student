package uk.ac.mmu.game.applicationcode.usecase.play;

import uk.ac.mmu.game.applicationcode.AbstractDiceShakerFactory.AbstractDiceShakerFactory;
import uk.ac.mmu.game.applicationcode.AbstractDiceShakerFactory.DoubleDiceShakerFactoryMethod;
import uk.ac.mmu.game.applicationcode.AbstractDiceShakerFactory.SingleDiceShakerFactoryMethod;
import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;
import uk.ac.mmu.game.applicationcode.domainmodel.values.DiceRoll;
import uk.ac.mmu.game.applicationcode.domainmodel.values.Score;
import uk.ac.mmu.game.applicationcode.scoringStrategies.ScoringStrategies;
import uk.ac.mmu.game.applicationcode.scoringStrategies.SimpleScoringStrategy;
import uk.ac.mmu.game.applicationcode.usecase.Required;

public class UseCase implements Provided {

    private final Required required;

    public UseCase(Required required) {
        this.required = required;
    }

    @Override
    public int play() {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("          WEEK 4: FACTORY METHOD PATTERN IN ACTION");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        // Use Factory Method Pattern to create dice shaker
        // Notice: We use the abstract class type, but get different implementations!
        AbstractDiceShakerFactory factory = new SingleDiceShakerFactoryMethod();
        
        System.out.println("=== Starting Game with Factory Method Pattern ===\n");
        
        // The factory creates the shaker with all the common behavior (logging, counting)
        DiceShaker shaker = factory.create();
        
        // Play the game using the shaker
        Score score = Score.ZERO;
        ScoringStrategies strategy = new SimpleScoringStrategy();
        
        System.out.println("\n=== Playing 5 Rounds ===");
        for (int round = 1; round <= 5; round++) {
            int rollValue = shaker.shake();
            DiceRoll roll = new DiceRoll(rollValue);
            score = strategy.calculateScore(score, roll);
            
            System.out.println("Round " + round + ": Rolled " + roll + " → Score: " + score);
        }
        
        System.out.println("\n=== Final Score: " + score + " ===");
        System.out.println("Total DiceShakers created: " + AbstractDiceShakerFactory.getTotalCreated());
        
        // Demonstrate polymorphism: swap to different factory
        System.out.println("\n=== Switching to Double Dice Shaker ===");
        factory = new DoubleDiceShakerFactoryMethod();  // Different subclass!
        shaker = factory.create();  // Still uses AbstractDiceShakerFactory.create()
        
        System.out.println("\n=== Playing 3 More Rounds with Double Dice ===");
        System.out.println("(Double dice returns 2-12, so we add directly to score)\n");
        for (int round = 1; round <= 3; round++) {
            int rollValue = shaker.shake();
            // Double dice returns 2-12, so we add directly (DiceRoll only accepts 1-6)
            score = score.add(rollValue);
            
            System.out.println("Round " + (round + 5) + ": Rolled " + rollValue + " → Score: " + score);
        }
        
        System.out.println("\n=== Final Score: " + score + " ===");
        System.out.println("Total DiceShakers created: " + AbstractDiceShakerFactory.getTotalCreated());
        
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("Key Point: Both factories used the SAME create() method");
        System.out.println("but created DIFFERENT DiceShakers (polymorphism!)");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        return 1;
    }
}
