# Week 4: Factory Patterns & Singletons - Learning Guide

## 🎯 Learning Objectives

By the end of Week 4, you should understand:
- What the Singleton pattern is and when to use it
- What Factory patterns are (Abstract Factory and Factory Method)
- The difference between Abstract Factory and Factory Method
- When to use factories vs direct instantiation
- How to create centralized object creation

---

## 📋 Part 1: Singleton Pattern

### What is a Singleton?

A **Singleton** is a single instance of a class that exists throughout the program's lifetime. In Java, we often use `static final` fields to hold singleton instances.

**Common use cases:**
- Constants (like `Score.ZERO`)
- Configuration objects
- Shared resources

---

### Task 1: Create Singleton Constants in Score

You already have `Score.ZERO` - that's a singleton! But let's make sure you understand it.

**What you already have:**
```java
public static final Score ZERO = new Score(0);
```

**Why is this a singleton?**
- `static` = belongs to the class, not instances
- `final` = can't be reassigned
- Only one instance exists (shared by all code)

**💡 Think about:**
- Why use `Score.ZERO` instead of `new Score(0)` every time?
  - Answer: Saves memory, ensures same instance, clearer intent

---

## 📋 Part 2: Factory Pattern (Abstract Factory)

### What is a Factory?

A **Factory** is a class or method that creates objects for you. Instead of using `new` directly, you ask the factory to create the object.

**Benefits:**
- Centralized creation logic
- Easy to swap implementations
- Can add validation/logging
- Hides complexity

---

### Task 2: Create DiceShakerFactory

**Purpose**: Create different types of DiceShakers without using `new` directly.

**Steps:**

1. **Create the Factory Interface:**
```java
public interface DiceShakerFactory {
    DiceShaker create();
}
```

2. **Create Concrete Factories:**
   - `SingleDiceShakerFactory` - creates `RandomSingleDiceShaker`
   - `DoubleDiceShakerFactory` - creates `RandomDoubleDiceShaker`
   - `FixedDiceShakerFactory` - creates `FixedDiceShaker`

3. **Use the Factory:**
```java
DiceShakerFactory factory = new SingleDiceShakerFactory();
DiceShaker shaker = factory.create();
```

**💡 Hints:**
- Each factory implements the interface
- `create()` method returns a `DiceShaker`
- Each factory creates a different type

**Think about:**
- Why use a factory instead of `new RandomSingleDiceShaker()`?
  - Answer: Can swap factories at runtime, centralized logic, easier testing

---

### Task 3: Alternative - Factory with Enum

**Another approach**: Use an enum or method parameter to choose the type.

**Option A: Factory with Enum:**
```java
public class DiceShakerFactory {
    public enum DiceType {
        SINGLE, DOUBLE, FIXED
    }
    
    public DiceShaker create(DiceType type) {
        return switch (type) {
            case SINGLE -> new RandomSingleDiceShaker();
            case DOUBLE -> new RandomDoubleDiceShaker();
            case FIXED -> new FixedDiceShaker();
        };
    }
}
```

**Option B: Separate Factory Classes (Abstract Factory Pattern):**
```java
// Interface
public interface DiceShakerFactory {
    DiceShaker create();
}

// Concrete factories
public class SingleDiceShakerFactory implements DiceShakerFactory {
    @Override
    public DiceShaker create() {
        return new RandomSingleDiceShaker();
    }
}
```

**💡 Which to use?**
- **Enum approach**: Simpler, all in one class
- **Separate classes**: More flexible, follows Abstract Factory pattern exactly

For learning, try **both approaches** to understand the difference!

---

## 📋 Part 3: Factory Method Pattern

### What is Factory Method?

**Factory Method** uses an abstract class with a `create()` method and an abstract `factoryMethod()`.

**Key difference from Abstract Factory:**
- Abstract Factory: Interface-based, multiple unrelated factories
- Factory Method: Class-based, related factories with shared code

---

### Task 4: Create AbstractDiceShakerFactory (Factory Method)

**Steps:**

1. **Create Abstract Factory Class:**
```java
public abstract class AbstractDiceShakerFactory {
    // Common code (if any)
    
    public DiceShaker create() {
        // Can do common setup here
        return factoryMethod();
    }
    
    protected abstract DiceShaker factoryMethod();
}
```

2. **Create Concrete Factories:**
```java
public class SingleDiceShakerFactoryMethod extends AbstractDiceShakerFactory {
    @Override
    protected DiceShaker factoryMethod() {
        return new RandomSingleDiceShaker();
    }
}
```

**💡 Key concept:**
- `create()` is public (client calls this)
- `factoryMethod()` is protected abstract (subclasses implement)
- Can add common code in `create()` before/after calling `factoryMethod()`

---

## 🎓 Key Concepts

### Singleton Pattern

**When to use:**
- Single instance needed (constants, configuration)
- Shared resource
- Immutable objects (like Value Objects)

**Example:**
```java
public static final Score ZERO = new Score(0);
```

**Why not make the whole class a singleton?**
- Usually not needed for Value Objects
- Can create many instances (Score(10), Score(20), etc.)
- Only common values need singletons

---

### Abstract Factory Pattern

**Structure:**
- Factory interface
- Multiple concrete factory classes
- Each factory creates one type of product

**When to use:**
- Need to create families of related objects
- Want to swap entire families at runtime
- Want to hide creation logic

**Example:**
```java
DiceShakerFactory factory = new SingleDiceShakerFactory();
DiceShaker shaker = factory.create();
```

---

### Factory Method Pattern

**Structure:**
- Abstract factory class
- Abstract factory method
- Concrete subclasses implement factory method

**When to use:**
- Related factories that share common code
- Want to add behavior before/after creation
- Template method pattern for creation

**Example:**
```java
AbstractDiceShakerFactory factory = new SingleDiceShakerFactoryMethod();
DiceShaker shaker = factory.create();
```

---

## 🤔 Key Questions

1. **What's the difference between Abstract Factory and Factory Method?**
   - Abstract Factory: Interface-based, separate classes
   - Factory Method: Abstract class-based, shared code possible

2. **When would you use a Factory instead of `new`?**
   - When creation logic is complex
   - When you want to swap implementations
   - When you want centralized control

3. **What's the difference between Singleton and regular static fields?**
   - Singleton: Single instance (object)
   - Static field: Single value (primitive or object)

---

## ✅ Checklist

Before moving to Week 5, make sure you can:
- [ ] Understand what a Singleton is
- [ ] Create singleton constants (like `Score.ZERO`)
- [ ] Create a Factory interface
- [ ] Implement multiple concrete factories
- [ ] Use factories to create objects
- [ ] Understand Abstract Factory pattern
- [ ] Understand Factory Method pattern
- [ ] Know when to use each pattern

---

## 🧪 Testing Your Code

Test your factories:
```java
// Test Abstract Factory
DiceShakerFactory singleFactory = new SingleDiceShakerFactory();
DiceShakerFactory doubleFactory = new DoubleDiceShakerFactory();

DiceShaker shaker1 = singleFactory.create();
DiceShaker shaker2 = doubleFactory.create();

System.out.println("Single: " + shaker1.shake());
System.out.println("Double: " + shaker2.shake());

// Test Factory Method
AbstractDiceShakerFactory factoryMethod = new SingleDiceShakerFactoryMethod();
DiceShaker shaker3 = factoryMethod.create();
System.out.println("Factory Method: " + shaker3.shake());
```

---

## 📚 Resources

- **Lab Material**: `Labs/Week04Lab01.md`, `Labs/Week04Lab02.md`
- **Key Concept**: Factories centralize object creation
- **Key Concept**: Singletons provide single shared instances

---

## 🎯 Next Steps

Once you've completed Week 4:
1. Test all your factories
2. Make sure everything compiles
3. Update `LEARNING_PROGRESS.md` to mark Week 4 as complete
4. Move on to Week 5: Decorator & Observer Patterns

---

**Remember**: Factories make your code more flexible. Instead of hardcoding `new RandomSingleDiceShaker()`, you can swap factories at runtime!

