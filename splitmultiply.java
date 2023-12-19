import java.lang.Math;
import java.util.Scanner;

public class splitmultiply {

    public static long SplitMultiply(long x, long y, long n){

        if (n == 1){
            //System.out.println("End");
            return x * y;
        }

        else{
            double n2 = (double) (n/2.0);
            //System.out.println("n2 = "+ n2);
            long m =  (long) Math.ceil(n2);
            //System.out.println("m = "+ m);
            long a = (long) (x/Math.pow(10, m)); 
            //System.out.println("a = "+ a);
            long b = (long) (x % Math.pow(10, m));
            //System.out.println("b = "+ b);
            long c = (long) (y/Math.pow(10, m));
            //System.out.println("c ="+ c);
            long d = (long) (y % Math.pow(10, m));
            //System.out.println("d = "+ d);
            long e = SplitMultiply(a, c, m);
            //System.out.println("e = "+ e);
            long f = SplitMultiply(b, d, m);
            //System.out.println("f = "+ f);
            long g = SplitMultiply(b, c, m);
            //System.out.println("g = "+ g);
            long h = SplitMultiply(a, d, m);
            //System.out.println("h = "+ h);
            return (long)((Math.pow(10 ,2*m) * e) + (Math.pow(10, m) * (g + h) + f));
        }
        //return 0;
    }
    public static void main(String args[]){
        
        long n;

        
        System.out.println(11/3);
        Scanner userInput = new Scanner(System.in);

        System.out.println("type in an integer");
        long x = userInput.nextLong();
        System.out.println("type another integer");
        long y = userInput.nextLong();
        String lengthx = x + "";
        String lengthy = y + "";
        long countx = 0;
        long county = 0;
        long numx = x;
        long numy = y;

        while(numx != 0){
            numx /= 10;
            countx ++;
        }
        
        System.out.println("Number of digits for the first integer is " + countx);


        while(numy != 0){
            numy /= 10;
            county ++;
        }
        
        System.out.println("Number of digits for the second integer is " + county);

        //x = x ** 2;
        if(countx > county){
            n = countx;
            //num = x;
        }
        else{
            n = county;
            //num = y;

        }
        System.out.println("with the bigger number of digits, n is " + n);
        //n = 150;

        System.out.println("The product is " + SplitMultiply(x, y, n));

    }
}
