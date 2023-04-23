import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[]={5,4,1,2,3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int arr[]){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int currElement =arr[i];
            int previousIndex=i-1;
            //Creating space for current Element in sorted array buy pushing element in forward/unsorted array
            while(previousIndex>=0 && arr[previousIndex]>currElement){
                arr[previousIndex+1]=arr[previousIndex];
                previousIndex--;
            }
            //placing current Element in its current Position in sorted array
            arr[previousIndex+1]=currElement;

        }
    }
}
