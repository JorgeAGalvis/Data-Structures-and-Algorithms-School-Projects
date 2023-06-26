/**
 * @author Jorge Galvis 
 * This class test the TwoStackQueue class
 */

 public class TwoStackQueueTester {

    public static void main(String[] args) {

        TwoStackQueue<Integer> a = new TwoStackQueue<>();

        
        System.out.println( a.size() );         //0
        System.out.println( a.isEmpty() );      //true
        System.out.println("");

        for(int i=1; i<26; i++) {
            a.enqueue(i);
        }

        System.out.println( a.size() );         //25
        System.out.println( a.isEmpty() );      //false
        System.out.println("");

        System.out.println( a.dequeue() );      //1
        System.out.println( a.dequeue() );      //2
        System.out.println( a.dequeue() );      //3
        System.out.println( a.dequeue() );      //4
        System.out.println( a.dequeue() );      //5
        System.out.println("");

        System.out.println( a.size() );         //20
        System.out.println( a.isEmpty() );      //false

        for(int i=1; i<11; i++) {
            a.enqueue(i);
        }

        System.out.println("");
        System.out.println( a.size() );         //30 
        System.out.println( a.isEmpty() );      //false


        for(int i=1; i<21; i++) {
            a.dequeue();
        }

        System.out.println("");
        System.out.println( a.size() );         //10
        System.out.println( a.isEmpty() );      //false



        for(int i=0; i<10; i++) {
            a.dequeue();
        }

        System.out.println("");
        System.out.println( a.size() );         //0
        System.out.println( a.isEmpty() );      //true
        


    }


}
