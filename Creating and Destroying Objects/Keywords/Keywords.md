# Keywords

*Flyweight Pattern* - This pattern suggests that you stop storing the unique state inside the object. Instead, you should pass this state to specific methods which rely on it. Only the identical state stays within the object, letting you reuse it in different contexts. As a result, you’d need fewer of these objects since they only differ in the intrinsic state, which has much fewer variations than the extrinsic. Sample code at [FlyweightPattern.java](https://github.com/recepinanc/effective-java-notes/blob/master/Creating%20and%20Destroying%20Objects/Keywords/FlyweightPattern.java)  
  
*Immutable class* - Once an object is created, we cannot change its content. In Java, all the wrapper classes (like String, Boolean, Byte, Short) and String class is immutable. The easiest way to create an immutable class in **Java** is by declaring all the fields private and final and not providing setters.

*Thread safety* - Thread safety implies multiple threads can write/read data in same object without memory inconsistency errors. This means that different threads can access the same resources without exposing erroneous behavior or producing unpredictable results.

*Transient* - By definition it means “lasting for a short time”. When an object is transferred through the network, the object needs to be 'serialized'. Serialization converts the object state to serial bytes. Those bytes are sent over the network and the object is recreated from those bytes. Member variables marked by the java transient keyword are not transferred, they are lost intentionally. In Java, transient keyword is used for the variables which we do not want to be serialized. Those variables will have their default value as the result. It is good habit to use transient keyword with private confidential fields of a class during serialization.

*Single-Element Enum* - It is told in Effective Java this is the preferred way of creating a singleton class.  

*Dependency Injection* - https://medium.com/@atarikguney/dependency-injection-nedir-1124c15249ad Last principle in SOLI(D). The goal is to inject the classes you depend in your class so that it works properly without you needing it to manage.  

*Static Utility Class* -  These are Helper classes that contains only static methods, it is stateless and it cannot be instantiated. Goal is to increase reusability, but as a down side it increases coupling between classes, creating external dependency and make it harder to test. Utility classes should be avoided as much as possible because of this down sides http://ralin.io/blog/oop-anti-patterns-utility-or-helper-classes.html.  

*Dagger, Guice, Spring* - These are dependency injection frameworks.

*Lazy Loading* - It is an optimization technique that works by loading only the content that is needed by the user. It reduces time and memory consumption.  

*Autoboxing* - Converting a primitive value into an object of the corresponding wrapper class. boolean -> Boolean, int -> Integer, long -> Long …  

*Memory Leak* - A memory heap is a portion memory that is dynamically allocated memory resides. A memory heap is a location in memory where memory may be allocated at random access.
Unlike the stack where memory is allocated and released in a very defined order, individual data elements allocated on the heap are typically released in ways which is asynchronous from one another. Memory leak occurs when programmers create a memory in heap and forget to delete it. Memory leaks are particularly serious issues for programs like daemons and servers which by definition never terminate.
