public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6,7,8};  // prerequisite-sorted arrays
        
        int ans = binarSearch(arr, 1);
        System.out.println(ans);
    
    }
     
    // Time Complexity O(log n)
    public static int binarSearch(int arr[],int key){
        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(arr[mid]>key){    //left part
                end = mid-1;
            }else if(arr[mid]<key){
                start=mid+1;    // right part
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
