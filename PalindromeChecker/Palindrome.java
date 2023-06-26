/**
 * @author Jorge Galvis 
 * Uni: jag2426
 * This class implements PalindromeInterface
 */

public class Palindrome implements PalindromeInterface {

    //@override
    public boolean isPalindrome(String x) {

        MyStack<Character> palindromeStack = new MyStack<>();
        StringBuilder str = new StringBuilder();

        x = x.toLowerCase();

        //I can also do a for loop and simply not allow special characters in the stack
        
        //\W remove all nonword characters
        //https://docs.oracle.com/javase/9/docs/api/java/util/regex/Pattern.html
        x = x.replaceAll("\\W","");  
        
        for(int i=0; i<x.length(); i++) {
            palindromeStack.push((x.charAt(i)));
        }

        for(int i=0; i<x.length(); i++) {
            str.append(palindromeStack.pop());
        }

        if(str.toString().equals(x)) {
            return true;
        }

        return false;
    }


}

