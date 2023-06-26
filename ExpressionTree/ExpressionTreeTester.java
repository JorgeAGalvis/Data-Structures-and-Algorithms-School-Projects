public class ExpressionTreeTester {


    public static void main(String[] args) {
        
        String[] cases = {"34 2 - 5 *", 
                          "3 5 * 4 + ", 
                          "1 2 3 * + 4 5 * 6 + 7 * +", 
                          "4"};
        

        for(String s: cases) {

            ExpressionTree a = new ExpressionTree(s);

            System.out.println( "evaluates to: " + a.eval() );
            System.out.println( "postfix expression: " + a.postfix() );
            System.out.println( "prefix expression: " + a.prefix() );
            System.out.println( "infix expression: " + a.infix() );
            System.out.println( "" );


        }

        /*------EdgeCases--------*/

        //Invalid postfix expression-Empty input
        //String case1 = "   ";
        //ExpressionTree b = new ExpressionTree(case1);

        //Invalid postfix expression-Stack not empty
        //String case2 = "1 2 3 4 *";
        //ExpressionTree b = new ExpressionTree(case2);

        //Invalid postfix expression-some other characters 
        //String case5 = "4 4 + : /";
        //ExpressionTree b = new ExpressionTree(case5);

        //Invalid postfix expression-all number not operators
        //String case3 = "3 1 2 8 3 1 8 9 2 3";
        //ExpressionTree b = new ExpressionTree(case3);

        //Invalid postfix expression-all operators not numbers
        //String case4 = "* - - - - - + /";
        //ExpressionTree b = new ExpressionTree(case4);

        //Invalid postfix expression
        //String case6 = " 4 * ";
        /ExpressionTree b = new ExpressionTree(case6);

        


    }

}