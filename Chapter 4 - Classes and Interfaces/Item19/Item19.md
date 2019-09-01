# Item 19: Design and Document for inheritance or else prohibit it
*Keywords: Serializable interface*

The class must document its self-use of overridable methods. For each non-final public or protected method, the documentation must indicate which overridable methods the method invokes, in what sequence and how the results of each invocation affect subsequent processing. A class must document any circumstances under which it might invoke an overridable method. 

Writing what a method does and how does it do it in a comment violates the dictum that a good API doc. should describe *“what a given method does”* and not *“how it does”* it. This is an unfortunate consequence of the fact that inheritance violates encapsulation.  However, to document a class so that it can safely be subclassed, you must describe implementation details that should otherwise be left unspecified.

The only way to test a class designed for inheritance is to write subclasses. Three subclasses are usually sufficient to test an extendable class, one or more of these subclasses should be written by someone other than the superclass author. You must test your class by writing subclasses before you release it.

Constructors must not invoke overridable methods, directly or indirectly. The superclass’ constructor runs before the subclass’ constructor, so the overriding method in the subclass will get invoked before the subclass constructor has run and if the overriding method depends on any initialization performed by the subclass constructor, the method will not behave as expected. 

If `Cloneable` and `Serializable` is implemented in a class that is designed for inheritance you should be aware that similar reaction applies for clone and readObject methods since they both behave like constructor.

You need to prohibit concrete classes that are not planned to be extended from being extended by declare classes final or make all the constructors private and add public static factories in place of constructors.

**TL;DR**

* If designing a class for inheritance, document all of its self-use patterns (invoking of all public/protected non-final overridable methods).
* The documentation must indicate which overridable methods the method invokes, in what sequence and how the results of each invocation affect subsequent processing.
* Constructors, `clone()`, `readObject()` methods must not invoke overridable methods directly or indirectly to prevent failures.
* You should try to write **at least 3** subclasses to test your superclass for inheritance - one or more of them should be written by anyone but you.
* Unless you know there is a real need for subclasses, prohibit inheritance by declaring yor class final or ensure there are no accessible constructors.
