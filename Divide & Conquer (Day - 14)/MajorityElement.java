public class MajorityElement {
    public static void main(String[] args) {
        int nums[] = {3,2};
        // System.out.println(majority(nums));
        
        System.out.println(majorityElement(nums, 0, nums.length-1));
        
    }

    public static int  majority (int nums[]){
        int mjc = nums.length/2;

        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count>mjc){
                return nums[i];
            }
           

        }
        return -1;
    }


    //-------------------------------------------------------------------------------------------------//
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
}
