# Item 4: Enforce Non-instantiability with a Private Constructor
------
*Keywords: -*  

Including a private constructor enables us to make a class non instantiable.  
We may want this to happen when we need to group a set of static fields and methods, like in `java.lang.Maths` or `java.util.Arrays`.

Attempting to achieve this by making the class abstract does not work, because the class can be subclassed and the subclass is instantiated. As a side effect using a single private constructor also prevents this class to be subclassed. Because the subclass would have no accessible superclass constructor to invoke.

**TL;DR**

* When you need a class to be Non-instantiability, make its constructor private.
