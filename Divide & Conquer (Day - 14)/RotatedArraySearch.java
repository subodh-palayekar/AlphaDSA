public class RotatedArraySearch {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2,3};
        System.out.println(rotatedSearch(arr,3,0,arr.length-1));
        System.out.println("mars".compareToIgnoreCase("earth"));
    }

    public static int rotatedSearch(int [] arr,int key,int si,int ei){
        int mid = si +(ei-si)/2;

        if(arr[mid]==key){
            return mid;
        }
        // mid to left
        if(arr[si]<=arr[mid]){
            
            // left - left
            if(arr[si]<=key && key<=arr[mid]){
              return  rotatedSearch(arr, key, si, mid-1);
            }else{
            // left-right
              return  rotatedSearch(arr, key, mid+1, ei);
            }

        }
        // mid to right
        else{
            // right-right
            if(arr[mid]<=key && key<=arr[ei]){
                return rotatedSearch(arr, key, mid+1, ei);
            }
            else{
                // right-left
                return rotatedSearch(arr, key, si, mid-1);
            }
           
        }
        
       
    }
}
