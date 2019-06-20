# Item 3: Enforce the Singleton Property with a Private Constructor or an Enum Type
*Keywords: Singleton, Private Constructor, Transient, Supplier, Serialization, Single-Element Enum*

A singleton is a class that is instantiated exactly once. Represents stateless objects, such as functions or a unique system component.

One approach when creating a singleton class is to use final member field with a private constructor. This ensures that constructor is called exactly once and no more modifications can be made to that instance. To protect against privileged access to constructors you can throw an exception when the constructor asked to create a second instance.

```java
public static final Elvis INSTANCE = new Elvis();
private Elvis() {…} 
```

Another approach is to have a public static factory method “getInstance" which returns the same final member field with a private constructor. 

**Pros of First approach:**  
1- API makes it clear that the class is a singleton: public static final field is final, so it will always serve the same instance.  
2- It’s simpler.  

**Cons of First approach:**  
1- For safe serialization operations you need to declare all instance fields “transient” and provide a readResolve method. Otherwise, each time a serialized instance is deserialized a new instance will be created.  

**Pros of Second approach:**  

1- Flexibility to change implementation of the static factory method (getInstance) to make the class singleton or not without changing the API. You may change the getInstance method to return new instance for every new thread, or keep it as a singleton and this won’t cause any change in the API.  
2- You can write generic singleton factory if needed.  
3- A method reference can be used as a supplier. Elvis::instance is a Supplier<Elvis>  

Unless any of the 3 advantaged of second approach is needed, often the first approach is the way to go.

A third way to create a singleton is to use a single-element enum.

**Pros of Single-Element Enum approach:**  
1- More concise.  
2- Handles serialization for free.  
3- Provides strong guarantee against multiple instantiation.  

**Cons of Single-Element Enum approach:**
1- You cannot use this approach if your singleton must extend a superclass other than Enum.  
