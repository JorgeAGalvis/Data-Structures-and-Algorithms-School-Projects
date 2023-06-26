public class MyStackTester {

    public static void main(String[] args) {
        
        
        //test1
        MyStack<Integer> a = new MyStack<>();
        
        a.push(1);
        a.push(3);
        a.push(4);
        a.push(5);
        a.push(9);

        System.out.println( a.peek() );
        a.pop();
        a.pop();

        System.out.println( a.peek() );
        System.out.println( a.isEmpty() );
        System.out.println( a.size() );

        //test 2
        System.out.println("");
        MyStack<Integer> b = new MyStack<>();
        System.out.println( b.isEmpty() );

        for(int i=0; i<50; i++) {
            b.push(i);
        }

        System.out.println( b.peek() );
        b.pop();
        b.pop();

        System.out.println( b.peek() );
        System.out.println( b.isEmpty() );
        System.out.println( b.size() );
        
        //test3
        System.out.println("");
        MyStack<Character> palindromeChecker = new MyStack<>();
        StringBuilder s = new StringBuilder();
        String word = "kayak";

        for(int i=0; i<word.length(); i++) {
            palindromeChecker.push((word.charAt(i)));
        }

        for(int i=0; i<word.length(); i++) {
            s.append(palindromeChecker.pop());

        }

        System.out.println(word);
        System.out.println(s);
        System.out.println(s.toString().equals(word));


        //test4
        System.out.println("");
        MyStack<String> c = new MyStack<>();
        c.pop();
        c.push("Hello");
        System.out.println( c.peek() );
        System.out.println( c.size() );
        c.pop();
        System.out.println( c.size() );
        System.out.println( c.peek() ); //outputs null cause I am printing it 
    }

}