package uk.ac.mmu.game.applicationcode.domainmodel.values;

public class DiceRoll {
    private final int value;

    public DiceRoll(int value) {
        if (value < 1 || value > 6) {
            throw new IllegalArgumentException("Dice roll must be between 1 and 6");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof DiceRoll))
            return false;

        DiceRoll other = (DiceRoll) obj;
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public String toString() {
        return String.format("DiceRoll(%d)", value);
    }
}