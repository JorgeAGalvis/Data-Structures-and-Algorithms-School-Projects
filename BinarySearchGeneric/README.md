### Binary Search

This problem is something we discussed in lecture 3 and is also the last programming assignment from the intro course.  I'm putting this here so that you can try writing it as practice. As indicated above, we're not grading this and you should not submit it.

In the file BinarySearchGeneric.java implement a static method with the signature:

```
public static <E extends Comparable<E>>       
     int binarySearch(E[] a, E x);
```
   
This method should then trigger another helper method that searches the array **recursively** for the value x. Your method should return the index of the element if it's found (you may assume that each element is unique). Return -1 if the element is not found.

Finally, create a main method that builds an array of String objects and then sort that array with Arrays.sort.  

Demonstrate your recursive binarySearch method on this array.