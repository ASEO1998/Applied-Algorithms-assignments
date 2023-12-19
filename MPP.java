import java.util.Scanner;


/*
 * Aaron Seo
 * 
 *                      {  p[r,c]                               if r = n and c = n
 *                      {  p[r,c] + MaxProfit(r + 1,c,n)        if c = n
 * MaxProfit(r,c,n) =   {  p[r,c] + MaxProfit(r,c + 1,n)        if r = n
 *                      {  
 *                      {              {MaxProfit (r, c + 1 , n)   }
 *                      {  p[r,c] + max{MaxProfit (r + 1, c , n)   }  otherwise
 *                      {              {MaxProfit (r + 1, c + 1, n)}
 * 
 * 
 * 
 */

public class MPP {


    public static int MaxProfit(int [][] p, int r, int c, int n){
        int maxTotal = 0;
        Scanner userInput = new Scanner(System.in);
        // while (p[r][c] < 0){
        //     System.out.println("The value for the index [" + r +"][" + c + "] is a negative integer. \nType in a positive integer" );
        //     int values = userInput.nextInt();
        //     p[r][c] = values;
        // }
        if (r == n && c == n){
            maxTotal += p[r][c];
            return maxTotal;
        }

        else if(c == n){
            maxTotal += p[r][c] + MaxProfit(p, r + 1, c, n);
        }

        else if (r == n){
            maxTotal += p[r][c] + MaxProfit(p, r, c + 1, n);
        }
        else{
            int maxNumber;
            // maxNumber = Math.max(p[r][c + 1],p[r + 1][c]);
            // maxNumber = Math.max(p[r + 1][c + 1], maxNumber);
            maxNumber = Math.max(MaxProfit(p, r, c + 1, n), MaxProfit(p, r + 1, c, n));
            maxNumber = Math.max(maxNumber, MaxProfit(p, r + 1, c + 1, n));

            maxTotal += p[r][c] + maxNumber;
            
            // if (maxNumber == p[r+1][c+1]){
            //     maxTotal += p[r][c] + MaxProfit(p, r + 1, c + 1, n);
            // }

            // else if (maxNumber == p[r + 1][c]){
            //     maxTotal += p[r][c] + MaxProfit(p, r + 1, c, n);
            // }

            // else if (maxNumber == p[r][c+1]){
            //     maxTotal += p[r][c] + MaxProfit(p, r, c + 1, n);
            // }

        }
        
        return maxTotal;
    }
    public static void main (String args[]){
        int n = 5;
        int [][] p = new int[n][n];
        Scanner userInput = new Scanner(System.in);

        System.out.println("Type a total of 25 numbers. \nPress enter for each number you type or type all the numbers in the same line.\n");
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                //System.out.println();
                int values = userInput.nextInt();
                p[i][j] = values;
            }
        }

        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(p[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println("Maximum profit is " + MaxProfit(p,0,0, n - 1));

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(p[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
