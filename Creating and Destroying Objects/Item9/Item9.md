# Item 9: Prefer try-with-resources to try-finally  
**Keywords: -**

In java we often use try-finally for cases where we need to manually close a resource (i.e. InputStream, OutputStream etc.). The main problem with this approach is that if you get an error while in the try section of your open InputStream, and you get an error rather than opening the stream, like you get an error because you tried to run .readLines(), and because of the same reason the code in your finally section, .close(), fails and throws an Exception, you will not be able to view the first exception giving you a hard time when debugging is required. 

When Java 7 introduced try(withResources) that solves this problem. Your resource need to implement AutoClosable interface, and then the latter exceptions are suppressed and the first one is thrown. It also allows you to still access to all of the suppressed exceptions, even programmatically using getSuppressed().

**TL;DR**

Always use try-with-resources statement instead of try-finally when working with resources that needs to be closed, for a cleaner, shorter, better code and better exception management.
