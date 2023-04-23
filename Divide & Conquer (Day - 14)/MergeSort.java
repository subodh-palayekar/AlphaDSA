import java.util.Arrays;

public class MergeSort{
    public static void main(String[] args) {
        int arr[]= {3,2,5,64,3,2};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int [] arr , int si , int ei){

        int mid = si + (ei - si)/2;
        if(si==ei){
            return;
        }

        // dividing array in two parts

        // left part
        mergeSort(arr, si, mid);

        // right part
        mergeSort(arr, mid+1, ei);

        // merging both part after sorting

        merge(arr, si,mid,ei);
    }

    private static void merge(int[] arr, int si, int mid, int ei) {

        int temp[] = new int[(ei-si)+1];

        int i=si; // starting index for left part
        int j=mid+1; // starting index for right part
        int k=0;  // iterator for temporary array
       
        // placing element in temporary array


        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
                
            }else{
                temp[k]=arr[j];
                j++;
                
            }
            k++;
        }
       
        // remaining element of left part
        while(i<=mid){
           temp[k++]=arr[i++]; 
        }
        // remainig element of right part
        while(j<=ei){
           temp[k++]=arr[j++]; 
        }

        // copy temp to original arr
        for(i=si,k=0; k<temp.length;k++,i++){
            arr[i]=temp[k];
        }


    }
}