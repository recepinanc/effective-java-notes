# Item 15: Minimize the accessibility of classes and members
*Keywords: -*  

*Information hiding* (a.k.a encapsulation) is fundamental when it comes to designing components.
Encapsulation;  
* Increases reusability by decoupling components
* Increases testability
  
Rule of thumb: “Make each class or member as inaccessible as possible!”

Access modifier levels:  
* **private:** Accessible only from the top-level class where it is declared 
* **package-private (default level when you don’t declare any):** Accessible from any class in the package where it is declared.
* **protected:** Accessible from subclasses of the class where it is declared and from any class in the package where it is declared.
* **public:** Accessible from anywhere.  

Your default reflex should be to make all members private, if you find yourself setting package-private modifiers often, you should reconsider your design and try to see if another decomposition might yield classes that are better decoupled from one another.

Instance fields of public classes should rarely be public.

Since nonzero-length arrays are always mutable, it is wrong for a class to have public static final array field, or an accessor that returns such a field. If a class has such a field, they will be able to modify the contents of the array, and this is a frequent source of security holes. You can fix this by having a public static final List that is initialized with the private static final array using the Arrays.asList(array) method. Alternatively, a static method that returns an private static final array’s .clone() 

