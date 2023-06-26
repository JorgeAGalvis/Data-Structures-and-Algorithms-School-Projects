/**
 * @author Jorge Galvis 
 * This class test the SymbolBalance class
 */

public class SymbolBalanceTester {

    public static void main(String[] args) {

        SymbolBalance f = new SymbolBalance();


        f.setFile("MyOwnTestFiles/MyOwnMockTestX.java");
        System.out.println("MyOwnMockTest.java: " + f.checkFile() );
        System.out.println("");

        
        f.setFile("TestFiles/Test1.java");
        System.out.println("Test1.java: " + f.checkFile() );

        f.setFile("TestFiles/Test2.java");
        System.out.println("Test2.java: " + f.checkFile() );

        f.setFile("TestFiles/Test3.java");
        System.out.println("Test3.java: " + f.checkFile() );

        f.setFile("TestFiles/Test4.java");
        System.out.println("Test4.java: " + f.checkFile() );

        f.setFile("TestFiles/Test5.java");
        System.out.println("Test5.java: " + f.checkFile() );

        f.setFile("TestFiles/Test6.java");
        System.out.println("Test6.java: " + f.checkFile() );
        

    }

}