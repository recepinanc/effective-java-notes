# Item 23: Prefer class hierarchies to tagged classes
*Keywords: -*

A class whose instances come in two or more flavors based on a (tag) field is a vastly inferior implementation against class hierarchy.

A `Figure` class, for example, may have a field `shape` in it that can get one of the two enum values `RECTANGLE, CIRCLE`.

Shortcomings of tagged classes;  
* Cluttered with enum/tag fields, switch cases.
* Readability is down, since multiple implementations are in the same class.
* Memory footprint is increased because instances are burdened with irrelevant fields belonging to other flavors.
* Constructors must set the tag field and initialize the right data fields without the help of the compiler.
* Fields can not be made `final` unless constructors initialize irrelevant fields - which is even more boilerplate.
* Adding a new flavor will result in adding a new `case` to every `switch` statement.

So, yes, tagged classes are verbose, error-prone and inefficient.  

“A tagged class is just a pallid imitation of a class hierarchy.”  

To transform a tagged class into a class hierarchy we could make the `Figure` an abstract class with all the mutual methods for both flavors are declared inside as `abstract` and then create a concrete class for each of these flavors `Rectangle` and `Circle` which extends `Figure`. Inside these concrete classes we could then declare and use only the required fields and implement the abstract methods that Figure requires.  

Advantages of class hierarchies:  
* Code is simpler, no boilerplate.
* No irrelevant data field in concrete classes, only the necessary ones are added in each class.
* All fields are final.
* Compiler ensured that all required methods (abstract methods) are implemented for each flavor.
* There’s a separate data type for every flavor that contains some basic data with it (Rectangle, Circle, Square...)

**TL;DR**

If you are tempted to write a class with an explicit tag field, think about whether the tag  could be eliminated and the class replaced by a hierarchy. And when you encounter such class, consider refactoring it.
