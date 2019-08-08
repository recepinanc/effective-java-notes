package com.recepinanc.effectivejava.chapter2;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Item7
{
    public static void main(String[] args)
    {
        MyStack stack = new MyStack();
        stack.push(new Integer("1111"));
        stack.push(new Integer("2222"));
        stack.push(new Integer("3333"));

        stack.pop();
        System.out.println("Non-Obsolete stack processed.");
        
        MyStack stackObsolete = new MyStack();
        stackObsolete.push(new Integer("1111"));
        stackObsolete.push(new Integer("2222"));
        stackObsolete.push(new Integer("3333"));

        stackObsolete.popWithObsolete();
        System.out.println("Obsolete stack processed.");
    }
}

class MyStack
{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;

    public MyStack()
    {
        elements = new Object[DEFAULT_CAPACITY];
    }

    void push(Object e)
    {
        checkCapacity();
        elements[size++] = e;
    }

    Object pop()
    {
        if (size == 0)
        {
            throw new EmptyStackException();
        }
        
        // Below, popping out the latest element and reducing the size by 1 will cause
        // obsolete reference to be kept in memory
        // return elements[--size];

        // Here, however, we null out the reference so that it will be removed by the garbage-collector
        Object poppedObject = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return poppedObject;
        
    }

    Object popWithObsolete()
    {
        if (size == 0)
        {
            throw new EmptyStackException();
        }

        // Below, popping out the latest element and reducing the size by 1 will cause
        // obsolete reference to be kept in memory
        return elements[--size];

    }

    private void checkCapacity()
    {
        if (elements.length == size)
        {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
