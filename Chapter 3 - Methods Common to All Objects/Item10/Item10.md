# Item 10: Obey the general contract when overriding equals
**Keywords: -**

It is appropriate to override equals when a class has a notion of logical equality that differs from mere object identity and a superclass has not already overridden equals. This is generally the case for value classes. A value class is simply a class that represents a value, such as Integer or String. 

An equals method must adhere to its general contract:
* Reflexive: x.equals(x)
* Symmetric: x.equals(y) = y.equals(x)
* Transitive: x.equals(y) & y.equals(z) => x.equals(z)
* Consistent: x.equals(y) gives exactly the same result for N number of executions.
* Non-nullity: x.equals(null) is always false.

Do not write an equals method that depends on unreliable resources, for example resource that may change their values in time.
