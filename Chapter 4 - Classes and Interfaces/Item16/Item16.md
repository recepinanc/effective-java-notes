# Item 16: In Public classes, use accessor methods, not public fields
*Keywords: Degenerate class*

Using accessor methods on a class that is accessible outside of its package helps preserving flexibility to change the class’s internal representation. 
If a class is package-private or is a private nested class, there is nothing inherently wrong with exposing its data fields. 

**TL;DR:**  
Use getter/setters.
