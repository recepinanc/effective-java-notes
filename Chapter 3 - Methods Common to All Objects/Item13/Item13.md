# Item 13: Override clone judiciously

*Keywords: Reflection, "Native" keyword, Copy Constructor*

Cloneable interface indicates that the class is cloneable, and it is legal to make a field-by-field copy of the object by overriding the protected clone() method, java.lang.Object#clone() with a public clone() method. An CloneNotSupportedException is thrown when .clone() is called on an object whose class does not implement Cloneable interface.  Normally, interfaces are used to say something about what a class can do, but in this case it modifies the behavior of a protected method on a superclass.  

The general contract for clone method is weak;  

* x.clone() != x must be true
* x.clone().getClass() == x.getClass() must be true
* x.clone().equals(x) expected to be true depending on the definition of your equals method - but not an absolute requirement.  

Never provide a clone method for immutable classes, to prevent wasteful copying.  

For PhoneNumber example, assume we made the class implement Cloneable interface, in the clone method of PhoneNumber class we’d call super.clone() and this will result in returning an object with the class of “Object” having the same fields and values as our original PhoneNumber, than we’d have to cast it to PhoneNumber class, and this casting is guaranteed to succeed.  

If an object contains fields that refer to mutable objects, the simple clone implementation can be disastrous. Suppose we have a Stack class that implements clone method, with the field "Object[] elements;” cloning the Stack will result in a new Stack object that has all same fields and values but the new object’s “elements” will be pointing to the original elements in original Stack instance that we call .clone() on. To fix that we need to implement .clone() in a way that it calls clone on the mutable fields of the instance.

Sometimes it is required to do a deepCopy for a field, such as when there’s an array of linkedLists in a field called Entry[] buckets, even though you call .clone on buckets, as it is suggested earlier, the linkedLists inside the new buckets field will still point to the original linkedList references.

**TL;DR:**

* All classes that implement Cloneable interface should override clone() method with a public one whose return type is the class itself
* Clone method first calls super.clone() then fix any fields that needs to be fixed
* If the class only has primitive fields or references to immutable objects, no fixing is needed. - Exception: if there’s an ID that needs to be unique for every object, after cloning the original, the ID field needs to be fixed/changed.
* As an alternative to this complex copying method (clone) we could provide a copy constructor - a constructor that takes a single parameter whose type is the class that contains the constructor. As a rule, copy functionality is best provided by constructors or factories. A notable exception to his rule is arrays, which are best copied with the clone method.
