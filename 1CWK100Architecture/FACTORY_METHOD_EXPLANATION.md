# Factory Method Pattern - How It Works

## The Flow

```
Client Code:
  AbstractDiceShakerFactory factory = new SingleDiceShakerFactoryMethod();
  DiceShaker shaker = factory.create();  // ← Step 1: Client calls create()
  
Step 1: create() is called (in AbstractDiceShakerFactory)
  ↓
Step 2: Logging happens
  System.out.println("Creating DiceShaker...");
  ↓
Step 3: Counting happens
  totalCreated++;
  ↓
Step 4: factoryMethod() is called ← THIS IS WHERE IT HAPPENS!
  DiceShaker shaker = factoryMethod();  // Line 20
  ↓
Step 5: Java looks at the ACTUAL object type (SingleDiceShakerFactoryMethod)
  ↓
Step 6: Calls the OVERRIDDEN method in SingleDiceShakerFactoryMethod
  @Override
  protected DiceShaker factoryMethod() {
      return new RandomSingleDiceShaker();  // ← THIS RUNS!
  }
  ↓
Step 7: Returns the created object
  ↓
Step 8: More logging in create()
  System.out.println("DiceShaker created: RandomSingleDiceShaker");
  ↓
Step 9: Returns to client
```

## Why It's Abstract

The `factoryMethod()` is **abstract** because:
- The abstract class doesn't know WHAT to create
- Each subclass decides WHAT to create
- But the abstract class controls HOW it's created (logging, counting, etc.)

## Polymorphism in Action

When you call `factory.create()`:
- Java looks at the **actual object type** (not the variable type)
- If it's `SingleDiceShakerFactoryMethod`, it calls that class's `factoryMethod()`
- If it's `DoubleDiceShakerFactoryMethod`, it calls that class's `factoryMethod()`

This is **polymorphism** - same method call, different behavior!

