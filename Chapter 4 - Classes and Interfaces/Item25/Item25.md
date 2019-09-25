# Item 25: Limit Source Files to a Single Top Level Class
*Keywords: -*  

Do not ever define to Top Level classes/interfaces in a single file;
- You could conflict with yourself, 
- You make it harder for your readers to understand/follow your code. 

If you define two classes in two different source files, which you compiled first will affect the behavior of your code.  
If you really need to do that consider using `Static Member Classes` and put them in the same class as we discussed in [Item 24](https://github.com/recepinanc/effective-java-notes/blob/master/Chapter%204%20-%20Classes%20and%20Interfaces/Item24/Item24.md).
