package uk.ac.mmu.game.applicationcode.domainmodel.values;

import java.util.Objects;

public class PlayerName {

    private final String name;
    public PlayerName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Must set Player Name");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
