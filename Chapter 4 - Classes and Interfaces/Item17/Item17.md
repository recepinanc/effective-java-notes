# Item 17: Minimize Mutability
*Keywords: -* 

- Immutable class: Class whose instances cannot be modified. All of the information contained in the instances is fixed for the lifetime of that instance.

- Immutable classes are less prone to errors.

Make a class immutable following these *5 rules*:  
1. Don’t provide methods that modify the object’s state (a.k.a. mutators)
2. Ensure that the class cannot be extended. Prevent subclassing on this class.
3. Make all fields final. 
4. Make all fields private. - prevent clients to mutate object’s fields. It is sometimes OK to have public final fields but it precludes that changing the internal representation in a later release.
5. Ensure exclusive access to any mutable components.

In functional approach, methods do not modify the state of the instance that its being called on, rather it creates a new instance of the same type and assigns the calculated results and returns it.  
In imperative or procedural approach, we mutate the object by changing its state when we set the calculated values.

* Immutable objects are inherently thread-safe, they require no synchronization.
* Since a copy of an immutable object would never be the equivalent of the original, you should not provide a clone() method for an immutable class.

Major disadvantage of immutable classes is that they require a separate object for each distinct value and creating that object can be costly.  A solution to this problem is to use a mutable companion (like StringBuilder for the immutable String class).

To make a class Immutable we need to permit it from being subclassed. Making a class final would solve this, but a nicer approach is to make all of its constructors private and adding a public static factory method.

When implementing Serializable on an immutable class, you must provide an explicit readObject() or readResolve() method, or use the ObjectOutputStream.writeUnshared and ObjectOutputStream.readUnshared methods, otherwise an attacker could create a mutable instance of your class.

**TL;DR:**

* Immutable classes has many advantages and thread-safety is one of them.
* Classes should be immutable unless there’s a very good reason to make them mutable.
* Always make small value objects immutable.
* If performance is an issue you should provide a mutable companion for your immutable class.
* If a class cannot be made immutable, limit its mutability as much as possible.
* Declare every field private final unless there’s a good reason to do otherwise.
* Constructors should create fully initialized objects with all of their invariants established.
