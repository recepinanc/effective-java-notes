# Item 7: Eliminate Obsolete Object References   
*Keywords: Memory leak*

When garbage-collector does the removal of unused variables for you and help you manage the memory usage with that, it is easier to look over some things that may cause memory leaks. 

An example to this is, when a stack grows and then shrinks , the objects that were popped off the stack will not be garbage collected, even if the program has no more references to them. This is because the stack implementation maintains obsolete references to these objects. 

If an object reference is unintentionally retained, any objects referenced by that object are also retained too. Even if only a few object references are unintentionally retained, many other objects may be prevented from being garbage-collected, and this may cause potentially large effects on performance.

For the stack example, the solution is to null out references once they become obsolete, this way garbage-collector will remove that object reference. But keep in mind that "Nulling Out Object References” should be an exception, it should not be the normal behavior. Instead the best way to eliminate an obsolete reference is to let the variable that contained the reference fall out of scope by defining each variable in its narrowest possible scope.

After putting an object reference into a cache and then forgetting it there and leave it in cache long after it becomes irrelevant. WeakHashMap can be used as a solution to that.

**TL;DR**

1. Whenever a class manages its own memory the programmer should be alert for memory leaks.
2. Define variables in their narrowest scope.
3. Caches are a common source of memory leaks.
4. Listeners and other callbacks may also be a source for memory leaks.
5. Heap profiler can be used to identify memory leaks. https://blog.jetbrains.com/idea/2016/08/jvm-debugger-memory-view-for-intellij-idea/
