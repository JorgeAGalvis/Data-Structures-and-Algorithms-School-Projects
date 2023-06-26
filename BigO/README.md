## BigO Notation

In a file called `BigO.java`, implement `BigOInterface` and write methods that have the following runtime requirements:

- `cubic` must be O(n^3)
- `exp` must be O(2^n)
- `constant` must be O(1)

Where n is an integer which is passed into the function. The methods can contain any code fragments of your choice. However, in order to receive any credit, the runtime requirements must be satisfied. As in the previous two problems, you must implement the interface to receive full credit.

In addition to writing the code fragments, we will explore their actual runtimes, to observe big-O in action in the real world. In a file called `Problem3.java` write a `main` method which runs the code with various values of `n` and measures their runtime. Then, discuss the results you observed briefly in a file called `Problem3.txt`.

Please run each of your methods with multiple different values of n and include the elapsed time for each of these runs and the corresponding value of n in `Problem3.txt`. 

To properly time code runtime in Java, we must disable compiler optimizations. We do this by running the code with the `-Xint` flag, for example: `java -Xint Problem3`. The easiest way to time your run is to wrap each fragment with the following code:

```
long startTime = System.nanoTime();
// YOUR CODE HERE
long endTime = System.nanoTime();
```

The elapsed time is the difference between these two variables.

Note also that you may see slightly erratic results due to noise and memory allocation delays. This may be one of the factors you discuss in addressing outliers.
