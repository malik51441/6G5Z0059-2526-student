# Dice Roller Game - Learning Progress Tracker

## 📋 Project Context

**Project**: Dice Roller Game (Assignment for Software Design & Architecture Module)  
**Approach**: Week-by-week incremental implementation following course labs  
**Goal**: Learn design patterns properly by implementing them step-by-step  
**Current Status**: Starting fresh - Week 1/2 foundation

---

## 🎯 Learning Philosophy

- **Incremental Learning**: Implement one week's patterns before moving to the next
- **Best Practices**: Follow Google Java Style Guide, SOLID principles
- **Advanced Patterns**: Include advanced lab exercises where possible
- **Clean Architecture**: Maintain separation of concerns
- **Documentation**: Document decisions and learning points

---

## 📚 Week-by-Week Implementation Plan

### ✅ Week 1: Foundation & Setup
**Status**: ✅ Complete  
**Focus**: Java basics, class structure, equals/hashCode/toString
**Guide**: See `WEEK_1_GUIDE.md` for step-by-step instructions

**Tasks**:
- [x] Set up project structure
- [x] Create basic DiceRoll class
- [x] Implement equals(), hashCode(), toString()
- [x] Understand primitive vs reference types
- [x] Follow Google Java Style Guide

**Key Learning Points**:
- Content equality vs referential equality
- equals() contract (reflexive, symmetric, transitive, consistent)
- hashCode() must match equals()
- Using Objects.hash() for multiple fields

**Files to Create**:
- `DiceRoll.java` - Basic value class

---

### ✅ Week 2: Interfaces & Abstract Classes
**Status**: ✅ Complete  
**Focus**: Interface implementation, polymorphism, packages
**Guide**: See `WEEK_2_GUIDE.md` for step-by-step instructions

**Tasks**:
- [x] Create DiceShaker interface
- [x] Implement RandomSingleDiceShaker
- [x] Implement RandomDoubleDiceShaker
- [x] Implement FixedDiceShaker (for testing)
- [x] Create abstract AbstractDiceShaker class
- [x] Implement concrete classes extending abstract class
- [x] Understand typed references and polymorphism
- [x] Set up proper package structure
- [x] Apply access modifiers correctly

**Key Learning Points**:
- Interface vs Abstract Class - when to use which
- Polymorphism through interfaces
- Package organization
- Access control (public, private, protected, package-private)
- Subtype relationships

**Files to Create**:
- `DiceShaker.java` (interface)
- `RandomSingleDiceShaker.java`
- `RandomDoubleDiceShaker.java`
- `FixedDiceShaker.java`
- `AbstractDiceShaker.java` (abstract class)
- Concrete implementations extending AbstractDiceShaker

**Advanced** (if time):
- Generic interfaces (Comparable, Comparator)
- Command vs Query operations

---

### ✅ Week 3: Value Objects & Strategy Pattern
**Status**: ✅ Complete  
**Focus**: Value Objects, Strategy pattern
**Guide**: See `WEEK_3_GUIDE.md` for step-by-step instructions

**Tasks**:
- [x] Convert DiceRoll to proper Value Object
- [x] Create Score Value Object
- [x] Create PlayerName Value Object
- [x] Create ScoringStrategy interface
- [x] Implement SimpleScoringStrategy
- [x] Implement DoubleEvenScoringStrategy
- [x] Implement BonusSixScoringStrategy
- [ ] Create Roll Value Object (if different from DiceRoll)
- [ ] Implement Strategy pattern for scoring rules
- [ ] Implement Strategy pattern for dice rolling rules
- [ ] Understand immutability and validation

**Key Learning Points**:
- Value Object checklist (immutable, equals/hashCode, toString, static constants)
- Encapsulating primitives in Value Objects
- Strategy pattern for algorithms
- When to use Strategy vs other patterns

**Files to Create**:
- `Score.java` (Value Object)
- `PlayerName.java` (Value Object)
- `Roll.java` (Value Object) - or enhance DiceRoll
- `ScoringStrategy.java` (interface)
- Concrete scoring strategies
- `DiceRollingStrategy.java` (if needed)

**Advanced**:
- Bridge pattern (if applicable)

---

### ✅ Week 4: Factory Patterns & Singletons
**Status**: ✅ Complete  
**Focus**: Factories, Singletons
**Guide**: See `WEEK_4_GUIDE.md` for step-by-step instructions

**Tasks**:
- [x] Create DiceShakerFactory (Abstract Factory)
- [x] Create concrete factories for different dice types
- [x] Implement Factory Method pattern variant
- [x] Create Singleton instances for common values
- [x] Understand differences between factory patterns

**Key Learning Points**:
- Abstract Factory vs Factory Method
- When to use factories
- Singleton pattern for constants
- Centralized object creation

**Files to Create**:
- `DiceShakerFactory.java` (interface)
- Concrete factory implementations
- Or `AbstractDiceShakerFactory.java` with Factory Method
- Singleton constants (e.g., Score.ZERO)

---

### ✅ Week 5: Decorator & Observer Patterns
**Status**: ✅ Complete  
**Focus**: Decorators, Observers
**Guide**: See `WEEK_5_GUIDE.md` for step-by-step instructions

**Tasks**:
- [x] Implement Decorator pattern for DiceShaker
- [x] Create decorators (e.g., LoggingDecorator, CountingDecorator)
- [x] Implement Observer pattern for game events
- [x] Create GameEventListener interface
- [x] Create concrete observers (ConsoleLogger, NullObserver)
- [x] Understand decoupling through observers

**Key Learning Points**:
- Decorator pattern for adding behavior dynamically
- Observer pattern for event notification
- Open/Closed Principle
- Decoupling event source from handlers

**Files to Create**:
- `DiceShakerDecorator.java` (abstract decorator)
- Concrete decorators
- `GameEventListener.java` (Observer interface)
- Concrete observer implementations
- Game class with observer support

**Advanced**:
- Command pattern for undo/redo (if applicable)

---

### ✅ Week 6: Facade & Mediator Patterns
**Status**: 🚧 In Progress  
**Focus**: Facades, Mediators
**Guide**: See `WEEK_6_GUIDE.md` for step-by-step instructions

**Tasks**:
- [ ] Create Facade for game operations
- [ ] Implement stateless facade
- [ ] Implement stateful facade (if needed)
- [ ] Create Mediator for coordinating game components
- [ ] Understand when to use Facade vs Mediator

**Key Learning Points**:
- Facade simplifies complex subsystem
- Stateless vs Stateful facades
- Mediator centralizes communication
- Reducing coupling between classes

**Files to Create**:
- `GameFacade.java` (stateless)
- `GameFacadeStateful.java` (if needed)
- `GameMediator.java` (interface)
- `ConcreteGameMediator.java`
- Colleague interfaces/classes

---

### ✅ Week 7: State Pattern
**Status**: Not Started  
**Focus**: State machines, State pattern

**Tasks**:
- [ ] Design game state machine
- [ ] Create GameState interface
- [ ] Create GameContext interface
- [ ] Implement concrete states (NotStarted, Playing, Finished)
- [ ] Implement state transitions
- [ ] Add guard conditions
- [ ] Add actions on transitions

**Key Learning Points**:
- State pattern eliminates complex conditionals
- State machines for lifecycle management
- Guard conditions and actions
- State transition tables

**Files to Create**:
- `GameState.java` (interface)
- `GameContext.java` (interface)
- `NotStartedState.java`
- `PlayingState.java`
- `FinishedState.java`
- `Game.java` (implements GameContext)

**Advanced**:
- Nested classes for encapsulation
- Entry/exit actions

---

## 🏗️ Project Structure

```
1CWK100Architecture/
├── src/main/java/uk/ac/mmu/game/
│   ├── SoftwareProduct.java (Spring Boot main)
│   ├── AppConfig.java (Spring configuration)
│   ├── Play.java (CommandLineRunner)
│   ├── Replay.java (CommandLineRunner)
│   └── applicationcode/
│       ├── domainmodel/
│       │   └── (Week-by-week domain classes)
│       └── usecase/
│           ├── play/
│           └── replay/
└── LEARNING_PROGRESS.md (this file)
```

---

## 📝 Implementation Notes

### Decisions Made:
- Using Spring Boot for dependency injection
- Clean Architecture structure (domain, usecase, infrastructure)
- Following Google Java Style Guide

### Challenges Encountered:
- (To be filled as we progress)

### Key Insights:
- (To be filled as we progress)

---

## 🎓 Learning Resources

- Course Labs: `/Labs/WeekXXLabXX.md`
- Google Java Style Guide
- Design Patterns: Elements of Reusable Object-Oriented Software (Gang of Four)
- Clean Architecture by Robert C. Martin

---

## 📊 Progress Summary

| Week | Status | Patterns Implemented | Files Created |
|------|--------|---------------------|---------------|
| 1 | ⏳ Not Started | - | 0 |
| 2 | ⏳ Not Started | Interface, Abstract Class | 0 |
| 3 | ⏳ Not Started | Value Object, Strategy | 0 |
| 4 | ⏳ Not Started | Factory, Singleton | 0 |
| 5 | ⏳ Not Started | Decorator, Observer | 0 |
| 6 | ⏳ Not Started | Facade, Mediator | 0 |
| 7 | ⏳ Not Started | State | 0 |

**Legend**: ⏳ Not Started | 🚧 In Progress | ✅ Complete

---

## 🔄 Session History

### Session 1 - [Current Date]
- **Action**: Created learning progress tracker and reset codebase
- **Decision**: Starting fresh, removing previous implementation, going week-by-week
- **Files Created**: 
  - `LEARNING_PROGRESS.md` - Progress tracking
  - `WEEK_1_GUIDE.md` - Week 1 learning guide with hints
- **Code Reset**: Removed all domain model classes, reset use cases to basic state
- **Next Steps**: Begin Week 1 implementation following `WEEK_1_GUIDE.md`

---

## 💡 Tips for Learning

1. **One Week at a Time**: Don't jump ahead - master each week before moving on
2. **Test Everything**: Write test code in main() to verify behavior
3. **Refactor**: As you learn new patterns, refactor previous code if it makes sense
4. **Document**: Add comments explaining why you made design decisions
5. **Ask Questions**: Note any confusion or questions in this file

---

**Last Updated**: 2025-11-20  
**Current Week**: Week 6 - Facade & Mediator Patterns  
**Next Session Goal**: Create factories for DiceShaker creation and understand Singleton pattern

