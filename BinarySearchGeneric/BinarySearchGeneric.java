/* Following the specification in the README.md file, provide your 
 * BinarySearchGeneric.java class.
 */

public class BinarySearchGeneric {

    //driver method 
    public static <E extends Comparable<E>> int binarySearch(E[] a, E x) {
            //all this method does is call the private method
            return binarySearch(a,x,0,a.length-1);
    }
    
    
    //recursive method 
    private static <E extends Comparable<E>>       
        int binarySearch(E[] a, E x, int start, int stop) {
        
        if(start > stop) {
            return -1;
        }

        int mid = (start + stop) / 2;
        int result = a[mid].compareTo(x);
        
        if(result>0) { //means x is in the lower half
            return binarySearch(a, x, 0, mid-1);
        } else if(result<0) { //means x is in the upper half
            return binarySearch(a, x, 0, mid+1);
        } else {
            return mid;
        }
        
    }


}

//  Type      Bound
// <E extends Comparable<E>
//<E can be treated as Comparable<E>