public class Assignment {
    
    public static void main(String[] args) {
        
        int arr[] = {4,5,6,7,0,1,2};
       System.out.println(pivotSearch(arr2, 0));
        

    }

    /*Question 2: Search in rotated array with complexity O(logn)
      https://leetcode.com/problems/search-in-rotated-sorted-array/
     */


    public static int binarySearch(int arr[],int target,int start,int end){
        

        while(start<=end){
            int mid = start+(end-start)/2;

            if(arr[mid]>target){
                end=mid-1;
            }else if(arr[mid]<target){
               start= mid+1;
            }
            else{
                return mid;
            }

        }
        return -1;
    }

     public static int pivotSearch(int arr[],int target){
        int start=0;
        int end=arr.length-1;
        int mid = start+(end-start)/2;
        if(arr[mid]>arr[end]) {  // given array is in ascending order
            start=mid;
             return binarySearch(arr, target, start, end);
        }else if (arr[mid]<arr[start]){
           end=mid;
           return binarySearch(arr, target, start, end);
        } 
        return -1;
     }
}
