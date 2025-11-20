# Week 3: Value Objects & Strategy Pattern - Learning Guide

## 🎯 Learning Objectives

By the end of Week 3, you should understand:
- What Value Objects are and why they're important
- How to create proper Value Objects (immutable, validated, content equality)
- The Strategy pattern for encapsulating algorithms
- When to use Value Objects instead of primitives
- When to use Strategy pattern

---

## 📋 Part 1: Value Objects

### What is a Value Object?

A **Value Object** is an immutable class that represents a value or measure. Think of it like a primitive type (int, String) but with:
- **Validation** - ensures the value is always valid
- **Behavior** - methods that make sense for that value
- **Type safety** - prevents mixing up different types of values

**Example**: Instead of using `int score`, use `Score score` - this prevents accidentally using a player ID where a score should go!

---

### Task 1: Convert DiceRoll to a Proper Value Object

You already have a `DiceRoll` class, but let's make it a proper Value Object.

**Value Object Checklist:**
- ✅ All fields are `final` (immutable)
- ✅ Constructor validates the value
- ✅ Implements `equals()` and `hashCode()` (content equality)
- ✅ Implements `toString()`
- ✅ Optional: Static constants for common values

**Your DiceRoll should:**
1. Validate that the value is between 1 and 6 (or at least >= 1)
2. Be immutable (field is already `final` - good!)
3. Have proper equals/hashCode/toString (you already have these!)

**💡 Hint**: Add validation in the constructor:
```java
public DiceRoll(int value) {
    if (value < 1 || value > 6) {
        throw new IllegalArgumentException("Dice roll must be between 1 and 6");
    }
    this.value = value;
}
```

---

### Task 2: Create a Score Value Object

**Purpose**: Represent a game score instead of using a raw `int`.

**Requirements:**
- Immutable (all fields `final`)
- Non-negative validation (score can't be negative)
- Content equality (equals/hashCode)
- toString() method
- Optional: Static constant `Score.ZERO = new Score(0)`

**💡 Hints:**
- Field: `private final int value;`
- Constructor validates: `if (value < 0) throw new IllegalArgumentException(...)`
- Static constant: `public static final Score ZERO = new Score(0);`
- Methods: `getValue()`, `equals()`, `hashCode()`, `toString()`

**Think about:**
- Why can't a score be negative?
- Why use a Value Object instead of `int`? (Type safety, validation, behavior)

---

### Task 3: Create a PlayerName Value Object

**Purpose**: Represent a player's name instead of using a raw `String`.

**Requirements:**
- Immutable
- Non-null and non-empty validation
- Trim whitespace
- Content equality
- toString() method

**💡 Hints:**
- Field: `private final String name;`
- Constructor: `if (name == null || name.trim().isEmpty()) throw ...`
- Trim: `this.name = name.trim();`
- Methods: `getName()`, `equals()`, `hashCode()`, `toString()`

**Think about:**
- Why trim whitespace? (User might type "  Player1  " by mistake)
- Why validate non-empty? (Empty name doesn't make sense)

---

### Task 4: Create a Roll Value Object (if different from DiceRoll)

**Note**: You might already have `DiceRoll`. If you want a more general `Roll` that can represent any roll value (not just 1-6), create it.

**Or**: Enhance `DiceRoll` to be more general, or keep it as-is for dice-specific rolls.

---

## 📋 Part 2: Strategy Pattern

### What is the Strategy Pattern?

The **Strategy Pattern** encapsulates an algorithm (a way of doing something) so you can swap different algorithms at runtime.

**Real-world example**: Different shipping cost calculations (UK = free, Europe = £1.25/kg, Rest of World = £5.50/kg)

---

### Task 5: Create a Scoring Strategy

**Purpose**: Different ways to calculate scores from dice rolls.

**Example strategies:**
- **SimpleScoringStrategy**: Just add the roll value
- **DoubleEvenStrategy**: Double the value if it's even
- **BonusSixStrategy**: Add 5 bonus points if you roll a 6

**Steps:**

1. **Create the Strategy Interface:**
```java
public interface ScoringStrategy {
    Score calculateScore(Score currentScore, DiceRoll roll);
}
```

2. **Create Concrete Strategies:**
   - `SimpleScoringStrategy` - just adds roll value
   - `DoubleEvenScoringStrategy` - doubles even rolls
   - `BonusSixScoringStrategy` - adds bonus for 6

3. **Use the Strategy:**
```java
ScoringStrategy strategy = new SimpleScoringStrategy();
Score newScore = strategy.calculateScore(currentScore, roll);
```

**💡 Hints:**
- The strategy takes current score and a roll, returns new score
- Each strategy implements the interface differently
- You can swap strategies at runtime!

---

## 🎓 Key Concepts

### Value Objects - Why?

**Before (using primitives):**
```java
int score = -5;  // ❌ Invalid! But compiler doesn't catch it
String playerName = "";  // ❌ Empty! But no validation
```

**After (using Value Objects):**
```java
Score score = new Score(-5);  // ✅ Throws exception - caught immediately!
PlayerName name = new PlayerName("");  // ✅ Throws exception - validation!
```

**Benefits:**
- **Type Safety**: Can't mix up `Score` and `PlayerId`
- **Validation**: Invalid values caught at creation
- **Immutability**: Once created, can't be changed (thread-safe)
- **Behavior**: Can add methods like `Score.add(Score other)`

---

### Strategy Pattern - Why?

**Before (using if/else):**
```java
if (destination == UK) {
    cost = 0;
} else if (destination == EUROPE) {
    cost = weight * 1.25;
} else {
    cost = Math.max(10, weight * 5.50);
}
```

**After (using Strategy):**
```java
ShippingStrategy strategy = strategyFactory.getStrategy(destination);
cost = strategy.calculate(weight);
```

**Benefits:**
- **Open/Closed Principle**: Add new strategies without changing existing code
- **Single Responsibility**: Each strategy handles one algorithm
- **Testability**: Easy to test each strategy independently
- **Flexibility**: Swap strategies at runtime

---

## ✅ Checklist

Before moving to Week 4, make sure you can:
- [ ] Create a Value Object with proper validation
- [ ] Understand immutability (all fields final)
- [ ] Implement content equality (equals/hashCode)
- [ ] Create static constants for common values
- [ ] Create a Strategy interface
- [ ] Implement multiple concrete strategies
- [ ] Use strategies polymorphically
- [ ] Understand when to use Value Objects vs primitives
- [ ] Understand when to use Strategy vs if/else

---

## 🧪 Testing Your Code

Test your Value Objects:
```java
// Test validation
try {
    Score negative = new Score(-1);  // Should throw exception
} catch (IllegalArgumentException e) {
    System.out.println("Good! Caught invalid score");
}

// Test immutability
Score score1 = new Score(10);
Score score2 = new Score(10);
System.out.println(score1.equals(score2));  // Should be true

// Test static constant
System.out.println(Score.ZERO);  // Should work
```

Test your Strategies:
```java
ScoringStrategy simple = new SimpleScoringStrategy();
ScoringStrategy doubleEven = new DoubleEvenScoringStrategy();

Score current = new Score(5);
DiceRoll roll = new DiceRoll(3);

Score newScore1 = simple.calculateScore(current, roll);  // 5 + 3 = 8
Score newScore2 = doubleEven.calculateScore(current, roll);  // 5 + (3*2) = 11
```

---

## 📚 Resources

- **Lab Material**: `Labs/Week03Lab01.md`
- **Key Concept**: Value Objects encapsulate validation and behavior
- **Key Concept**: Strategy Pattern encapsulates algorithms

---

## 🎯 Next Steps

Once you've completed Week 3:
1. Test all your Value Objects
2. Test all your Strategies
3. Make sure everything compiles
4. Update `LEARNING_PROGRESS.md` to mark Week 3 as complete
5. Move on to Week 4: Factory Patterns & Singletons

---

**Remember**: Value Objects make your code safer and more expressive. Strategy Pattern makes your code more flexible and maintainable!

