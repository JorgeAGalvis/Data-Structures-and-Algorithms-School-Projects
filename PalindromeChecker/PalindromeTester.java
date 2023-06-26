/**
 * @author Jorge Galvis 
 * Uni: jag2426
 * This class test Palindrome class
 */

public class PalindromeTester {

    public static void main(String[] args) {

        Palindrome a = new Palindrome();

        String[] testCases = {"repaper","kayak","deified","noon","tattarrattat"
,"WasitacaroracatIsaw", "SirIdemandIamamaidnamedIris", "Pull up Eva we re here Wave Pull up", 
"Doc, note I dissent: a fast never prevents a fatness. I diet on cod.",
"A man, a plan, a canal: Panama!","Red roses run no risk, sir, on Nurse’s order. ",
"Jorge", "COMS", "java", "Time", "Rail", "WaRD"};

        for(int i=0; i<testCases.length; i++) {

            if(a.isPalindrome(testCases[i]) == true) {
                System.out.println("Test case: " + testCases[i] + " PASSED." );
            } else {
                System.out.println("Test case: " + testCases[i] + " FAILED." );
            }
        }

    }

}