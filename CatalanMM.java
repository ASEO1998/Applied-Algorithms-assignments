import java.util.*;

public class CatalanMM {
    public static int counter = 0;
    public static int subcounter = 0;
    
    
    
    public static int CatalanMemoized(int n, int [] c){
        //n = n -1;
        

        if (n == 0){
            return 1;
        }

        if (c[n] != -1){
            return c[n];
        }
        int sum = 0;
        for(int i = 1; i <= n; i ++){
            //sum += catalan(i - 1) * catalan(n - i);
            sum += CatalanMemoized(i- 1, c) * CatalanMemoized(n - i, c);
            subcounter++;
        }
        c[n] = sum;
        //return 0;
        return sum;
    }

    public static void main(String[] args){
        int array[] = {1,1,2,5,14};
        int newarray[];
        Scanner userinput = new Scanner(System.in);
        System.out.println("Which nth catalan number do you want?");
        int arraysize = userinput.nextInt();
        //arraysize = arraysize;
        newarray = new int[arraysize + 1];
        

        //This if statement occurs if the user input's index number does exist in the preset array.

        if (arraysize + 1 <= array.length || arraysize == 0) {
            if (arraysize == 0){
                array = new int[1];
                array[0] = 1;
            }
            System.out.println("Here's your "+ arraysize +"th catalan number: " +CatalanMemoized(arraysize, array));
        }


        else{
            for(int i = 0; i < array.length; i ++){
            newarray[i] = array[i];
        }

        for (int i = array.length; i < arraysize + 1; i++){
            newarray[i] = -1;
        }

        for(int i = 0 ; i < newarray.length; i ++){
            subcounter = 0;
            newarray[i] = CatalanMemoized(i, newarray);
            System.out.println("Total multiplcations for " + newarray[i] +" is " + subcounter);
            counter += subcounter;
        }
        //System.out.println(result);
        System.out.println(Arrays.toString(newarray));
        System.out.println("\nHere's your requested catalan number: "+ newarray[arraysize]);
        }

        System.out.println("\nThe total multiplications performed is " + counter);
        
        //CatalanMM cn = new CatalanMM();
        
    }
}
