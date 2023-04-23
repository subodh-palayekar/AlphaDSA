import java.util.Arrays;

public class AssignmentDivACon {
    public static void main(String[] args) {
        // String [] str = { "sun", "earth", "mars", "mercury"};
        // mergeSortString(str, 0, str.length-1);

        // int [] arr = {2,3,1,1};
        // System.out.println( majorityElement(arr));

        int [] nums = {};
        // System.out.println(inversion(nums));
        System.out.println(inversionRecursion(nums, 0, nums.length-1));
    
        
    }
      // MergeSort on String
    public static void mergeSortString(String [] arr,int si,int ei){
        int mid = si+(ei-si)/2;
        if(si>=ei){
            return;
        }
        

        mergeSortString(arr, si, mid);
        mergeSortString(arr, mid+1, ei);
        merge(arr, si, ei, mid);
    }




    public static void merge (String [] arr,int si,int ei,int mid){
        String temp[] = new String[(ei-si)+1];
        int i = si;
        int j=mid+1;
        int k =0;

       
        while(i<=mid && j<=ei){

            if(arr[i].compareToIgnoreCase(arr[j])<0){
                temp[k]=arr[i];
                i++;
               
            }else{
                temp[k]=arr[j];
                j++;
               
            }
            k++;
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        for(i=si,k=0;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }


    } 

    // Question 2: majority Element

    
    public static int majorityElement (int nums[],int start , int end){

        int mid = start + (end-start)/2;

        // Base Case
        if(start==end){
            return nums[start];
        }

        // Dividing array

        // Creating left part
        int left = majorityElement(nums, start, mid);

        // Creating Right part
        int right = majorityElement(nums, mid+1, end);

        // both left and right have same majority element
        if(left==right){
            return left;
        }

        //if left and right have different majority element then find which one of them is globally majority element

        int leftCount = countInRange(nums,start,end,left);

        int rightCount = countInRange(nums,start,end,right);

        return leftCount > rightCount ? left : right;


    }

    private static int countInRange(int nums[], int start, int end, int num) {
        int count=0;
        for(int i=start ; i<=end ;i++){
            
            if(nums[i]==num){
                count++;
            }
        }
        return count;
    }

    
    
    // Question 3 : Inversion Count of array

    public static int inversion(int nums[]){
        int count=0;
        for(int i=0;i<nums.length-1;i++){

            for(int j=i;j<nums.length;j++){
                if(nums[i]>nums[j] && i<j){
                    count++;
                }

            }
        }
        return count;
    }

    //Inversion Recursion 

    public static int inversionRecursion( int [] nums,int start,int end){
        int count=0;
        if(end>start){

            int mid = start + (end-start)/2 ;
            count = inversionRecursion(nums, start, mid);
            count += inversionRecursion(nums, mid+1, end);
            count += inversionMerge(nums, start, end,mid+1);
        }
        return count;

    }
    private static int inversionMerge(int[] nums, int start, int end, int mid) {
        int count=0;
        int i=start;
        int j=mid;
        int k=0;
        int [] temp = new int[(end-start)+1];

        while((i<mid) &&  (j<=end)){
            if(nums[i]<=nums[j]){
                temp[k]=nums[i];

                i++;
            }else{
                temp[k]=nums[j];
                count+=mid-i;
                j++;
                

            }
            k++;
        }
        
        while(i<mid){
            temp[k++]=nums[i++];
          
        }
        while(j<=end){
            temp[k++]=nums[j++];
        
        }

        for(i=start,k=0;k<temp.length;k++,i++){
            nums[i]=temp[k];
        }

        return count;
    }

   
}
