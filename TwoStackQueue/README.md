## Two Stack Queue 

Build a queue out of two completely separate stacks, `S1` and `S2`. Enqueue operations happen by pushing the data on to stack 1.
Dequeue operations are completed with a pop from stack 2.  

Obviously you will have to find some way to get the input stack information over to the output stack.  Your job is to figure out how and when to do that, using only push and pop operations.

Write a class TwoStackQueue that provides the Queue ADT (by implementing the `TwoStackQueueInterface`) using two stacks. Your class should explicitly implement the interface provided above.  Since the interface is generic, your class should be as well. Provide all methods specified in the interface. Your class should not use any additional memory to store the data in the queue except for the two stacks. 

For your stacks, you may either use your `MyStack` from the last assignment or you may the built-in `java.util.Stack` class.

All methods must run in constant time, except for one, which is allowed to run in linear time occasionally.
