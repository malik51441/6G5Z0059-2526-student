# Week 1: Foundation & Java Basics - Learning Guide

## 🎯 Learning Objectives

By the end of Week 1, you should understand:
- How to structure a Java class properly
- The difference between referential equality (`==`) and content equality (`equals()`)
- How to implement `equals()`, `hashCode()`, and `toString()` correctly
- Why these methods are important for object-oriented design

---

## 📋 Your Task: Create a DiceRoll Class

### Step 1: Create the Basic Class Structure

**Hint**: Start with a simple class that encapsulates a dice roll value.

**Questions to think about**:
- What should the field be? (Hint: it's a value that won't change after creation)
- Should the field be `final`? Why or why not?
- What access modifier should the field have? (Think about encapsulation)

**Your starting point**:
```java
package uk.ac.mmu.game.applicationcode.domainmodel;

class DiceRoll {
    // TODO: Add a field to store the dice roll value
    // TODO: Add a constructor
}
```

**💡 Hint**: Look at the Week01Lab02.md file - it shows you the basic structure!

---

### Step 2: Implement equals()

**Why is this important?**
- `==` checks if two references point to the same object (referential equality)
- `equals()` should check if two objects have the same content (content equality)
- Two `DiceRoll(6)` objects should be equal even if they're different objects

**What to implement**:
```java
@Override
public boolean equals(Object obj) {
    // TODO: Implement content equality
    // Remember: obj might be null or a different type!
}
```

**💡 Hints**:
1. First check: `if (this == obj) return true;` - same object reference
2. Second check: `if (obj == null || getClass() != obj.getClass()) return false;` - null or wrong type
3. Cast and compare: `DiceRoll other = (DiceRoll) obj; return value == other.value;`

**Test it**:
```java
DiceRoll dice1 = new DiceRoll(6);
DiceRoll dice2 = new DiceRoll(6);
System.out.println(dice1 == dice2);        // Should print: false (different objects)
System.out.println(dice1.equals(dice2));   // Should print: true (same content)
```

---

### Step 3: Implement hashCode()

**Why is this important?**
- If two objects are equal, they MUST have the same hash code
- Used by collections like `HashMap`, `HashSet`
- If you override `equals()`, you MUST override `hashCode()`

**What to implement**:
```java
@Override
public int hashCode() {
    // TODO: Return a hash code based on the value
}
```

**💡 Hints**:
- For a single `int` field, you can use: `return Integer.hashCode(value);`
- Or simply: `return value;` (since int's hash code is itself)
- For multiple fields, use: `Objects.hash(field1, field2, ...)`

**Test it**:
```java
DiceRoll dice1 = new DiceRoll(6);
DiceRoll dice2 = new DiceRoll(6);
System.out.println(dice1.hashCode() == dice2.hashCode()); // Should print: true
```

---

### Step 4: Implement toString()

**Why is this important?**
- Makes debugging easier
- Provides readable representation of the object
- Used automatically by `System.out.println()`

**What to implement**:
```java
@Override
public String toString() {
    // TODO: Return a string representation
}
```

**💡 Hints**:
- Use `String.format()` or string concatenation
- Example: `return String.format("DiceRoll(%d)", value);`
- Or: `return "DiceRoll(" + value + ")";`

**Test it**:
```java
DiceRoll dice = new DiceRoll(6);
System.out.println(dice); // Should print something like: DiceRoll(6)
```

---

### Step 5: Add a Getter (Optional but Recommended)

**Why?**
- Follows encapsulation principles
- Allows controlled access to the value

```java
public int getValue() {
    return value;
}
```

---

## 🧪 Testing Your Implementation

Create a test in the `UseCase.play()` method or create a simple test class:

```java
public static void main(String[] args) {
    // Test 1: Referential vs Content Equality
    DiceRoll dice1 = new DiceRoll(6);
    DiceRoll dice2 = new DiceRoll(6);
    System.out.println("dice1 == dice2: " + (dice1 == dice2));           // false
    System.out.println("dice1.equals(dice2): " + dice1.equals(dice2));   // true
    
    // Test 2: Hash Codes
    System.out.println("dice1.hashCode(): " + dice1.hashCode());
    System.out.println("dice2.hashCode(): " + dice2.hashCode());
    System.out.println("Same hash codes: " + (dice1.hashCode() == dice2.hashCode())); // true
    
    // Test 3: toString()
    System.out.println("dice1: " + dice1); // Should print nicely
    
    // Test 4: Different values
    DiceRoll dice3 = new DiceRoll(3);
    System.out.println("dice1.equals(dice3): " + dice1.equals(dice3));   // false
}
```

---

## 🎓 Key Concepts to Understand

### 1. Referential Equality (`==`)
- Checks if two references point to the **same object in memory**
- For primitives, compares values
- For objects, compares memory addresses

### 2. Content Equality (`equals()`)
- Checks if two objects have the **same content/state**
- Must be overridden to work correctly
- Default implementation just uses `==`

### 3. The equals() Contract
Your `equals()` method must be:
- **Reflexive**: `x.equals(x)` is always true
- **Symmetric**: `x.equals(y)` == `y.equals(x)`
- **Transitive**: If `x.equals(y)` and `y.equals(z)`, then `x.equals(z)`
- **Consistent**: Multiple calls return the same result (if objects don't change)

### 4. hashCode() Contract
- If `x.equals(y)` is true, then `x.hashCode() == y.hashCode()` must be true
- If `x.equals(y)` is false, hash codes can be the same (but should be different for performance)

---

## 🚀 Challenge: TwoDiceRoll Class

Once you've mastered `DiceRoll`, try creating a `TwoDiceRoll` class:

```java
class TwoDiceRoll {
    private final DiceRoll one;
    private final DiceRoll two;
    
    TwoDiceRoll(DiceRoll one, DiceRoll two) {
        this.one = one;
        this.two = two;
    }
    
    // TODO: Implement equals(), hashCode(), toString()
}
```

**💡 Hints**:
- For `equals()`, compare both `one` and `two` fields
- For `hashCode()`, use `Objects.hash(one, two)`
- For `toString()`, show both dice values

---

## ✅ Checklist

Before moving to Week 2, make sure you can:
- [ ] Create a class with proper encapsulation (private fields)
- [ ] Implement `equals()` correctly with null checks and type checks
- [ ] Implement `hashCode()` that matches `equals()`
- [ ] Implement `toString()` for readable output
- [ ] Understand the difference between `==` and `equals()`
- [ ] Test your implementation thoroughly

---

## 📚 Resources

- **Lab Material**: `Labs/Week01Lab02.md`
- **Google Java Style Guide**: Focus on class structure and naming
- **Java Documentation**: `Object.equals()`, `Object.hashCode()`

---

## 💬 Questions to Ask Yourself

1. Why should fields be `private`?
2. Why should the value field be `final`?
3. What happens if you don't override `equals()`?
4. What happens if `equals()` and `hashCode()` don't match?
5. When would you use `==` vs `equals()`?

---

## 🎯 Next Steps

Once you've completed Week 1:
1. Test your code thoroughly
2. Make sure it compiles and runs
3. Update `LEARNING_PROGRESS.md` to mark Week 1 as complete
4. Move on to Week 2: Interfaces & Abstract Classes

---

**Remember**: The goal is to understand WHY, not just HOW. Take your time, experiment, and ask questions!

