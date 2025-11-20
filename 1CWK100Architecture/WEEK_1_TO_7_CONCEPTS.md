# Complete Guide: Concepts & Patterns (Weeks 1-7)

## 📚 Week 1: Foundation & Setup

### Core Concepts
1. **Git & Version Control**
   - Git basics and repository management
   - GitHub account setup
   - Git GUI tools (GitHub Desktop)

2. **IntelliJ IDEA**
   - IDE installation and setup
   - Project creation
   - Code generation features
   - Refactoring tools

3. **Google Java Style Guide**
   - Source file structure
   - Naming conventions
   - Programming practices
   - Code formatting standards

4. **Markdown Documentation**
   - Markdown syntax
   - Writing documentation
   - README files

### Java Fundamentals
- **Class Structure**
  - Fields (instance variables)
  - Constructors
  - Methods
  - Static vs instance members
  - Access modifiers (public, private, protected, package-private)

- **equals(), hashCode(), toString()**
  - Content equality vs referential equality
  - Implementing equals() correctly (reflexive, symmetric, transitive, consistent)
  - Implementing hashCode() (must match equals())
  - Using `Objects.hash()` for multiple fields
  - Overriding toString() for readable output

- **Primitive vs Reference Types**
  - `==` operator behavior
  - Object equality

---

## 📚 Week 2: Interfaces & Abstract Classes

### Core Concepts

1. **Interface Implementation**
   - Defining interfaces
   - Implementing interfaces
   - Multiple interface implementation
   - Interface inheritance
   - Polymorphism through interfaces

2. **Abstract Classes**
   - Abstract methods
   - Abstract vs concrete classes
   - Extending abstract classes
   - Template method pattern basics

3. **Packages & Access Control**
   - Package declaration
   - Access modifiers:
     - `public` - accessible everywhere
     - `protected` - accessible to subclasses
     - `package-private` (default) - accessible within package
     - `private` - accessible only within class
   - Encapsulation and information hiding

4. **Typed References**
   - Reference type determines available operations
   - Subtype relationships
   - Polymorphism
   - Liskov Substitution Principle

5. **Generic Interfaces**
   - `Comparable<T>` interface
   - `Comparator<T>` interface
   - Difference between Comparable and Comparator

6. **Command vs Query Operations**
   - **Commands**: Operations that change state (void methods)
   - **Queries**: Operations that return values without side effects
   - Read-only operations
   - Side effects

### Design Patterns Introduced
- **Interface-based Polymorphism**
  - Multiple implementations of same interface
  - Runtime behavior variation

---

## 📚 Week 3: Value Objects & Strategy Pattern

### Core Concepts

1. **Value Objects**
   - Immutability (all fields final)
   - Content equality (equals/hashCode)
   - Encapsulation of primitive types
   - Validation in constructor
   - Static final instances for common values (singletons)
   - Thread-safety through immutability
   - Value Object checklist:
     - ✅ Immutable
     - ✅ Encapsulates primitives or other Value Objects
     - ✅ Implements equals() and hashCode()
     - ✅ Overrides toString()
     - ✅ Static constants for common values

2. **Strategy Pattern**
   - Encapsulating algorithms
   - Strategy interface
   - Multiple concrete strategies
   - Runtime algorithm selection
   - Eliminating conditional logic

3. **Polymorphic Behavior**
   - Polymorphic selling prices
   - Strategy-based calculations

### Design Patterns Introduced
- **Value Object Pattern**
  - Examples: `Score`, `Roll`, `PlayerName`, `ShippingCost`, `Money`, `Currency`
  
- **Strategy Pattern**
  - Examples: Shipping cost strategies, discount strategies

### Advanced Topics
- **Bridge Pattern** (Advanced)
  - Separating abstraction from implementation
  - Product and ProductPrinter example

---

## 📚 Week 4: Factory Patterns & Singletons

### Core Concepts

1. **Singleton Pattern**
   - Single instance of a class
   - Static final fields for constants
   - Immutable singletons
   - Currency examples (GBP, USD, EUR)

2. **Factory Pattern (Abstract Factory)**
   - Factory interface
   - Concrete factories
   - Centralized object creation
   - Runtime type selection
   - Examples: `MoneyFactory`, `DiceShakerFactory`

3. **Factory Method Pattern**
   - Abstract creator class
   - Protected abstract factory method
   - Concrete creators
   - Template method in creation process
   - Difference from Abstract Factory

### Design Patterns Introduced
- **Singleton Pattern**
  - Static final instances
  - Immutable value objects as singletons

- **Abstract Factory Pattern**
  - `MoneyFactory` interface
  - `GbpMoneyFactory`, `EurMoneyFactory`, `UsdMoneyFactory`

- **Factory Method Pattern**
  - Abstract `MoneyCreator` class
  - Concrete creators for each currency

### Key Differences
- **Abstract Factory vs Factory Method**
  - Abstract Factory: Interface-based, multiple product families
  - Factory Method: Class-based, single product family with variations

---

## 📚 Week 5: Decorator & Observer Patterns

### Core Concepts

1. **Decorator Pattern**
   - Wrapping objects with additional behavior
   - Same interface as component
   - Composition over inheritance
   - Dynamic behavior addition
   - Open/Closed Principle
   - Single Responsibility Principle
   - Examples: Dice shaker decorators, logging decorators

2. **Observer Pattern**
   - Subject-Observer relationship
   - Event notification
   - Decoupling event source from handlers
   - Multiple observers
   - Runtime observer attachment/detachment
   - Examples: Game event listeners, GUI event handlers

3. **Command Pattern** (Advanced)
   - Command interface (execute/undo)
   - Encapsulating operations as objects
   - Undo/redo functionality
   - Command history

### Design Patterns Introduced
- **Decorator Pattern**
  - Component interface
  - Concrete component
  - Decorator class
  - Multiple decorators can be chained

- **Observer Pattern**
  - Observable/Subject class
  - Observer interface
  - Concrete observers
  - Event objects/payloads

- **Command Pattern** (Advanced)
  - Command interface
  - Concrete commands
  - Invoker
  - Receiver

---

## 📚 Week 6: Facade & Mediator Patterns

### Core Concepts

1. **Facade Pattern**
   - Simplified interface to complex subsystem
   - Hiding complexity
   - Single entry point
   - **Stateless Facade**: No instance variables, service-like
   - **Stateful Facade**: Holds state, method call order matters
   - Examples: Game facade, API facades

2. **Mediator Pattern**
   - Centralized communication
   - Colleague classes
   - Mediator interface
   - Routing messages between colleagues
   - Reducing coupling between classes
   - Examples: Pricing mediator, UI component mediator

3. **Marker Interfaces**
   - Interface with no methods
   - Type marking/capability indication

### Design Patterns Introduced
- **Facade Pattern**
  - Facade class
  - Subsystem classes
  - Simplified client interface

- **Mediator Pattern**
  - Mediator interface
  - Colleague interface (often marker)
  - Concrete mediator
  - Concrete colleagues

### Key Differences
- **Facade vs Mediator**
  - Facade: Client talks to facade, facade talks to subsystem
  - Mediator: Client talks directly to colleagues, mediator coordinates between them

---

## 📚 Week 7: State Pattern

### Core Concepts

1. **State Pattern**
   - State machine implementation
   - Context class
   - State interface
   - Concrete state classes
   - State transitions
   - Eliminating complex conditionals
   - Each state handles its own behavior

2. **State Machines**
   - States
   - Transitions
   - Triggering events
   - Guard conditions
   - Actions on transitions
   - State transition tables
   - UML state diagrams

3. **Nested Classes** (Advanced)
   - Private nested classes
   - Encapsulating state machine
   - Access to enclosing class members

### Design Patterns Introduced
- **State Pattern**
  - Context interface/class
  - State interface
  - Concrete state classes
  - State transitions
  - Examples: Game states, authentication states, order processing states

### State Machine Concepts
- **States**: NotStarted, Playing, Finished, etc.
- **Transitions**: Triggered by events (start, roll, finish, tick)
- **Guard Conditions**: Boolean conditions that must be true for transition
- **Actions**: Side effects when transition occurs
- **Entry/Exit Actions**: Actions on entering/leaving states (advanced)

---

## 🎯 Summary: All Patterns Covered

| Week | Pattern | Purpose |
|------|---------|---------|
| 2 | Interface Implementation | Polymorphism, multiple implementations |
| 3 | Value Object | Immutable, validated data objects |
| 3 | Strategy | Encapsulate algorithms, runtime selection |
| 4 | Singleton | Single instance, constants |
| 4 | Abstract Factory | Create families of related objects |
| 4 | Factory Method | Subclass-based object creation |
| 5 | Decorator | Add behavior dynamically |
| 5 | Observer | Event notification, decoupling |
| 5 | Command | Encapsulate operations, undo/redo |
| 6 | Facade | Simplify complex subsystem |
| 6 | Mediator | Centralize communication |
| 7 | State | State machine, eliminate conditionals |

---

## 🔑 Key Principles Throughout

1. **SOLID Principles**
   - **S**ingle Responsibility Principle
   - **O**pen/Closed Principle
   - **L**iskov Substitution Principle
   - **I**nterface Segregation Principle
   - **D**ependency Inversion Principle

2. **Design Principles**
   - Encapsulation
   - Information Hiding
   - Composition over Inheritance
   - Program to interfaces, not implementations
   - Favor immutability

3. **Code Quality**
   - Google Java Style Guide
   - Proper equals()/hashCode() implementation
   - Meaningful toString() methods
   - Access control (minimal visibility)
   - Command vs Query separation

---

## 📖 Additional Concepts

### Java Language Features
- Generics (`Comparable<T>`, `Comparator<T>`)
- Enums
- Static members
- Final fields and immutability
- Method overriding
- Abstract methods
- Package structure
- Access modifiers

### Software Engineering Practices
- Clean Architecture
- Dependency Injection (Spring Boot)
- Use Cases
- Domain Models
- Infrastructure layer separation
- Testing considerations

### UML & Modeling
- Class diagrams
- State diagrams
- Sequence diagrams (implicit)
- State transition tables

---

## 🎓 Learning Progression

**Week 1**: Foundation → Java basics, tooling, style  
**Week 2**: Polymorphism → Interfaces, abstract classes  
**Week 3**: Data Design → Value objects, strategies  
**Week 4**: Creation → Factories, singletons  
**Week 5**: Extension → Decorators, observers  
**Week 6**: Coordination → Facades, mediators  
**Week 7**: Behavior → State machines, state pattern  

Each week builds on previous concepts, creating a comprehensive toolkit for object-oriented design!


