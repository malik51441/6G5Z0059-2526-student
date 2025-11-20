# Week 5: Decorator & Observer Patterns - Learning Guide

## 🎯 Learning Objectives

By the end of Week 5, you should understand:
- What the Observer pattern is and when to use it
- What the Decorator pattern is and when to use it
- How to decouple event sources from event handlers
- How to add behavior dynamically without modifying existing code
- The Open/Closed Principle in practice

---

## 📋 Part 1: Observer Pattern

### What is the Observer Pattern?

The **Observer Pattern** allows objects to notify multiple observers about events without knowing who is listening. It decouples the event source from the event handlers.

**Real-world analogy:**
- YouTube channel (Subject) → Subscribers (Observers)
- When a new video is posted, all subscribers are notified
- Subscribers can subscribe/unsubscribe at any time

**Benefits:**
- Decouples event source from handlers
- Easy to add/remove observers
- Follows Open/Closed Principle (open for extension, closed for modification)

---

### Task 1: Create GameEventListener Interface (Observer)

**Location**: `applicationcode/domainmodel/`

**Steps:**

1. **Create the Observer interface:**
```java
public interface GameEventListener {
    void onGameStarted(PlayerName playerName);
    void onRollMade(PlayerName playerName, DiceRoll roll, Score score);
    void onGameFinished(PlayerName playerName, Score finalScore);
}
```

**💡 Think about:**
- What information does each observer need?
- Should observers be able to modify the game? (No - they just observe!)

---

### Task 2: Create Concrete Observer Implementations

**Steps:**

1. **Create ConsoleGameEventListener:**
```java
public class ConsoleGameEventListener implements GameEventListener {
    @Override
    public void onGameStarted(PlayerName playerName) {
        System.out.println("🎮 Game started for player: " + playerName);
    }
    
    @Override
    public void onRollMade(PlayerName playerName, DiceRoll roll, Score score) {
        System.out.println("🎲 " + playerName + " rolled " + roll + " → Score: " + score);
    }
    
    @Override
    public void onGameFinished(PlayerName playerName, Score finalScore) {
        System.out.println("🏁 Game finished! " + playerName + " final score: " + finalScore);
    }
}
```

2. **Create NullGameEventListener (optional - for testing):**
```java
public class NullGameEventListener implements GameEventListener {
    @Override
    public void onGameStarted(PlayerName playerName) {
        // Do nothing
    }
    
    @Override
    public void onRollMade(PlayerName playerName, DiceRoll roll, Score score) {
        // Do nothing
    }
    
    @Override
    public void onGameFinished(PlayerName playerName, Score finalScore) {
        // Do nothing
    }
}
```

**💡 Think about:**
- Why might you want a "null" observer? (Testing, optional logging)

---

### Task 3: Create Game Class with Observer Support

**Location**: `applicationcode/domainmodel/`

**Steps:**

1. **Create Game class that maintains observers:**
```java
public class Game {
    private final List<GameEventListener> listeners = new ArrayList<>();
    private final DiceShaker diceShaker;
    private PlayerName currentPlayer;
    private Score currentScore;
    
    public Game(DiceShaker diceShaker) {
        this.diceShaker = diceShaker;
        this.currentScore = Score.ZERO;
    }
    
    public void addListener(GameEventListener listener) {
        listeners.add(listener);
    }
    
    public void removeListener(GameEventListener listener) {
        listeners.remove(listener);
    }
    
    private void notifyGameStarted(PlayerName playerName) {
        for (GameEventListener listener : listeners) {
            listener.onGameStarted(playerName);
        }
    }
    
    private void notifyRollMade(PlayerName playerName, DiceRoll roll, Score score) {
        for (GameEventListener listener : listeners) {
            listener.onRollMade(playerName, roll, score);
        }
    }
    
    private void notifyGameFinished(PlayerName playerName, Score finalScore) {
        for (GameEventListener listener : listeners) {
            listener.onGameFinished(playerName, finalScore);
        }
    }
    
    public void start(PlayerName playerName) {
        this.currentPlayer = playerName;
        this.currentScore = Score.ZERO;
        notifyGameStarted(playerName);
    }
    
    public void rollDice() {
        if (currentPlayer == null) {
            throw new IllegalStateException("Game not started");
        }
        
        int rollValue = diceShaker.shake();
        DiceRoll roll = new DiceRoll(rollValue);
        currentScore = currentScore.add(roll.getValue());
        
        notifyRollMade(currentPlayer, roll, currentScore);
    }
    
    public void finish() {
        if (currentPlayer == null) {
            throw new IllegalStateException("Game not started");
        }
        notifyGameFinished(currentPlayer, currentScore);
    }
    
    public Score getCurrentScore() {
        return currentScore;
    }
}
```

**💡 Key concepts:**
- `addListener()` / `removeListener()` - manage observers
- `notify*()` methods - notify all observers
- Game logic is separate from notification logic

---

## 📋 Part 2: Decorator Pattern

### What is the Decorator Pattern?

The **Decorator Pattern** allows you to add behavior to objects dynamically by wrapping them. It's like adding layers to an onion - each decorator adds a new layer of functionality.

**Real-world analogy:**
- Coffee: Base coffee → Add milk → Add sugar → Add whipped cream
- Each decorator wraps the previous one and adds something

**Benefits:**
- Add behavior without modifying existing code
- Compose behaviors dynamically
- Follows Open/Closed Principle

---

### Task 4: Create DiceShakerDecorator

**Location**: `applicationcode/domainmodel/`

**Steps:**

1. **Create abstract decorator:**
```java
public abstract class DiceShakerDecorator implements DiceShaker {
    protected final DiceShaker wrapped;
    
    public DiceShakerDecorator(DiceShaker wrapped) {
        this.wrapped = wrapped;
    }
    
    @Override
    public int shake() {
        return wrapped.shake();  // Delegate to wrapped object
    }
}
```

**💡 Key concept:**
- Decorator implements the same interface as the component
- Decorator wraps another DiceShaker
- Decorator delegates to wrapped object by default

---

### Task 5: Create Concrete Decorators

**Steps:**

1. **Create LoggingDecorator:**
```java
public class LoggingDiceShakerDecorator extends DiceShakerDecorator {
    
    public LoggingDiceShakerDecorator(DiceShaker wrapped) {
        super(wrapped);
    }
    
    @Override
    public int shake() {
        int result = super.shake();
        System.out.println("  [Logging] Dice rolled: " + result);
        return result;
    }
}
```

2. **Create CountingDecorator:**
```java
public class CountingDiceShakerDecorator extends DiceShakerDecorator {
    private int rollCount = 0;
    
    public CountingDiceShakerDecorator(DiceShaker wrapped) {
        super(wrapped);
    }
    
    @Override
    public int shake() {
        rollCount++;
        int result = super.shake();
        System.out.println("  [Counting] Roll #" + rollCount + ": " + result);
        return result;
    }
    
    public int getRollCount() {
        return rollCount;
    }
}
```

**💡 Think about:**
- How can you combine decorators? (Wrap one decorator with another!)
- What happens if you wrap a decorator with another decorator?

---

## 🎓 Key Concepts

### Observer Pattern
- **Subject**: The object that notifies observers (Game)
- **Observer**: The interface for objects that listen (GameEventListener)
- **Concrete Observer**: Implementation of observer (ConsoleGameEventListener)
- **Decoupling**: Subject doesn't know about concrete observers

### Decorator Pattern
- **Component**: The interface (DiceShaker)
- **Concrete Component**: The base implementation (RandomSingleDiceShaker)
- **Decorator**: Abstract class that wraps components
- **Concrete Decorator**: Adds specific behavior (LoggingDecorator)

---

## 🧪 Testing Your Implementation

### Test Observer Pattern:
```java
Game game = new Game(diceShaker);
game.addListener(new ConsoleGameEventListener());
game.start(new PlayerName("Alice"));
game.rollDice();
game.rollDice();
game.finish();
```

### Test Decorator Pattern:
```java
DiceShaker base = new RandomSingleDiceShaker();
DiceShaker logged = new LoggingDiceShakerDecorator(base);
DiceShaker counted = new CountingDiceShakerDecorator(logged);

counted.shake();  // Should log AND count!
```

### Test Combined:
```java
DiceShaker base = new RandomSingleDiceShaker();
DiceShaker decorated = new CountingDiceShakerDecorator(
    new LoggingDiceShakerDecorator(base)
);

Game game = new Game(decorated);
game.addListener(new ConsoleGameEventListener());
game.start(new PlayerName("Bob"));
game.rollDice();
```

---

## 💡 Hints

1. **Observer Pattern:**
   - Start with the interface (GameEventListener)
   - Then create one concrete observer
   - Then add observer support to Game class
   - Test with one observer before adding more

2. **Decorator Pattern:**
   - Start with abstract decorator
   - Create one simple decorator (Logging)
   - Test it wraps correctly
   - Then create more decorators

3. **Combining Patterns:**
   - Decorators can wrap factories' output
   - Observers can watch decorated objects
   - Patterns work together beautifully!

---

## ✅ Checklist

- [ ] GameEventListener interface created
- [ ] ConsoleGameEventListener implemented
- [ ] Game class with observer support
- [ ] DiceShakerDecorator abstract class
- [ ] LoggingDiceShakerDecorator implemented
- [ ] CountingDiceShakerDecorator implemented
- [ ] Test observers working
- [ ] Test decorators working
- [ ] Test decorators can be combined
- [ ] Integrate into UseCase

---

Good luck! 🚀

