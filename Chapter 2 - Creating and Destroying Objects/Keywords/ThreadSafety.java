package com.recepinanc.effectivejava;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafety
{
    
    public static void main(String[] args)
    {

    }

}

// Main problem with the below code is that count is a field
// in the NonThreadSafe class.
// This is the "state" of the class, each time countTo10() is
// called the state changes.
// Calling countTo10() in a single thread would work OK but
// using more threads may cause issues since before (count == 10) could be checked
// other threads could run the "count = count + 1" part and cause count to be 11
// which then fails the check count == 10 and keeps incrementing the count.

class NonThreadSafe {
    private int count = 0;

    public boolean countTo10() {
        count = count + 1;
        return (count == 10);
    }
}

// One way to achieve thread safety is to
// have a stateless implementation; such as a function
// A stateless implementation is the one that 
// always give the same output for the same input

class ThreadSafe1 {
    
    // For same input values this method
    // guaranteed to give the same output
    public boolean countTo10(int count) {
        count = count + 1;
        return (count == 10);
    }
}

// Another way to achieve thread safety is to
// Making classes immutable.
// If we need to share state between different threads, 
// we can create thread-safe classes by making them immutable.
// After our object is constructed from an immutable class,
// no other thread can change/mutate it, making it thread-safe.
// BUT, we do not want to have this in a case where we use the same Bean
// to create different instances, on multiple threads since it would cause 
// bigger problems such as cannot using the instances we intended to but 
// instead keep using the one we created previously.


// Read/Write Locks are another way, we lock the object when writing and reading
// and unlock it when the operation is done so that both cannot happen at the same time. 

class ThreadSafe2 {

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();
    
    private int count = 0;

    public void incrementCount() {
        writeLock.lock();
        try {
            count += 1;
        } finally {
            writeLock.unlock();
        }
    }
    
    public boolean checkCount() {
        readLock.lock();
        try {
            return (count == 10);
        } finally {
            readLock.unlock();
        }
    }
}

// We can make use of "synchronized" methods and statements.
// Only one thread can access a synchronized method at a time 
// while blocking access to this method from other threads.
// P.S. Synchronized Collections can be used for thread-safe Collections

// synchronized method
class ThreadSafe3 {
    private int count = 0;

    public synchronized boolean countTo10() {
        count = count + 1;
        return (count == 10);
    }
}

// synchronized statement
// Synchronization is expensive, so with this option, we are able to only synchronize the relevant parts of a method.
class ThreadSafe4 {
    private int count = 0;

    public boolean countTo10() {
        synchronized(this) {
            count = count + 1;
        }
        return (count == 10);
    }
}

// Thread-Local Fields
// If we actually need to maintain state, we can create thread-safe
// classes that don’t share state between threads by making their 
// fields thread-local.

