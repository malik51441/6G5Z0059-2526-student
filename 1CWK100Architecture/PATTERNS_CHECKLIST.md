# Design Patterns Checklist - Week 7 Coursework

## ✅ Week 2: Interface Implementation
- [x] `DiceShaker` interface
- [x] `RandomSingleDiceShaker` implementation
- [x] `RandomDoubleDiceShaker` implementation  
- [x] `FixedDiceShaker` implementation (for testing)
- [x] Demonstrates polymorphism - swappable implementations

**Files**: `DiceShaker.java`, `RandomSingleDiceShaker.java`, `RandomDoubleDiceShaker.java`, `FixedDiceShaker.java`

---

## ✅ Week 3: Value Objects
- [x] `Score` - immutable, validated, content equality
  - [x] Static ZERO singleton
  - [x] `equals()`, `hashCode()`, `toString()`
  - [x] Non-negative validation
- [x] `Roll` - immutable dice roll value object
  - [x] Minimum value validation
  - [x] Utility methods (`isEven()`, `isOdd()`)
- [x] `PlayerName` - immutable player name
  - [x] Non-null/empty validation
  - [x] Whitespace trimming

**Files**: `Score.java`, `Roll.java`, `PlayerName.java`

---

## ✅ Week 4: Factory Pattern
- [x] `DiceShakerFactory` class
- [x] `DiceType` enum (SINGLE, DOUBLE, FIXED)
- [x] `createDiceShaker(DiceType)` method
- [x] `createFixedDiceShaker(int...)` method
- [x] Centralized object creation
- [x] Used in both Play and Replay use cases

**Files**: `DiceShakerFactory.java`

---

## ✅ Week 5: Observer Pattern
- [x] `GameEventListener` interface (Observer)
- [x] `ConsoleGameEventListener` concrete implementation
- [x] `Game` class maintains observers list
- [x] Three event types:
  - [x] `onGameStarted(PlayerName)`
  - [x] `onRollMade(PlayerName, Roll, Score)`
  - [x] `onGameFinished(PlayerName, Score)`
- [x] Observers can be added/removed at runtime
- [x] Decouples event handling from game logic

**Files**: `GameEventListener.java`, `ConsoleGameEventListener.java`, `Game.java`

---

## ✅ Week 6: Facade Pattern
- [x] `play.UseCase` simplifies game setup and execution
- [x] `replay.UseCase` simplifies replay with different dice
- [x] Hides complexity of:
  - Factory creation
  - Observer attachment
  - State management
  - Game initialization
- [x] Provides simple API to clients

**Files**: `applicationcode/usecase/play/UseCase.java`, `applicationcode/usecase/replay/UseCase.java`

---

## ✅ Week 7: State Pattern
- [x] `GameState` interface with state behaviors
- [x] `GameContext` interface for state communication
- [x] Three concrete states:
  - [x] `NotStartedState` - initial state
  - [x] `PlayingState` - game in progress
  - [x] `FinishedState` - game complete
- [x] `Game` class implements GameContext
- [x] State transitions:
  - [x] NotStarted → Playing (on `start()`)
  - [x] Playing → Finished (on `finish()` or max rolls)
- [x] Each state handles operations appropriately
- [x] Invalid operations blocked with messages
- [x] Auto-finish after 10 rolls (guard condition)

**Files**: `GameState.java`, `GameContext.java`, `NotStartedState.java`, `PlayingState.java`, `FinishedState.java`, `Game.java`

---

## 🎯 Additional Best Practices Demonstrated

### Google Java Style Guide
- [x] Proper naming conventions
- [x] Consistent formatting
- [x] JavaDoc comments on key classes
- [x] Package structure follows conventions

### Clean Architecture
- [x] Domain model independent of frameworks
- [x] Use cases orchestrate domain objects
- [x] Infrastructure layer (Spring Boot) separated
- [x] Dependency Injection via Spring

### SOLID Principles
- [x] **Single Responsibility**: Each class has one clear purpose
- [x] **Open/Closed**: Can add new dice types without modifying existing code
- [x] **Liskov Substitution**: All DiceShaker implementations interchangeable
- [x] **Interface Segregation**: Small, focused interfaces
- [x] **Dependency Inversion**: Depend on abstractions (interfaces), not concrete classes

---

## 📊 Pattern Usage Summary

| Pattern | Count | Purpose |
|---------|-------|---------|
| Interface Implementation | 4 | DiceShaker + 3 implementations |
| Value Objects | 3 | Score, Roll, PlayerName |
| Factory | 1 | DiceShakerFactory |
| Observer | 2 | Interface + 1 implementation |
| Facade | 2 | Play & Replay use cases |
| State | 4 | Interface + 3 state classes |
| **Total Classes** | **26** | **Fully working game** |

---

## 🚀 Running the Game

```bash
cd 1CWK100Architecture
./mvnw spring-boot:run
```

When prompted, enter `1` to replay the game.

You'll see:
1. **Game 1**: Single dice (1-6), 5 rolls
2. **Game 2**: Double dice (2-12), 5 rolls

Both games demonstrate different dice implementations working polymorphically through the same interface!

---

## 🎓 Learning Achieved

✅ All Week 1-7 patterns implemented  
✅ Working Spring Boot application  
✅ Clean Architecture structure  
✅ Proper Java style and conventions  
✅ Comprehensive documentation  
✅ Ready for coursework submission  

---

**Last Updated**: Week 7  
**Status**: ✅ Complete and tested


