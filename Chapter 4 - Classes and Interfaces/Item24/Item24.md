# Item 24: Favor static member classes over non-static
*Keywords: -*

A static member class is the simplest kind of nested classes. It’s simply a class declared inside another class and has access to all of the enclosing class’s members, even the private ones.  

One common use of a static member class is a public helper class. For example, an enum describing possible operations supported by a calculator. The `Operation` enum declared inside `Calculator` class a public static member class.   
