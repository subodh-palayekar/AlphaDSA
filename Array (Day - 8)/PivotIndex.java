public class PivotIndex {
    public static void main(String[] args) {
        int arr[]={4,7,1,2,3};
        System.out.println(pivot(arr));
    }


    public static int pivot(int arr[]){
        int start=0;
        int end=arr.length-1;

        while(start<end){
            int mid=start+(end-start)/2;

            if(mid>0 && arr[mid-1]>arr[mid]){
                return mid;
            }

            if(arr[start]<= arr[mid] && arr[mid]>arr[end]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return end;
    }
}
