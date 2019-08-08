# Item 2: Consider a Builder When Faced with Many Parameters
*Keywords: Builder Pattern, Immutable class, Thread safety*

Static factories and constructors do not scale well when there are many optional parameters. Usually "telescoping constructor” method is used to overcome this issue, where you have many constructors starting from the most basic one and call the one with the parameter set you need. But this is not so easy to write, read and maintain.

Another alternative to this problem is to use JavaBeans pattern, where you create a parameterless constructor and set all parameters using setters. The main disadvantage with this approach is creating the instance you want is done in multiple calls and a JavaBean may be in an inconsistent state partway through its construction. And this patterns precludes the possibility of making a class immutable and requires added effort on the part of the programmers to ensure thread safety.

Builder Pattern combines the safety of Telescoping Constructor and readability of JavaBeans Pattern.
A single Builder can be used to build multiple objects.

**Pros:**  

1- More Readable  
2- Safer  
3- Allow classes to be immutable  

**Cons:**  

1- Creating a builder before creating an object might be a problem for performance critical situations.  

It is best to use a Builder when a constructor needs more then 4-5 parameters, especially these parameters are optional or of identical type.
