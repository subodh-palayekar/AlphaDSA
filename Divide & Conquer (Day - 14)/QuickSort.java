import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[]= {3,2,5,64,3,2};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));  
    }

    public static void quickSort(int [] arr, int si , int ei){

        if(si>=ei){
            return;
        }
        int pivotIndex = partition(arr,si,ei);
        quickSort(arr, si, pivotIndex-1);
        quickSort(arr, pivotIndex+1, ei);
    }

    private static int partition(int[] arr, int si, int ei) {


        int pivot = arr[ei];
        int i =si-1;
        
        for(int j=si; j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        
        i++;
        int temp = arr[i];
        arr[i]=pivot;
        arr[ei]=temp;


        return i;
    }
}
