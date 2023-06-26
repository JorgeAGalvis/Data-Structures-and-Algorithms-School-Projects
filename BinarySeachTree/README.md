## Binary Search Tree (BST) Algorithms 

In this problem, you will implement various algorithms operating on binary search trees. We have provided with you a standard implementation of a generic BST in *BinarySearchTree.java*. Note that this class is an **abstract class**, which means that some of its methods are not implemented. In previous assignments, you have implemented interfaces which specified methods that you needed to write. Very similarly, an abstract class is a class with some unimplemented methods (it can be thought of somewhat like an interface but with some methods actually implemented). You will need to write a *BetterBST* class which **extends BinarySearchTree**. Your *BetterBST* class can then be treated just like a regular *BinarySearchTree*, just with some additional functionality.

The methods that you will need to implement in *BetterBST* perform various algorithms on BST instances. For some of these methods, you may find it convenient to implement a private helper method as you did in previous assignments.

* ```public int height()``` - return the height of the BST
* ```public T imbalance()``` - check whether the tree is balanced. A balanced tree is one where every node's left and right subtrees differ in height by _no more than 1_. Return the value at first node you find which has a height imbalance *greater than 1* between its subtrees, or ```null``` if no such node exists (i.e. the tree is balanced). In class, we discussed AVL trees, which enforce this balance condition.
* ```public T smallestGreaterThan(T t)``` - given some generic comparable value _t_, find the smallest value in the BST that is larger than _t_. For example, if a binary search tree contains the values 1, 3, and 5, and the function is called with _t = 2_, it should return 3.
* ```public BinarySearchTree<T> mirror()``` - return a mirrored version of the BST instance to satisfy a reversed BST condition. In a reversed BST condition, for every node, _X_, in the tree, the values of all the items in its right subtree are smaller than the item in _X_, and the values of all the items in its left subtree are larger than the item in _X_.  In the mirrored tree, any node that is a left child becomes a right child and vice versa. You should not modify the BST instance itself. Instead, you should create a new BST instance and build it.
* ```public LinkedList<BinaryNode<T>> levelOrderTraversal``` - return a LinkedList<BinaryNode<T>> of a level order traversal of the binary tree. For example, given the tree below, the method should return: {3, 1, 5, 4} (Hint: think about how you might use a queue to solve this problem. Take a look at an algorithm for breadth first search)
```
     3
 1       5
       4
```

Make sure you read the BST code in depth before you start implementing *BetterBST*. In particular, take note of the various internal methods, nested classes, and instance variables that you can access from *BetterBST*.

We will test this program with our own tester class in a separate file.  You should also create a tester class for your own testing purposes.  Your tester class will not be graded.
