import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {8,63,48,12,0,45,96};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapify(int i,int size,int arr[]){

        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int maxIdx = i;
   

        if(leftChild<size && arr[leftChild]>arr[maxIdx]){
            maxIdx=leftChild;
        }
        if(rightChild<size && arr[rightChild]>arr[maxIdx]){
            maxIdx=rightChild;
        }

        if(maxIdx!=i){
            int temp=arr[maxIdx];
            arr[maxIdx]=arr[i];
            arr[i]=temp;
            heapify(maxIdx,size,arr);
        }
    }

    public static void heapSort(int arr[]){
        int n=arr.length;

        // Create max heap to sort the array in ascending order
        for(int i = n/2;i>=0;i--){
            heapify(i,n,arr);
        }

        // step-2 pushing largest value at the end
        for(int i=n-1;i>0;i--){
            // swap first with last
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(0,i,arr);
        }
    }
}
