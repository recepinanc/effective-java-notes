# Item 5: Prefer Dependency Injection to Hardwiring Resources
----
*Keywords: Dependency Injection, Static Utility Class, Dagger, Guice, Spring*  

A SpellChecker class depends on an Dictionary class. So we can say, "SpellChecker depends on a Dictionary”. To provide this Dictionary dependency to our SpellChecker class, defining a static final Dictionary field in our SpellChecker, and creating it inside the class will cause some problems. assuming each language has its own dictionary and special dictionaries are used for special vocabularies, using a single dictionary (as in: `static final Dictionary dict = …;`) would not work.

One form of Dependency Injection is to pass the resource into constructor when creating a new instance. Having a final field for the resources that are passed to constructor in order to inject them into our class preserves immutability. Dependency Injection is also applicable to static factories and builders.

**Pros:**   
1- Improves flexibility of the class  
2- Improves testability: It is easier to mock classes that are being injected.  
3- Improves reusability   

**Cons:**  
1- It can clutter up large projects which typically contain thousands of dependencies. - Solution: This clutter can be handled using one of the frameworks for dependency injection: such as Dagger, Guice or Spring.  

**TL;DR**
* Do not use a singleton or static utility class to implement a class that depends on one or more underlying resources, and do not have the class to create these resources directly. Instead pass the resources into to constructor (or static factory or builder) as a parameter.
