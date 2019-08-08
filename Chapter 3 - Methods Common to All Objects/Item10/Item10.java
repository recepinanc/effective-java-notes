package com.recepinanc.effectivejava.chapter2;

public class Item10
{
    public static void main(String[] args)
    {
        Person recep = new Person(22, "Recep", "44411122234");
        Person emre = new Person(22, "Emre", "55511122235");

        Person recepFromPast = new Person(15, "Recep", "44411122234");
        Person recepFromFuture = new Person(25, "Recep", "44411122234");

        // Reflexive
        System.out.println(recep.equals(recep)); // => true

        // Symmetric
        System.out.println(recep.equals(emre)); // => false
        System.out.println(emre.equals(recep)); // => false

        // Transitive
        System.out.println(recepFromPast.equals(recep)); // => true
        System.out.println(recep.equals(recepFromFuture)); // => true
        System.out.println(recepFromPast.equals(recepFromFuture)); // => true
        
        // Consistent
        for (int i = 0; i< 10; i++)
        {
            System.out.println(recep.equals(emre)); // => false
        }

        // Non-nullity
        System.out.println(recep.equals(null)); // => false
    }
}


class Person
{
    int age;
    String name;
    String id;
    
    public Person(int age, String name, String id)
    {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    
    // Sample equals method that obeys the general contract of equals methods
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) // to ensure x.equals(x) is always true
            return true;
        if (!(obj instanceof Person))
            return false;
        Person that = (Person) obj;

        return that.id == this.id;
    }
}
