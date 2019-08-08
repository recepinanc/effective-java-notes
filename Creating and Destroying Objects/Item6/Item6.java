package com.recepinanc.effectivejava.chapter2;

public class Item6
{
    public static void main(String args[])
    {
        long startTime = System.nanoTime();
        slowSum();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);

        startTime = System.nanoTime();
        sum();
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration);
    }

    private static long slowSum()
    {
        // Creating the sum variable as a Long object - not a primitive long.
        Long sum = 0L;

        for (long i = 0; i <= 10; i++)
        {
            // New "Long" object is created when sum += i is executed.
            sum += i;
            // System.out.println(System.identityHashCode(sum));
        }

        return sum;
    }

    private static long sum()
    {
        // Creating the sum variable as a primitive long.
        long sum = 0;
        
        for (long i = 0; i <= 10; i++)
        {
            // Operation is done on the same object when sum += i is executed.
            sum += i;
            // System.out.println(System.identityHashCode(sum));
        }
        
        return sum;
    }
}
