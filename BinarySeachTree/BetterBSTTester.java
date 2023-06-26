public class BetterBSTTester {

    public static void main(String[] args) {

        System.out.println("*-----First Test-----*");
        BetterBST<Integer> a = new BetterBST<>();

        a.insert(4);
		a.insert(3);
        a.insert(5);
		a.insert(2);
		a.insert(1);

        /*
                    4
                  /  \
                3     5
              /
             2
            /
           1 

        */ 

        System.out.print("Inorder: ");
        a.printTree(); 
        System.out.println("");
        System.out.println("Height of the BST: " + a.height() );
        System.out.println("Imbalance node: " + a.imbalance() );
        System.out.println("smallestGreaterThan 4: " + a.smallestGreaterThan(4) );
        System.out.print("Mirror BST: ");
        a.printMirrorTree();
        System.out.println("");
        System.out.print("levelOrderTraversal BST: ");
        a.printLevelOrderTraversal();
        System.out.println("");		


		System.out.println("");	
        System.out.println("");	


        System.out.println("*-----Second Test-----*");
        BetterBST<Integer> b = new BetterBST<>();

        b.insert(4);
        b.insert(2);
		b.insert(6);
		b.insert(1);
        b.insert(3);
		b.insert(5);
		b.insert(7);

        /*
                    4
                  /  \
                2     6
              /  \   | \
             1   3  5  7
            
        */ 

        System.out.print("Inorder: ");
        b.printTree(); 
        System.out.println("");
        System.out.println("Height of the BST: " + b.height() );
        System.out.println("Imbalance node: " + b.imbalance() );
        System.out.println("smallestGreaterThan 7: " + b.smallestGreaterThan(7) );
        System.out.print("Mirror BST: ");
        b.printMirrorTree();
        System.out.println("");
        System.out.print("levelOrderTraversal BST: ");
        b.printLevelOrderTraversal();
        System.out.println("");		


		System.out.println("");	
        System.out.println("");	


        System.out.println("*-----Third Test-----*");
        BetterBST<Integer> c = new BetterBST<>();


        /*
                null  
        */ 

        System.out.print("Inorder: ");
        c.printTree(); 
        System.out.println("");
        System.out.println("Height of the BST: " + c.height() );
        System.out.println("Imbalance node: " + c.imbalance() );
        System.out.println("smallestGreaterThan 7: " + c.smallestGreaterThan(7) );
        System.out.print("Mirror BST: ");
        c.printMirrorTree();
        System.out.println("");
        System.out.print("levelOrderTraversal BST: ");
        c.printLevelOrderTraversal();
        System.out.println("");		


    }
    
    /*
    I had this in the BetterBST class before to be able to test 
    //-------Testing Helper Methods------//

	public void printLevelOrderTraversal() {

		printLevelOrderTraversal( levelOrderTraversal() );

	}


	private void printLevelOrderTraversal( LinkedList<BinaryNode<T>> t ) {

		for( BinaryNode<T> x : t) {
			System.out.print( x.data + " " );
		}

	}



	public void printTree() {

		printTree( root );

	}


	private void printTree( BinaryNode<T> t ) {

		if ( t == null )
			return; 

		printTree( t.left );
		System.out.print( t.data + " " );
		printTree( t.right );
		
	
	}

	
	public void printMirrorTree() {
        
		printMirrorTree( mirror( root ) );

	}


	private void printMirrorTree( BinaryNode<T> t ) {

		if ( t == null )
			return; 

		printMirrorTree( t.left );
		System.out.print( t.data + " " );
		printMirrorTree( t.right );
		
	
	}
    */

}