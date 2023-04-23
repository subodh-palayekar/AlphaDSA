import java.util.Arrays;

public class Inversion {
    public static void main(String[] args) {


        // Find theInversion Count in the array


        int [] nums = {5,5,5,5,5};
        System.out.println(mergeSort(nums, 0,nums.length-1));
        
    }

    public static int mergeSort(int [] arr , int si , int ei){
        int count=0;
       
        
        if(ei>si){
            int mid = si + (ei - si)/2;
        // dividing array in two parts

        // left part
        count = mergeSort(arr, si, mid);

        // right part
        count += mergeSort(arr, mid+1, ei);

        // merging both part after sorting

        count+= merge(arr, si,mid+1,ei);
        }
        return count;
        
    }

    private static int merge(int[] arr, int si, int mid, int ei) {
        int count=0;
        int temp[] = new int[(ei-si)+1];

        int i=si; // starting index for left part
        int j=mid; // starting index for right part
        int k=0;  // iterator for temporary array
       
        // placing element in temporary array


        while(i<mid && j<=ei){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                i++;
                
            }else{
                temp[k]=arr[j];
                j++;
                count+=mid-i;
                
            }
            k++;
        }
       
        // remaining element of left part
        while(i<mid){
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

        return count;
    }
   

}
