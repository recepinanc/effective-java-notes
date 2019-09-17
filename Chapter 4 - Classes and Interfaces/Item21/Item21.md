# Item 21: Design interfaces for Posterity
*Keywords: -*

Prior to Java 8, when you add a new method to an interface, you would break existing implementations since they do not have that method. In Java 8, the default method construct allowed us to do that with some risk.

Java 8’s default method includes a default implementation for all classes that uses it, risk here is that these methods are injected into existing implementation without their owners/authors knowing that.

Keep in mind that, it is not always possible to write a default method that maintains all variants of every conceivable implementation. (removeIf method fails for Apache’s SynchronizedCollection)

Using default methods to add new methods to existing interfaces should be avoided unless the need is critical.

Also keep in mind that, default methods are not designed to support removing methods from interfaces or changing the signature of existing methods. Neither of these changes are possible without breaking the existing clients.

Before Java 8 interfaces were designed in such a way that there was no expectance of adding a new method later on.

Before releasing a new interface, multiple programmers should implement it and you should try to implement it at least in 3 different ways.
