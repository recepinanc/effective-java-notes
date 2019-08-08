# Item 11: Always override hashCode when you override equals
*Keywords: Lazy Initialization*

You must override hashCode in every class that overrides equals, in order not to break hashCode contract. Otherwise it will prevent it from functioning properly in collections such as HashMap and HashSet.

* Consistent: hashCode gives exactly the same result for N number of executions.
* x.equals(y) => x.hashCode() = y.hashCode()
* It is not required to have distinct hashCode's for objects that are not “equal” but having distinct values will improve the performance of hash tables.

```java
Map<PhoneNumber, String> m = new HashMap<>();
m.put(new PhoneNumber(123,123,111), “Recep”);
m.get(new PhoneNumber(123,123,111)) // expected => “Recep”
```

But if PhoneNumber class is failed to obey the hashCode contract and implemented in a way that it is according to logical equivalence, these two different PhoneNumber objects (but logically equal) did not generated the same integer thus there’s no record in the HashMap.

Setting a constant integer for the hashCode? NO! Worst legal implementation possible… Because it kills all the benefits of using “hash..." data structures.

Recipe to implement a good hashCode function can be found in the sample code cases.
