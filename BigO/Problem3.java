/**
 * @author Jorge Galvis 
 * Uni: jag2426
 * This class test the methods implemented in BigO.java
 */


public class Problem3 {

    public static void main(String[] args) {

        //Instantiate the BigO class and testcase the methods
        BigO a = new BigO();
        
        //int n = 7;
        //int n = 10;
        //int n = 15;
        //int n = 1;
        //int n = 3;
        //int n = 20;
        //int n = 25;
        //int n = 27;
        //int n = 28;
        int n = 30;



        //test1
        long startTime = System.nanoTime();
        // YOUR CODE HERE

        a.cubic(n);

        long endTime = System.nanoTime();
        long timeResult = endTime - startTime;
        System.out.println( timeResult );


        //test2
        startTime = System.nanoTime();
        // YOUR CODE HERE

        a.exp(n);

        endTime = System.nanoTime();
        timeResult = endTime - startTime;
        System.out.println( timeResult );



        //test3
        startTime = System.nanoTime();
        // YOUR CODE HERE

        a.constant(n);

        endTime = System.nanoTime();
        timeResult = endTime - startTime;
        System.out.println( timeResult );
    
    }


}