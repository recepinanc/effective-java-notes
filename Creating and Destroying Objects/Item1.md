# Item 1: Consider Static Factory Methods Instead of Constructors
*Keywords: Constructors, Static Factory Methods, Flyweight Pattern*

**Pros:**  
1- Unlike constructors, they have names. This increases the readability of the code.  
2- They are not required to create a new instance each time they are invoked. This technique can greatly increase performance if object that are expensive to create are requested often. Similar to Flyweight pattern. This allows classes to maintain control over what instances exists at any time, making them called instance-controlled.  
3- Unlike constructors, they can return an object of any subtype of their return type.  

**Cons:**
1- Hard for programmers to find in the source code. Unlike constructors they do not stand out in the code. To solve this some naming conventions are listed below:
* from — Type-conversion method that takes a single type and creates instance of another type ‘Date d = Date.from(instant)’
* to — Aggregation method that takes multiple parameters and returns an instance of the type that incorporates them ’Set<Rank> cards = EnumSet.of(‘JACK’, ‘QUEEN')'
* valueOf — A more verbose alternative to from and of ‘BigInteger.valueOf(Integer.MAX_VALUE)'
* getInstance — Get a previously created instance of the object, or create a new one if none exist.
* newInstance — Guaranteed to return new instance at each call
