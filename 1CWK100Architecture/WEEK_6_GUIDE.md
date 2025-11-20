# Week 6: Facade & Mediator Patterns - Learning Guide

## 🎯 Learning Objectives

By the end of Week 6, you should understand:
- What the Facade pattern is and when to use it
- What the Mediator pattern is and when to use it
- The difference between stateless and stateful facades
- When to use Facade vs Mediator
- How to simplify complex subsystems
- How to centralize communication between objects

---

## 📋 Part 1: Facade Pattern

### What is the Facade Pattern?

The **Facade Pattern** provides a simplified interface to a complex subsystem. It hides the complexity of multiple classes behind a single, easy-to-use interface.

**Real-world analogy:**
- Restaurant: You order from the waiter (facade), not directly from the kitchen, chef, cashier, etc.
- The waiter coordinates all the complex interactions for you

**Benefits:**
- Simplifies client code
- Hides subsystem complexity
- Reduces coupling between client and subsystem
- Single entry point for operations

---

### Task 1: Create a Stateless Facade for Game Operations

**Location**: `applicationcode/usecase/play/` (or create a new `facade/` package)

**Hints:**

1. **Think about what operations you want to simplify:**
   - Creating a game with a dice shaker
   - Starting a game
   - Rolling dice
   - Finishing a game
   - Adding observers

2. **A stateless facade:**
   - Has NO instance variables (or only final dependencies)
   - Each method is independent
   - Can be called in any order
   - Like a service class

3. **Structure:**
```java
public class GameFacade {
    // Dependencies (final, injected via constructor)
    private final DiceShakerFactory factory;
    
    // Methods that simplify complex operations
    public Game createGameWithSingleDice() {
        // What do you need to do here?
        // Hint: Use the factory, create game, maybe add observer?
    }
    
    public void playSimpleGame(PlayerName playerName, int numberOfRolls) {
        // What steps are needed?
        // Hint: Create game, start, roll dice multiple times, finish
    }
}
```

**💡 Questions to think about:**
- What classes does the client currently need to know about? (Game, DiceShaker, Factory, Observer, etc.)
- Can you hide some of these behind the facade?
- What's the simplest way for a client to play a game?

---

### Task 2: Create a Stateful Facade (Optional)

**Hints:**

1. **A stateful facade:**
   - HAS instance variables that hold state
   - Method call order matters
   - Like a builder or session object

2. **Example structure:**
```java
public class GameFacadeStateful {
    private Game currentGame;  // State!
    private PlayerName currentPlayer;  // State!
    
    public void startNewGame(PlayerName playerName) {
        // Create and store game
    }
    
    public void rollDice() {
        // Use stored game - must call startNewGame first!
    }
    
    public Score finishGame() {
        // Use stored game, return final score
    }
}
```

**💡 Think about:**
- When would you use stateful vs stateless?
- What happens if someone calls `rollDice()` before `startNewGame()`?

---

## 📋 Part 2: Mediator Pattern

### What is the Mediator Pattern?

The **Mediator Pattern** centralizes communication between objects. Instead of objects talking directly to each other, they communicate through a mediator.

**Real-world analogy:**
- Air traffic control: Planes don't talk to each other directly, they talk to the control tower (mediator)
- The mediator coordinates communication between all planes

**Benefits:**
- Reduces coupling between objects
- Centralizes communication logic
- Makes it easier to change how objects interact
- Objects don't need to know about each other

---

### Task 3: Create Mediator Interface and Colleague Marker Interface

**Location**: `applicationcode/mediator/`

**Hints:**

1. **Colleague interface (marker interface - no methods!):**
```java
public interface Colleague {
    // Empty! Just marks classes that can participate in mediation
}
```

2. **Mediator interface:**
```java
public interface GameMediator {
    // What method(s) does the mediator need?
    // Hint: Something like send(String message, Colleague sender)
    // Or maybe: notifyGameEvent(String event, Colleague source)
}
```

**💡 Think about:**
- What events might need to be mediated? (Game started, dice rolled, score changed, etc.)
- What information does the mediator need to route messages?

---

### Task 4: Create Concrete Colleague Classes

**Hints:**

1. **Colleagues need:**
   - To implement `Colleague` interface
   - A reference to the mediator
   - Methods to send messages to mediator
   - Methods to receive notifications from mediator

2. **Example structure:**
```java
public class GameColleague implements Colleague {
    private final GameMediator mediator;
    private Game game;
    
    public GameColleague(GameMediator mediator) {
        this.mediator = mediator;
    }
    
    public void startGame(PlayerName playerName) {
        // Start the game
        // Then notify mediator about the event
        // mediator.send("GAME_STARTED", this);
    }
    
    public void notify(String message) {
        // Called by mediator when other colleagues send messages
        // What should this colleague do with the message?
    }
}
```

**💡 Questions:**
- What colleagues might you need? (Game, ScoreTracker, DiceShaker, etc.)
- What messages should each colleague send?
- What should each colleague do when notified?

---

### Task 5: Create Concrete Mediator

**Hints:**

1. **The mediator needs to:**
   - Know about all colleagues
   - Route messages between them
   - Decide what to do based on the message and sender

2. **Example structure:**
```java
public class ConcreteGameMediator implements GameMediator {
    private GameColleague game;
    private ScoreColleague scoreTracker;
    // ... other colleagues
    
    public void setGame(GameColleague game) {
        this.game = game;
    }
    
    // ... setter methods for other colleagues
    
    @Override
    public void send(String message, Colleague sender) {
        // Based on the message and sender, what should happen?
        // Example:
        // if (message.equals("DICE_ROLLED") && sender == game) {
        //     scoreTracker.notify("UPDATE_SCORE");
        // }
    }
}
```

**💡 Think about:**
- How does the mediator know which colleague to notify?
- What's the communication flow? (Game → Mediator → ScoreTracker)
- Can you make it more flexible?

---

## 🎓 Key Concepts

### Facade Pattern
- **Purpose**: Simplify complex subsystem
- **Client**: Talks only to facade
- **Subsystem**: Hidden behind facade
- **Stateless**: No state, service-like
- **Stateful**: Holds state, method order matters

### Mediator Pattern
- **Purpose**: Centralize communication
- **Colleagues**: Objects that need to communicate
- **Mediator**: Routes messages between colleagues
- **Marker Interface**: Empty interface (Colleague)
- **Decoupling**: Colleagues don't know about each other

---

## 🔍 Facade vs Mediator

| Facade | Mediator |
|--------|----------|
| Client talks to facade only | Client talks to colleagues directly |
| Hides subsystem from client | Colleagues visible to client |
| Facade coordinates operations | Mediator routes messages |
| Simpler client code | More flexible client code |
| Use when: Hide complexity | Use when: Coordinate communication |

---

## 🧪 Testing Your Implementation

### Test Facade:
```java
GameFacade facade = new GameFacade(factory);
Game game = facade.createGameWithSingleDice();
facade.playSimpleGame(new PlayerName("Alice"), 5);
```

### Test Mediator:
```java
GameMediator mediator = new ConcreteGameMediator();
GameColleague game = new GameColleague(mediator);
ScoreColleague score = new ScoreColleague(mediator);

mediator.setGame(game);
mediator.setScore(score);

game.startGame(new PlayerName("Bob"));
// Mediator should coordinate between game and score
```

---

## 💡 Hints

1. **Facade Pattern:**
   - Start simple - what's the most common operation?
   - Hide the complexity of creating Game + DiceShaker + Observer
   - Make it easy for clients to play a game

2. **Mediator Pattern:**
   - Start with the interfaces (Colleague marker, Mediator)
   - Create one colleague first, test it
   - Then add more colleagues
   - Think about what messages need to be sent

3. **When to use which:**
   - **Facade**: Client doesn't need to know about subsystem details
   - **Mediator**: Client needs to work with objects directly, but they need coordination

---

## ✅ Checklist

- [ ] GameFacade (stateless) created
- [ ] GameFacadeStateful (optional) created
- [ ] Colleague marker interface created
- [ ] GameMediator interface created
- [ ] Concrete colleague classes created
- [ ] ConcreteGameMediator implemented
- [ ] Test facade simplifies game operations
- [ ] Test mediator coordinates colleagues
- [ ] Understand when to use Facade vs Mediator

---

Good luck! 🚀

