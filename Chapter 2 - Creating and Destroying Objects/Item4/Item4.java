package com.recepinanc.effectivejava.chapter2;

public class Item4
{
    // Below line cannot be compiled since the constructor is private.
    // UtilityClass utilityClass = new UtilityClass();
}

class UtilityClass
{
    // Constructor with a Private access modifier is used to disable instantiation
    private UtilityClass()
    {
        throw new AssertionError();
    }
}
