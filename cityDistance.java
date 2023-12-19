public class cityDistance{
    static int distCities(int arr[], int i, int j){
        
        //i is the city we are starting at. j  is the city we want to go to.
        //int k = arr.length;
        int totalDistance = 0;
        
        //int n = arr.length;
        // if (i == j){
        //     return totalDistance;
        // }
       
        // while(i < n){
        //     if (j - 1 == i){
        //         totalDistance = totalDistance + arr[i];
        //         return totalDistance;
        //     }
        //     totalDistance = totalDistance + arr[i];
            
        //     i++;
            
        // }
        int steps = (j - 1) - i;
        while (steps >= 0){
            totalDistance = totalDistance + arr[i];
            i = i + 1;
            steps = steps - 1;
        }
        return totalDistance;
    }
    public static void main(String args[]){
        int distances[] = {25,40,20,10};
        int i = 0;
        int j = 4;
        int totalDistance = distCities(distances,i,j);
        System.out.println(totalDistance);

    }
}
