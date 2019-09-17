# Item 22: Use Interfaces only to Define Types
*Keywords: -*

Interfaces should be defined to say something about the class that implements it, what the clients can do with its instances.
When a class implements an interface it serves as a type that can be used to refer to instances of that class.  

Constant interface pattern is a poor use of interfaces, where you declar `static final` constants to use across your code. Instead you could create a class, that is not instantiable and export your `static final`s from there.  

Note: In **Java 7**, underscore (_) is introduced for numeric literals, that has no effect on the number itself and allows to have a better readability (suggested if the literal has 5 or more digits).  
