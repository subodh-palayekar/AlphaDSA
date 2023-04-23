
import java.util.*;

public class LongestIncreasingSubsequence {

    /*  this problem is similar to lcSubsequence but here instead of string arr is given 
     only 1 array is given so create second array which contains unique element and sorted in ascending 
     order so now we have two array . perform lcs on this two arrays
    */
     

    public static int longestIncreasingSubsequence(int arr[]){
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }

        int arr2[] = new int[set.size()];

        int k=0;
        for(int num : set){
            arr2[k]=num;
            k++;
        }

        Arrays.sort(arr2);

        // below code is same as lcs
        int n=arr.length;
        int m=arr2.length;
        int dp[][]= new int[n+1][m+1];

        // initialization 
        // j=0 first column=0
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }

        // i=0  first row=0 
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1; j<m+1;j++){
                if(arr[i-1]==arr2[j-1]){
                    dp[i][j]= 1+dp[i-1][j-1];
                }else{
                    int firstReduce = dp[i-1][j];
                    int secondReduce = dp[i][j-1];

                    dp[i][j]=Math.max(firstReduce, secondReduce);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        int arr[] = {50,3,10,7,40,80};
        System.out.println(longestIncreasingSubsequence(arr));
    }
}
