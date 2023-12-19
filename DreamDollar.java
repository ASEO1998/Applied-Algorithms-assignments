public class DreamDollar {


    static double min_bills(double n, double DreamDollarArray[] ){

        if (n== 0){
            return 0;
        }

        if(n < 0){
            return Double.POSITIVE_INFINITY;
        }
        else{
            double minimum_bills = Double.POSITIVE_INFINITY;
            for( int i = 0; i < DreamDollarArray.length; i++){
                if (i <= n){
                
                    minimum_bills = Math.min(minimum_bills, 1 + min_bills(n - DreamDollarArray[i], DreamDollarArray));
                }
            }
        
            return minimum_bills;
        }
        
        
    }
    public static void main(String args[]){
        double Dream_Dollars [] = {1,4,7,13,28,52,91,365};
        double k = 56;
        double result = min_bills(k, Dream_Dollars);
        //System.out.println(min_bills(k, Dream_Dollars));
        int finalresult = (int) result;
        System.out.println("The minimum number of bills used as possible for $"+ k + " is "+finalresult);

    }
    
}
