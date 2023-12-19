import java.util.*;


public class CatalanTD {
    public static int c = 0;

    static int catalan(int n){
        if (n == 0){
            return 1;
        }
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += catalan(i - 1) * catalan(n - i);
            //System.out.println(sum + ": current n " + n);
            c ++;
        }
        
        return sum;
    }
    

    public static void main(String args[]){
        
        //int n = 2;
        Scanner userinput = new Scanner(System.in);
        System.out.println("Which nth catalan number do you want?");
        int n = userinput.nextInt();
        int result = catalan(n);
        System.out.println("Here is number " + n +" of the catalan: " + result);
        System.out.println("The number of multiplcations for this number is " +c + " multiplications");
    }
}
