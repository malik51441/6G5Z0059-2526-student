package uk.ac.mmu.game.applicationcode.domainmodel.values;

import java.util.Objects;

public class Score {
    private final int value;
    public static final Score ZERO = new Score(0);

    public Score(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("negative score is not allowed");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Score add(Score other) {
        return new Score(this.value + other.value);
    }

    public Score add(int amount) {
        return new Score(this.value + amount);
    }

    @Override
    public String toString() {
        return String.format("Score(%d)", value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return value == score.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
