# Keywords

*Flyweight Pattern* - This pattern suggests that you stop storing the unique state inside the object. Instead, you should pass this state to specific methods which rely on it. Only the identical state stays within the object, letting you reuse it in different contexts. As a result, you’d need fewer of these objects since they only differ in the intrinsic state, which has much fewer variations than the extrinsic. Sample code at [FlyweightPattern.java](https://github.com/recepinanc/effective-java-notes/blob/master/Creating%20and%20Destroying%20Objects/Keywords/FlyweightPattern.java)  
  
*Immutable class* - Once an object is created, we cannot change its content. In Java, all the wrapper classes (like String, Boolean, Byte, Short) and String class is immutable.
