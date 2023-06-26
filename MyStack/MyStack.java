/**
 * @author Jorge Galvis 
 * Uni: jag2426
 * This class implements MyStackInterface
 */


public class MyStack<T> implements MyStackInterface<T> {

    private T [ ] theItems;
    private int theSize;
    
    private static final int INITIAL_CAPACITY = 10;

    /**
     * Constructs a Stack
     */
    @SuppressWarnings("unchecked")
    public MyStack() {

        theItems = (T [ ]) new Object[INITIAL_CAPACITY]; 
        theSize = 0;

    }

    /**
     * Grows the capacity of the array
     * @param newCapacity the new capacity of the array
     */
    @SuppressWarnings("unchecked")
    public void grow(int newCapacity) {

        if(theSize > newCapacity) {  //this condition is needed when theSize is not initialized 
            return;                  //to 0; for instance, an ArrayList.
        }

        T [ ] old = theItems;
        theItems = (T [ ]) new Object[newCapacity];  

        for(int i=0; i<old.length; i++) {
            theItems[i] = old[i];
        }

    }

    /**
     * Adds an item to the Stack
     * @param x any object 
     */
	public void push(T x){
        if(theSize==theItems.length) {
            grow(size()*2+1); //the new capacity is not going to be < theSize 
        }                     //because I am using size() * 2 + 1 to grow it 
        theItems[theSize++] = x;

    }

    /**
     * Removes the last element added to the stack
     * @return the removed item 
     */
	public T pop() {
        
        if( isEmpty() ) { 

            return null; 

        }

        return theItems[--theSize];

    }

    /**
     * @return the last value pushed into the stack
     */
	public T peek(){
        
        if( isEmpty() ) { 

            return null;

        }

        return theItems[theSize-1]; //theSize-1 is location 0 in the array

    }

    /**
     * @return true if stack is empty
     */
	public boolean isEmpty(){

        return size() == 0;

    }

    /**
     * @return the number of elements in the stack
     */
	public int size(){

        return theSize;

    }


}

