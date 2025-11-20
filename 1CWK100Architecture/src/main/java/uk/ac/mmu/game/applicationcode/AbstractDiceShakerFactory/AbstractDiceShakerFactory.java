package uk.ac.mmu.game.applicationcode.AbstractDiceShakerFactory;

import uk.ac.mmu.game.applicationcode.DiceShakers.DiceShaker;

public abstract class AbstractDiceShakerFactory {

    private static int totalCreated = 0;  // Shared state across all factories

    // Public method that clients call - THIS is where Factory Method pattern shines!
    // All subclasses get this common behavior automatically
    public DiceShaker create() {
        System.out.println("  [Factory Method] Creating DiceShaker...");

        totalCreated++;
        System.out.println("  [Factory Method] Total DiceShakers created: " + totalCreated);

        DiceShaker shaker = factoryMethod();

        System.out.println("  [Factory Method] DiceShaker created: " + shaker.getClass().getSimpleName());
        System.out.println("  [Factory Method] Description: " + getDescription());

        return shaker;
    }

    protected abstract DiceShaker factoryMethod();

    /**
     * Hook method subclasses can override to describe the dice shaker being created.
     */
    protected String getDescription() {
        return "Generic dice shaker";
    }

    public static int getTotalCreated() {
        return totalCreated;
    }
}
