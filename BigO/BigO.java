/**
 * @author Jorge Galvis 
 * Uni: jag2426
 * This class implements BigOInterface
 */

public class BigO implements BigOInterface {

    //@override
    public void cubic(int n) {

        int sum = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    sum += 1;
                }
            }
        }

    }

    //@override
	public void exp(int n){

        int sum = 0;
        
        for(int i=0; i<Math.pow(2,n); i++) {

            sum += 1;

        }

    }

    //@override
	public void constant(int n){

        n += 1;

    }

}