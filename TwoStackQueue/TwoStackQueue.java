/**
 * @author Jorge Galvis 
 * This class implements the TwoStackQueueInterface
 */

import java.util.Stack; 
import java.util.Iterator; 

public class TwoStackQueue<T> implements TwoStackQueueInterface<T> {


    Stack<T> s1;
    Stack<T> s2; 
    Iterator<T> itr;


    /**
     * This construct a new queue
     */ 
    public TwoStackQueue() {

        s1 = new Stack<>(); 
        s2 = new Stack<>(); 
        itr = s1.iterator();

    }


    /**
     * This method enqueues an element into the queue
     */   
	public void enqueue(T x) {

        s1.push( x );
        
    }

    
    /**
     * This method dequeues an element from the queue
     * @return dequeued element 
     */   
	public T dequeue() {

        while( itr.hasNext() ) {
            
            s2.push( s1.pop() );

        }
        
        return s2.pop();

    }


    /**
     * This method returns the size of the queue
     * @return size of the queue
     */   
	public int size() {


        return s1.size() + s2.size();

    }


    /**
     * This method checks if the queue is empty
     * @return true if empty, otherwise false
     */   
	public boolean isEmpty() {
        
        if ( (s1.size() == 0) && (s2.size() == 0) ) {
            return true;
        }

        return false;

    }	
    

}

/*Check ed for the clarification of return value when the queue is empty*/
/*Answeredon ed #243. Let it throw the EmptyStackError */