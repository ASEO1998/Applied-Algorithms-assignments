import java.util.*;
import java.util.Scanner;

public class Quicksort2 {

  

    public static void quicksort(int[] array, int lowerbound,int highbound){
        
        
        if (lowerbound < highbound){

            // r is the partion index
            int r = partition(array, lowerbound,highbound);

            
            quicksort(array, lowerbound,r - 1);
            quicksort(array, r + 1, highbound);
            
        }

    }

    static void swap (int [] arr, int lowerbound, int upperbound){
        int temp = arr[lowerbound];
        arr[lowerbound] = arr[upperbound];
        arr[upperbound] = temp;
    }

    public static int partition(int [] array, int lowerbound,int upperbound){


        Random rand= new Random(); 
        int pivot = rand.nextInt(upperbound-lowerbound)+lowerbound; 
        
        swap(array, pivot, upperbound);
         
        int l = (lowerbound - 1);

        for(int i = lowerbound; i <= upperbound - 1; i++){
            if(array[i] < array[upperbound]){
                l = l + 1;

                swap(array, l, i);
            }
        }

        swap(array, l + 1, upperbound);
        return l + 1;
        
    }

    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 

    static boolean sortcheck(int arr[]){

        for(int i = 0; i < arr.length - 1; i ++){
            if(arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        int[]array;
        
        int pivot = 3;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the number on how big you want the array to be \n");
        int arraySize = userInput.nextInt();

        array = new int[arraySize];

        int length = array.length;

        //String numbers = userInput.nextLine();
        System.out.println("Type a number to add to the array. Press enter for each number.  Keep doing this until a message pops up");
        for (int i = 0; i < length; i ++){
            int numbers = userInput.nextInt();
            array[i] = numbers;
        }
        System.out.println("Unsorted array");
        printArray(array);
        quicksort(array,0,length - 1);
        System.out.println("Array after quicksort:");
        printArray(array);

        if (sortcheck(array) == true){
            System.out.println("The array is sorted");
        }
        else{
            System.out.println("The array is not sorted, so the quicksort didn't work");
        }
    }
    
}

