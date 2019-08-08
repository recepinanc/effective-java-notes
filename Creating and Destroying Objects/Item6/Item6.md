# Item 6: Avoid Creating Unnecessary Objects
---
*Keywords: Lazy Loading, Autoboxing(Boxed Primitives and Long Creation)*

Reusing an object instead of creating a new one is both faster and more stylish. An object can always be reused if it is immutable. 
You can often avoid creating new instances by using a static factory method instead of using constructors. For example using Boolean.valueOf(String) is preferable to constructor Boolean(String) - which was deprecated in Java 9. The constructor must create a new object every time it's called, whereas static factory method is never required to do so and won’t in practice. 

When there’s a String matching operation, using String.matches is very expensive because under the hood it creates a Pattern object every time we call it. It takes the regular expression we pass and turns it into a finite state machine. We can avoid this by compiling the pattern in a static final field of type Pattern, and reuse the same compiled instance. It is measured to be 6.5x faster this way. The problem with this approach is even if we do not call the method that uses the final field we created it would still be created already. This can be handled by using lazy loading, but the burden we get into to implement lazy loading for this case does not worth the performance improvement we get.

Auto-boxing is another reason for creating unnecessary objects. Using a “Long" where you could use a “long” dramatically decreases the performance. Prefer primitives to boxed primitives, and watch out for unintentional auto-boxing.

Although it is important to avoid unnecessary object creation, it is not that expensive to create and manage objects thanks to modern JVM implementations. Creating a copy of an object when needed “defensive copying” is far more important than avoiding creating unnecessary objects, since the first may cause security issues and bugs whereas the second one merely effects performance and style.


**TL;DR**  

* Static Factory Methods such as Boolean.valueOf(String) can be used instead of new Boolean(String)
* When using methods beware the underlying processes and avoid expensive object creations as much as possible. Like in String.matches(), compile the pattern in a final field instead.
* Prefer primitives to boxed primitives, and watch out for unintentional auto-boxing.
* Do not put yourself into trouble of managing your object pool, JVMs already help you with that.
* Defensively Copy your objects when needed, don’t clutter up your codebase for a little bit of performance improvement.
