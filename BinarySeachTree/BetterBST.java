/**
 * @author Jorge Galvis 
 * Uni: jag2425
 */

import java.util.LinkedList;

public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T> {


	/**
     * This constructors creates a new BST tree 
	 * using the same constructor as the parent class
     */
	public BetterBST() {

		super();

	}


	/**
	 * Evaluates the height of the BST
	 * @return height of the BST
     */
	public int height() {

		return height( root );

	}


	/**
	 * Private helper method that recursively calculates the height of the BST
	 * @return height of the BST
     */
	private int height( BinaryNode<T> t ) {

		if( t == null ) {
			return -1;
		}

		return 1 + Math.max( height(t.left), height(t.right) );

	}


    /**
	 * Checks if a BST is balance 
     */
	public T imbalance() {

		return imbalance( root );

	}

    /**
	 * Private helper methods that recursively check if a BST is balanced 
     * @return the node where the imbalance happens 
     */
	private T imbalance(BinaryNode<T> t) {
		
        if( t == null ) {
            return null; 
        }

        T lb = imbalance( t.left );
        T rb = imbalance( t.right ); 

		if( lb != null ) {
			return lb;
		}

		if( rb != null ) {
			return rb;
		}

        if( Math.abs( height(t.left) - height(t.right) ) > 1 ){
            return t.data; 
        }

        return null; 

	}



	/**
	 * Finds the smallestGreaterThan of the BST
     */
	public T smallestGreaterThan(T t) {

		return smallestGreaterThan(t, root);

	}


	/**
	 * Private helper method that recursively find the smallestGreaterThan
	 * @return smallestGreaterThan than the input
     */
	private T smallestGreaterThan(T x, BinaryNode<T> t) {

        T result = null;

        if( t == null ) {
			return result;
		}
            
        int compareResult = x.compareTo( t.data );

        if( compareResult >= 0 ) {
			return smallestGreaterThan( x, t.right );	
		} else {
			result = smallestGreaterThan( x, t.left );
            if (result != null)
                return result;
            return  t.data;
		}

	}

	
	/**
	 * Creates a mirrow instance of the original BST 
     */
	public BinarySearchTree<T> mirror() {
		
		BinaryNode<T> mirrorRoot = mirror( root );
		BetterBST<T> mirrorTree = new BetterBST<>();
		mirrorTree.root = mirrorRoot;
		return mirrorTree;

	}


	/**
	 * Private helper method that generates a new root with the values swapped 
	 * @return a new root  
     */
	private BinaryNode<T> mirror( BinaryNode<T> t ) {

		if( t == null ) {
			return null; 
		}
		
        BinaryNode<T> temp = new BinaryNode<>(t.data, null, null);

        temp.left = mirror(t.right);
        temp.right = mirror(t.left);

        return temp;

	}



	/**
	 * Returns a LinkedList with the levelOrderTraversal 
     */
	public LinkedList<BinaryNode<T>> levelOrderTraversal() {

		return levelOrderTraversal( root );

	}


	/**
	 * Private helper method that iteratively traverse the BST and
	 * @return a LinkedList with the levelOrderTraversal
     */
	private LinkedList<BinaryNode<T>> levelOrderTraversal( BinaryNode<T> t ) {

		LinkedList<BinaryNode<T>> result = new LinkedList<>();

		if ( t == null ) {
			return result; 
		}
			
		LinkedList<BinaryNode<T>> queue = new LinkedList<>();
		queue.add( t );
		
		while( !queue.isEmpty() ) {
			
			BinaryNode<T> current = queue.poll();
			result.add( current );

			if ( current.left != null ) {
				queue.add( current.left );
			}
			
			if( current.right != null ) {
				queue.add( current.right );
			}
				
			

		}
		
		return result; 

	}


}
