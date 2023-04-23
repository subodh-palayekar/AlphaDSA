import java.util.*;
public class InBuiltSort {
    public static void main(String[] args) {
        int arr[]={5,4,6,7,1,2};
        Integer arr2[] = {5,4,6,7,1,2};
        Arrays.sort(arr); 
        
        // Sort the array for specific range
        // Arrays.sort(arr,1,5);

        //Sort the array in Descending order
        Arrays.sort(arr2,Collections.reverseOrder());

        //Sort the array in Descending order for specific range
        // Arrays.sort(arr2,1,5,Collections.reverseOrder());
          
        System.out.println(Arrays.toString(arr2));
    }
}
