public class KBestCounterTester {

    /*
     * Tester main method 
     */
    public static void main(String[] args) {
        
        int[] data = {101,100,2,77,3,17}; //return 17, 77, 100, 101

        KBestCounter<Integer> a = new KBestCounter<>( 4 );
        
        for( int i=0; i<data.length; i++ ) {

            a.count( data[i] );

        }


        System.out.println( a.kbest() );
        System.out.println( a.kbest() );
        System.out.println( a.kbest() );


    }


}
