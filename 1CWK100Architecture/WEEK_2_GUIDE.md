# Week 2: Interfaces & Abstract Classes - Learning Guide

## 🎯 Learning Objectives

By the end of Week 2, you should understand:
- How to define and implement interfaces
- How to create abstract classes
- The difference between interfaces and abstract classes
- Polymorphism through interfaces and abstract classes
- When to use each approach

---

## 📋 Your Tasks

### Task 1: Create the DiceShaker Interface

**What is an interface?**
- An interface defines a **contract** - it says "any class that implements me must provide these methods"
- Interfaces have no implementation (just method signatures)
- A class can implement multiple interfaces

**Your task:**
Create a `DiceShaker` interface in the `domainmodel` package.

**💡 Hints:**
- Use the `interface` keyword (not `class`)
- Define one method: `int shake();`
- No method body - just the signature
- Make it `public` so it can be used from other packages

**Think about:**
- What does this interface promise? (Any class implementing it can "shake" and return an int)
- Why is this useful? (We can write code that works with ANY dice shaker, not just one specific type)

---

### Task 2: Implement RandomSingleDiceShaker

**What is implementation?**
- When a class `implements` an interface, it must provide code for all the interface's methods
- Multiple classes can implement the same interface differently

**Your task:**
Create `RandomSingleDiceShaker` that implements `DiceShaker`.

**💡 Hints:**
- Use `implements DiceShaker` in the class declaration
- You'll need `import java.util.Random;`
- Create a `Random` object as a private field
- Implement `shake()` to return a random number between 1 and 6
- Use `@Override` annotation on the `shake()` method

**Think about:**
- How do you generate a random number between 1 and 6?
  - `random.nextInt(6)` gives 0-5
  - How do you make it 1-6?
- Why use `private final Random random`? (Encapsulation - the Random object is hidden inside)

**Test it:**
```java
DiceShaker shaker = new RandomSingleDiceShaker();
System.out.println("Shake: " + shaker.shake());
```

**Key concept:** Notice the variable type is `DiceShaker` (the interface), not `RandomSingleDiceShaker` (the concrete class). This is **polymorphism**!

---

### Task 3: Implement RandomDoubleDiceShaker

**Your task:**
Create another implementation that shakes TWO dice and returns the sum.

**💡 Hints:**
- Also implements `DiceShaker`
- Also needs a `Random` object
- `shake()` should call `random.nextInt(6) + 1` **twice** and add them together
- Returns a number between 2 and 12

**Think about:**
- How is this different from `RandomSingleDiceShaker`?
- Why can both classes be used with the same `DiceShaker` variable type?

**Test it:**
```java
DiceShaker shaker = new RandomDoubleDiceShaker();
System.out.println("Shake: " + shaker.shake()); // Should be 2-12
```

---

### Task 4: Implement FixedDiceShaker

**Why is this useful?**
- For testing! You can predict what values will be returned
- Makes your code testable and repeatable

**Your task:**
Create `FixedDiceShaker` that returns a fixed sequence of values.

**💡 Hints:**
- Store an array of int values: `private final int[] shakes = new int[]{1, 2, 3, 4, 5, 6};`
- Keep track of current position: `private int index = 0;`
- `shake()` returns `shakes[index]` and then increments index
- What happens when you reach the end? (You could loop back: `index = (index + 1) % shakes.length`)

**Think about:**
- Why is this useful for testing?
- How does this demonstrate that different implementations can behave very differently?

---

### Task 5: Test Polymorphism

**Your task:**
Write code that demonstrates polymorphism - the same variable type can hold different implementations.

**💡 Hints:**
```java
DiceShaker shaker; // Interface type

shaker = new RandomSingleDiceShaker();
System.out.println("Single: " + shaker.shake());

shaker = new RandomDoubleDiceShaker();
System.out.println("Double: " + shaker.shake());

shaker = new FixedDiceShaker();
System.out.println("Fixed: " + shaker.shake());
```

**Key concept:** The variable `shaker` is of type `DiceShaker` (interface), but it can hold any object that implements that interface. This is the power of polymorphism!

---

### Task 6: Create AbstractDiceShaker (Abstract Class)

**What is an abstract class?**
- A class that cannot be instantiated directly
- Can have both implemented methods and abstract methods
- Subclasses must implement the abstract methods

**Your task:**
Create an abstract class `AbstractDiceShaker`.

**💡 Hints:**
- Use `abstract class` keyword
- Can have a `Random` object and a `protected` method `shakeSingleDie()`
- Has an `abstract int shake();` method (no body, just signature)
- `protected` means subclasses can access it, but other classes cannot

**Think about:**
- Why use `protected` instead of `private`? (Subclasses need to call `shakeSingleDie()`)
- What's the difference between this and an interface?
  - Abstract class can have implementation (the `shakeSingleDie()` method)
  - Abstract class can have fields (the `Random` object)

---

### Task 7: Create Concrete Implementations of AbstractDiceShaker

**Your task:**
Create `ConcreteSingleDiceShaker` and `ConcreteDoubleDiceShaker` that extend `AbstractDiceShaker`.

**💡 Hints:**
- Use `extends AbstractDiceShaker` (not `implements`)
- Must implement the `abstract int shake()` method
- Can call `shakeSingleDie()` from the parent class
- Single: return `shakeSingleDie()`
- Double: return `shakeSingleDie() + shakeSingleDie()`

**Test it:**
```java
AbstractDiceShaker shaker = new ConcreteSingleDiceShaker();
System.out.println("Abstract single: " + shaker.shake());
```

**Key concept:** Notice the variable type is `AbstractDiceShaker` (the abstract class), not the concrete class. This is also polymorphism!

---

## 🤔 Key Questions to Answer

1. **Interface vs Abstract Class - When to use which?**
   - Interface: When you want to define a contract that unrelated classes can implement
   - Abstract Class: When you want to share code between related classes

2. **What is polymorphism?**
   - The ability to use a single interface/type to represent different implementations
   - `DiceShaker shaker` can hold any implementation

3. **Why use interfaces?**
   - Allows you to write code that works with any implementation
   - Makes your code flexible and extensible
   - Follows "program to interfaces, not implementations"

---

## ✅ Checklist

Before moving to Week 3, make sure you can:
- [ ] Create an interface with method signatures
- [ ] Implement an interface in a class
- [ ] Create multiple implementations of the same interface
- [ ] Use polymorphism (interface type variable holding different implementations)
- [ ] Create an abstract class
- [ ] Extend an abstract class
- [ ] Understand the difference between `implements` and `extends`
- [ ] Understand when to use interface vs abstract class

---

## 🧪 Testing Your Code

Add test code to your `UseCase.play()` method:

```java
// Test interface implementations
DiceShaker single = new RandomSingleDiceShaker();
DiceShaker double = new RandomDoubleDiceShaker();
DiceShaker fixed = new FixedDiceShaker();

System.out.println("Single dice: " + single.shake());
System.out.println("Double dice: " + double.shake());
System.out.println("Fixed dice: " + fixed.shake());

// Test abstract class implementations
AbstractDiceShaker abstractSingle = new ConcreteSingleDiceShaker();
AbstractDiceShaker abstractDouble = new ConcreteDoubleDiceShaker();

System.out.println("Abstract single: " + abstractSingle.shake());
System.out.println("Abstract double: " + abstractDouble.shake());
```

---

## 📚 Resources

- **Lab Material**: `Labs/Week02Lab01.md`
- **Key Concept**: Polymorphism - one interface, many implementations

---

## 🎯 Next Steps

Once you've completed Week 2:
1. Test all your implementations
2. Make sure everything compiles
3. Update `LEARNING_PROGRESS.md` to mark Week 2 as complete
4. Move on to Week 3: Value Objects & Strategy Pattern

---

**Remember**: The goal is to understand WHY we use interfaces and abstract classes, not just HOW to write them. Think about flexibility and code reuse!

