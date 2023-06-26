/**
 * @author Jorge Galvis 
 * Uni: jag2425
 *
 *-------------------IMPORTANT----------------
 * Expression trees are always full           
 * It is either a leaf (operant) or              
 * a internal node (operator) with two children 
 *--------------------------------------------
 */

import java.util.Stack;


public class ExpressionTree implements ExpressionTreeInterface {


    //Instance variables 
    private ExpressionNode root;
    private Stack<ExpressionNode> expressionNodeStack; 


    /**
     * This constructors builds an expression tree 
     * @param String a postfix expression 
     */
    public ExpressionTree(String expression) {

        expression = expression.strip();

        //Checks if the input is empty
        if( expression.length() == 0)  {

            throw new RuntimeException("Invalid postfix expression");

        } 

        expressionNodeStack = new Stack<>();
        String[] tokens = expression.split(" ");
        String operators = "+-*/";


        for(String token: tokens) {
            
            if( !operators.contains(token) ) {

                int tempInt = 0;
                try {
                    tempInt = Integer.parseInt(token);
                } catch( RuntimeException e) {
                    throw new RuntimeException("Invalid postfix expression");
                }
                
                expressionNodeStack.push( new ExpressionNode(tempInt) );

            } else if( operators.contains(token) ) {

                char tempChar = token.charAt(0);
                ExpressionNode tempRight = null;
                ExpressionNode tempLeft = null;
                try {
                    tempRight = expressionNodeStack.pop();
                    tempLeft = expressionNodeStack.pop();
                } catch( RuntimeException e ) {
                    throw new RuntimeException("Invalid postfix expression");
                }
                
                expressionNodeStack.push( new ExpressionNode(tempChar, tempLeft, tempRight) );

            } 


        }

        root = expressionNodeStack.pop();

        //checks if there are remaining elements in the stack after the tree has been built 
        if( !expressionNodeStack.isEmpty() ) {
            
            throw new RuntimeException("Invalid postfix expression");

        }

    }


    /**
     * This method evaluates a given expression tree 
     * by calling a private recursive method 
     * @return an int that is the computation of the Expression Tree
     */
    public int eval() {

        return eval(root);

    }

    /**
     * This method takes in one parameter 
     * @param t which is the root of the Expression Tree
     * and recursively the right and left side of the Tree
     * @return the result of the root 
     */
    private int eval(ExpressionNode t) {

        if (t.left == null && t.right == null) {
            return t.operant;
        }

        int lval = eval(t.left);
        int rval = eval(t.right);
        
        return apply(t.operator, lval, rval);

    }


    /**
     * This method takes in three parameters:
     * @param char operator 
     * @param int left which is the left operant 
     * @param int right which is the right operant 
     * @return the result of applying the operator to the operants  
     */
    private int apply(char operator , int left, int right) {

        int result = 0;

        switch( operator ) {

            case '*':
                result = left * right; 
                break;

            case '/':
                result = left / right;
                break;

            case '+':
                result = left + right;
                break;

            case '-':
                result = left - right;
                break;

        }

        return result; 

    }


    /**
     * Driver method for a postfix expression 
     * @return the postfix expression of the expression tree
     */
	public String postfix() {

        return postfix(root);

    }


    /**
     * Private method that takes in the root of tree and recursively evaluates it
     * @param root of the Expression Tree
     * @return the postfix expression of the expression tree
     */
    private String postfix(ExpressionNode t) {

        if (t.left == null && t.right == null ) {

            return String.valueOf(t.operant);

        }

        String lval = postfix(t.left);
        String rval = postfix(t.right);

        return buildPostFix(String.valueOf(t.operator), lval , rval);
    }


    /**
     * Private helper method that creates the String expression to be returned
     * @param root of the Expression Tree
     * @param lval the left value of the Expression Tree
     * @param rval the right value of the Expression Tree
     * @return the postfix expression of the expression tree
     */
    private String buildPostFix(String operator, String lval, String rval) {

        StringBuilder sb = new StringBuilder();
        sb.append(lval + " " + rval + " " + operator);

        return new String( sb );

    }


    /**
     * Driver method for a prefix expression 
     * @return the prefix expression of the expression tree
     */
	public String prefix() {

        return prefix(root);

    }


    /**
     * Private method that takes in the root of tree and recursively evaluates it
     * @param root of the Expression Tree
     * @return the prefix expression of the expression tree
     */
    private String prefix(ExpressionNode t) {

        if (t.left == null && t.right == null ) {

            return String.valueOf(t.operant);

        }

        String lval = prefix(t.left);
        String rval = prefix(t.right);

        return buildPreFix(String.valueOf(t.operator), lval , rval);

    }


    /**
     * Private helper method that creates the String expression to be returned
     * @param root of the Expression Tree
     * @param lval the left value of the Expression Tree
     * @param rval the right value of the Expression Tree
     * @return the prefix expression of the expression tree
     */
    private String buildPreFix(String operator, String lval, String rval) {

        StringBuilder sb = new StringBuilder();
        sb.append(operator + " " + lval + " " + rval);

        return new String( sb );

    }


    /**
     * Driver method for a infix expression 
     * @return the infix expression of the expression tree
     */
	public String infix() {

        return infix(root);

    }


    /**
     * Private method that takes in the root of tree and recursively evaluates it
     * @param root of the Expression Tree
     * @return the infix expression of the expression tree
     */
    private String infix(ExpressionNode t) {

        if (t.left == null && t.right == null ) {

            return String.valueOf(t.operant);

        }

        String lval = infix(t.left);
        String rval = infix(t.right);

        return buildInFix(String.valueOf(t.operator), lval , rval);

    }


    /**
     * Private helper method that creates the String expression to be returned
     * @param root of the Expression Tree
     * @param lval the left value of the Expression Tree
     * @param rval the right value of the Expression Tree
     * @return the infix expression of the expression tree
     */
    private String buildInFix(String operator, String lval, String rval) {

        StringBuilder sb = new StringBuilder();
        sb.append( "(" + lval + " " + operator + " " + rval + ")" );

        return new String( sb );

    }


    /**
     * Expression tree node class
     */
    private static class ExpressionNode {
        
        char operator; 
        int operant; 
        ExpressionNode left;
        ExpressionNode right;

        public ExpressionNode(int operant) {

            this.operant = operant;
            left = null;
            right = null;

        }

        public ExpressionNode(char operator, ExpressionNode left, ExpressionNode right) {

            this.operator = operator;
            this.left = left;
            this.right = right;

        }

    }


}

/** Example used to build the class: 
 *
 *         +
 *       /  \
 *      *   4   
 *    /  \  
 *   3    5 
 *  
 */
