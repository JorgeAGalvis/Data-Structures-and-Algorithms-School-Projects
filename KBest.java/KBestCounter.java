/**
 * @author Jorge Galvis 
 * Uni: jag2425
 */

import java.util.*;


public class KBestCounter<T extends Comparable<? super T>> implements KBest<T> {

    int k;
    PriorityQueue<T> heap;
    List<T> kLargestElements;
    

    /**
     * Constructor 
     * @param k indicates the amount of largest elements you want to return
     */
    public KBestCounter( int k ) {
        
        this.k = k;
        heap = new PriorityQueue<>( this.k );

    }


    /**
     * This method process the next element in the set of data
     * @param x next element to be inserted  
     * O(log k)
     */
	public void count( T x ) {

        if( heap.size() < this.k ) {

            heap.offer( x );
            //System.out.println( heap );

        } else if( x.compareTo( heap.peek() ) > 0) {

            heap.poll();
            heap.add(x);

        }

    }
    
    
    /**
     * This method sorts the elements in descending order
     * O(k). loop through the heap poll and add to the list 
     * @return a sorted (smallest to largest) list of the k-largest elements
     */
	public List<T> kbest() {
        
        PriorityQueue<T> heapCopy = new PriorityQueue<T>( heap) ;
        kLargestElements = new ArrayList<>();
        while( !heapCopy.isEmpty() ) {

            kLargestElements.add( heapCopy.poll() );

        }

        return kLargestElements;

    }
      

}