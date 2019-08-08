package com.recepinanc.effectivejava;

public class ImmutableClass
{
    public static void main(String[] args) {
        ImmutableKlass immutable = new ImmutableKlass("Recep", 22);
        immutable.getName();
        immutable.getAge();
        
        // Calls listed below are not possible, we cannot mutate this class.
        // immutable.setName("Inanc");
        // immutable.setAge(23);
        // immutable.name = "Inanc";
        // immutable.age = 23;
    }
}

final class ImmutableKlass // final - so that child class
{
    // fields declared as final so that they cannot be changed once they are initialized
    private final String name;
    private final int age;

    public ImmutableKlass(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }
    
    // No setters so that fields cannot be changed
}
