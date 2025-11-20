# Dice Roller Game - Design Patterns Implementation

This project demonstrates all the design patterns covered in Weeks 1-7 of the Software Design and Architecture module.

## 🎯 Running the Application

### Option 1: Using Maven Wrapper
```bash
cd 1CWK100Architecture
./mvnw spring-boot:run
```

### Option 2: Using Maven Directly
```bash
cd 1CWK100Architecture
mvn spring-boot:run
```

The application will:
1. Play a game with single dice (Player 1)
2. Prompt you to enter a game ID
3. Replay the game with double dice (Player 2)

Simply enter `1` when prompted.

## 📚 Design Patterns Implemented

### Week 2: Interface Implementation & Abstract Classes

**Pattern**: Interface-based polymorphism

**Location**: `applicationcode/domainmodel/`

**Implementation**:
- `DiceShaker` interface with multiple implementations:
  - `RandomSingleDiceShaker` - rolls a single die (1-6)
  - `RandomDoubleDiceShaker` - rolls two dice (2-12)
  - `FixedDiceShaker` - returns predetermined values (for testing)

**Key Concept**: Different implementations can be swapped at runtime without changing client code.

```java
DiceShaker shaker = new RandomSingleDiceShaker();
// OR
DiceShaker shaker = new RandomDoubleDiceShaker();
// Both work the same way through the interface
```

---

### Week 3: Value Objects

**Pattern**: Immutable value objects with content equality

**Location**: `applicationcode/domainmodel/`

**Implementations**:
1. **`Score`** - Represents a game score
   - Immutable (final fields)
   - Non-negative validation
   - Has `ZERO` singleton for common value
   - Implements `equals()`, `hashCode()`, `toString()`

2. **`Roll`** - Represents a single dice roll
   - Immutable
   - Validates minimum value of 1
   - Provides utility methods (`isEven()`, `isOdd()`)

3. **`PlayerName`** - Represents a player's name
   - Immutable
   - Validates non-null/non-empty
   - Trims whitespace

**Key Concept**: Value objects encapsulate primitive types with validation and behavior in immutable classes.

---

### Week 4: Factory Pattern

**Pattern**: Factory Method

**Location**: `applicationcode/domainmodel/DiceShakerFactory.java`

**Implementation**:
```java
public class DiceShakerFactory {
    public enum DiceType {
        SINGLE, DOUBLE, FIXED
    }
    
    public DiceShaker createDiceShaker(DiceType type) {
        return switch (type) {
            case SINGLE -> new RandomSingleDiceShaker();
            case DOUBLE -> new RandomDoubleDiceShaker();
            case FIXED -> new FixedDiceShaker(1, 2, 3, 4, 5, 6);
        };
    }
}
```

**Key Concept**: Centralized object creation logic, making it easy to add new dice types without changing client code.

---

### Week 5: Observer Pattern

**Pattern**: Observer (Publisher-Subscriber)

**Location**: `applicationcode/domainmodel/`

**Implementation**:
- `GameEventListener` interface (Observer)
- `ConsoleGameEventListener` concrete observer
- `Game` class maintains list of observers and notifies them

**Events**:
- `onGameStarted(PlayerName)` - when game begins
- `onRollMade(PlayerName, Roll, Score)` - after each dice roll
- `onGameFinished(PlayerName, Score)` - when game ends

**Key Concept**: Decouples the game logic from how events are handled. Easy to add new listeners (e.g., file logger, GUI updater) without changing Game class.

```java
Game game = new Game(diceShaker);
game.addListener(new ConsoleGameEventListener());
game.addListener(new FileLogger()); // Easy to add more
```

---

### Week 6: Facade Pattern

**Pattern**: Facade

**Location**: `applicationcode/usecase/play/UseCase.java`

**Implementation**:
The UseCase classes provide a simplified interface to the complex game subsystem:

```java
public int play() {
    // Simplifies the entire game setup and play process
    DiceShakerFactory factory = new DiceShakerFactory();
    DiceShaker diceShaker = factory.createDiceShaker(SINGLE);
    Game game = new Game(diceShaker);
    game.addListener(new ConsoleGameEventListener());
    game.start(new PlayerName("Player 1"));
    for (int i = 0; i < 5; i++) {
        game.rollDice();
    }
    game.finish();
    return gameId;
}
```

**Key Concept**: Provides a simple interface to complex subsystem operations. Clients don't need to know about factories, observers, or state management.

---

### Week 7: State Pattern

**Pattern**: State Machine

**Location**: `applicationcode/domainmodel/`

**Implementation**:

**Context**: `Game` (implements `GameContext`)

**State Interface**: `GameState` with methods:
- `start(GameContext, PlayerName)`
- `rollDice(GameContext)`
- `finish(GameContext)`
- `getStatusMessage()`

**Concrete States**:
1. **`NotStartedState`** - Initial state
   - Allows: `start()`
   - Blocks: `rollDice()`, `finish()`
   
2. **`PlayingState`** - Game in progress
   - Allows: `rollDice()`, `finish()`
   - Blocks: `start()`
   - Auto-finishes after 10 rolls
   
3. **`FinishedState`** - Game complete
   - Blocks all operations

**State Transition Diagram**:
```
[NotStarted] --start()--> [Playing] --finish()--> [Finished]
                            |
                            |--rollDice() [count >= 10]
                            |
                            v
                         [Finished]
```

**Key Concept**: Each state handles requests differently. The Game delegates behavior to its current state, eliminating complex conditional logic.

---

## 🏗️ Architecture

The project follows **Clean Architecture** principles:

### Domain Model Layer
`applicationcode/domainmodel/`
- Contains all business logic and design patterns
- No dependencies on frameworks or infrastructure

### Use Case Layer
`applicationcode/usecase/`
- Orchestrates domain objects to fulfill application use cases
- Acts as Facade to domain complexity

### Infrastructure Layer
`infrastructure/`
- Spring Boot configuration
- External interface implementations

---

## 🎲 Game Flow

1. **Initialization**:
   - Spring Boot starts
   - AppConfig creates beans using Dependency Injection
   - CommandLineRunner beans execute in order

2. **Play Use Case** (runs first):
   - Factory creates single dice shaker
   - Game object created with observer attached
   - Game starts (state: NotStarted → Playing)
   - 5 dice rolls executed
   - Game finishes (state: Playing → Finished)
   - Returns game ID

3. **Replay Use Case** (runs second):
   - Prompts for game ID
   - Factory creates double dice shaker (different implementation)
   - New game created and played with different dice type
   - Demonstrates polymorphism and factory pattern

---

## 🔍 Key Learning Outcomes

1. **Interfaces enable polymorphism** - Multiple dice implementations work interchangeably
2. **Value Objects improve design** - Encapsulation, validation, immutability
3. **Factories centralize creation** - Easy to add new types
4. **Observers decouple notification** - Easy to add new listeners
5. **Facades simplify complexity** - Clean API for complex operations
6. **States eliminate conditionals** - Each state handles its own behavior

---

## 🛠️ Extension Ideas

Want to practice more? Try adding:

1. **New Dice Types** (Factory Pattern):
   - `TripleDiceShaker` (3 dice, 3-18)
   - `LoadedDiceShaker` (biased towards high numbers)

2. **New Observers** (Observer Pattern):
   - `FileGameEventListener` - logs to file
   - `StatisticsListener` - tracks averages

3. **New States** (State Pattern):
   - `PausedState` - game can be paused/resumed
   - Add timer for auto-timeout

4. **Value Objects**:
   - `GameId` value object instead of primitive int
   - `NumberOfRolls` value object with validation

5. **Strategy Pattern**:
   - Different scoring strategies (double evens, bonus for 6s, etc.)

---

## 📖 References

- Google Java Style Guide (followed throughout)
- Course Labs (Weeks 1-7)
- Gang of Four Design Patterns
- Clean Architecture by Robert C. Martin


