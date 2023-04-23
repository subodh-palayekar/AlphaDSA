import java.util.*;
public class Reverse {
    public static void main(String[] args) {
         int arr[]={2,4,5,3,1,10};
         reverse(arr);
        
         
    }
    // Time complexity O(n/2) ~ O(n)  space complexity O(1) constant
    public static void reverse(int arr[]){
        int n=arr.length;
        int start=0;
        int end=n-1;
        while(start<end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        System.out.print(Arrays.toString(arr));
    }
}
