import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int arr[]={1,1,0,4,3,5,3,4,7,2};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countingSort(int arr[]){
        int n = arr.length;
        int MaxValue = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            MaxValue=Math.max(MaxValue, arr[i]);
        }
        
        // Creating counting array from 0 to maxValue. (size=n+1) considering all positive number till maxValue
        int count[]= new int[MaxValue+1];
   
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<count.length;i++){
            
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }

    }
}
