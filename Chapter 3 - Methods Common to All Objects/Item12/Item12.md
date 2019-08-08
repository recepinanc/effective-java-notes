# Item 12: Always override toString
*Keywords: -*

In the toString contract it says “It is recommended that all subclasses override this method.”

**Why?**
* Overriding toString and providing a more informative result makes it easier for systems to debug and much more pleasant.

As an example writing a debug log would get better if we override the PhoneNumber class’ toString method to return {Recep=123-422-656} instead of letting it return its original PhoneNumber@75ad21

The returned string should be self-explanatory. It is better to give all the interesting information in that string if it is practical, otherwise returning a string that describes that object is also good (for example: "List of Recep’s phoneNumbers [455 records]” is a lot better than PhoneBook@185x1a).
