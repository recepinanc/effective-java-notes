# Item 20: Prefer Interfaces to Abstract Classes
*Keywords: Default methods in Interfaces, Template Method Pattern*

Abstract classes and interfaces are two mechanisms to define a type that permits multiple implementations.  

A major difference is that to implement the type defined by an abstract class, a class must be a subclass of the abstract class. However, a class can implement any interface it requires, no matter where it stands in the hierarchy.   

Interfaces are ideal for mixins. A mixin is a type that a class can implement in addition to its “primary type” to declare that it provides some optional behavior. For example, Comparable is a mixin interface that allows a class to declare that its instances are ordered.  

Interfaces allow for the construction of nonhierarchical type frameworks. Let’s say `Singer` and `Songwriter` interfaces adds (mixins) some functionality to `Person` class. But a `Person` can also be a Singer and a Songwriter right? Interfaces permits us to do this by adding `implements Singer, Songwriter`. If we used abstract classes we would not be able to achieve this kind of flexibility.  

Combine the advantages of interfaces and abstract classes by providing an `abstract skeletal implementation class` to go with an interface. The interface defines the type, provides some default methods, while the skeletal implementation class implements the remaining non-primitive interface methods atop the primitive interface methods. Extending a skeletal implementation takes most of the work out of implementing an interface. This is called the Template Method pattern.  

Skeletal Implementation classes are called `AbstractInterface` where interface is the name of the interface they implement: AbstractCollection (implements Collection interface).  

**TL;DR**

* An interface is generally the best way to define a type that permits multiple implementations.
* Interfaces, on the other hand, does not require a hierarchical organization that restricts the programmers that uses it.
* You can combine abstract classes and interfaces (with some default methods) by defining Skeletal Implementation classes.
* You should consider providing a good documentation with your Skeletal classes.
