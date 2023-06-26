/**
 * @author Jorge Galvis 
 * This class implements the SymbolBalanceInterface
 */

import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class SymbolBalance implements SymbolBalanceInterface { 


    //Instance variables 
    String filename; 
    Stack<Character> characterChecker;
    

    /**
     * This method reads in a file name;
     */
    public void setFile(String filename) {

        this.filename = filename;

    }


    /**
     * This method check for unbalanced symbols in a file
     */
	public BalanceError checkFile() {

        characterChecker = new Stack<>();
        File f = new File(this.filename);
        Scanner in = null;

        try {

            in = new Scanner(f);

        } catch ( FileNotFoundException e ) {

            System.err.println("File: " + this.filename + " not found.");
            //System.exit(-1); By head TA do not use this line
            return null; // #312 try/catch/print the error/and return null

        }


        String specialOpenedCharacters = "{([";
        String specialClosedCharacters = "})]";
        char specialQuoteCharacter = '"';

        
        int charOpenedIdx = 0;
        int charClosedIdx = 0;

        boolean flagForComments = true;

        int count = 1;
        while( in.hasNextLine() ) {

            String line = in.nextLine();
            char symbolPopped = 0;
            char currentSymbol = 0;

            
            for(int i=0; i<line.length(); i++) {
                

                currentSymbol = line.charAt(i);
            

                //this checks for * /* */ inside a string to ignore them 
                if( (characterChecker.size() != 0) && (currentSymbol == '*') && (characterChecker.peek() == '"') ) {
                    continue;
                } 

                //this ignores for special chars inside a blockcomments
                if( (characterChecker.size() != 0) && ((currentSymbol == '[') || (currentSymbol == ']')) && (characterChecker.peek() == '*') ) {
                    continue;
                } else if( (characterChecker.size() != 0) && ((currentSymbol == '(') || (currentSymbol == ')')) && (characterChecker.peek() == '*') ) {
                    continue;
                } else if( (characterChecker.size() != 0) && ((currentSymbol == '{') || (currentSymbol == '}')) && (characterChecker.peek() == '*') ) {
                    continue;
                } else if( (characterChecker.size() != 0) && (currentSymbol == '"') && (characterChecker.peek() == '*') ) {
                    continue;
                } 


                //checking for blockcomments
                if ( (characterChecker.size() == 0) && (currentSymbol == '*') && ( i > 0)
                && (flagForComments == true) ){
                    
                    if ( line.charAt(i-1) == '/' ) {
                        
                        characterChecker.push( currentSymbol );
                        flagForComments = false;
                        
                    }

                } else if ( (characterChecker.size() != 0) && (characterChecker.peek() != '*') &&
                (currentSymbol == '*') && ( i > 0) && (flagForComments == true) ) {

                    if ( line.charAt(i-1) == '/' ) {

                        characterChecker.push( currentSymbol );
                        flagForComments = false;

                    }
                    

                } 
                
                
                if ( (characterChecker.size() != 0) && (characterChecker.peek() == '*') &&
                (currentSymbol == '/') && ( i>= 1 ) && (flagForComments == false)) {
                    

                    if ( line.charAt(i-1) == '*') {
                        
                        currentSymbol = '*';
                        symbolPopped = characterChecker.peek();
                        characterChecker.pop();


                        if(currentSymbol != symbolPopped) {
                            return new MismatchError( count, currentSymbol, symbolPopped );
                        }

                        flagForComments = true;

                    }


                } 
        
                


                //checks for strings
                if ( currentSymbol == specialQuoteCharacter ) {


                    if ( (characterChecker.size() != 0) && (characterChecker.peek() == currentSymbol) ){

                        symbolPopped = characterChecker.peek();
                        characterChecker.pop();
                        
                        if(currentSymbol != symbolPopped) {
                            return new MismatchError( count, currentSymbol, symbolPopped );
                        }

                    } else {
                        
                        characterChecker.push( currentSymbol );
                        continue;

                    }

                }
                


                //check for opened characters 
                if ( (specialOpenedCharacters.contains(Character.toString( currentSymbol ))) 
                && characterChecker.size() == 0 ){

                    charOpenedIdx = specialOpenedCharacters.indexOf( currentSymbol );
                    characterChecker.push(currentSymbol);

                } else if( (specialOpenedCharacters.contains(Character.toString( currentSymbol )))  
                && (characterChecker.peek() != specialQuoteCharacter) ) { 
                    
                    charOpenedIdx = specialOpenedCharacters.indexOf( currentSymbol );
                    characterChecker.push(currentSymbol);

                }


                //check for closed characters 
                if( (specialClosedCharacters.contains(Character.toString( currentSymbol ))) 
                && (characterChecker.size() == 0) ) {

                    return new EmptyStackError( count );

                } else if ( (specialClosedCharacters.contains(Character.toString( currentSymbol ))) 
                && (characterChecker.peek() != specialQuoteCharacter) ) { 
                    
                    charClosedIdx = specialClosedCharacters.indexOf( currentSymbol );

                    charOpenedIdx = specialOpenedCharacters.indexOf( characterChecker.peek() );
                    symbolPopped = characterChecker.peek();
                    characterChecker.pop();

                    
                    if (charOpenedIdx != charClosedIdx) {
                        return new MismatchError( count, currentSymbol, symbolPopped );
                    }
                    

                } 


            }

            count++;
            
        }

        in.close();

        if( characterChecker.size() != 0 ) {

            return new NonEmptyStackError( characterChecker.peek(), characterChecker.size() );
       
        }


        return null;

    }


}


