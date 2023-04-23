public class Kadanes {
    public static void main(String[] args) {
        int arr[]={2,4,6,8,9};
        int arr2[]={-8,-4,-6,-8,-9};
        kadanesMaxSubArray(arr2);
    }
    // kadane's Algorithm to calculate max sum of sub array
    public static void kadanesMaxSubArray (int arr[]){
       int currSum=0;
       int maxSum=Integer.MIN_VALUE;
       int counter=0;
       
        

       for(int i=0;i<arr.length;i++){
        currSum=currSum+arr[i];
        if(currSum<0){
            currSum=0;
            counter++;
            
        }
        
        maxSum=Math.max(maxSum, currSum);
       }
       if(counter==arr.length){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max= arr[i];
            }
        }
        maxSum=max;
       }
       System.out.println(maxSum);
     }
}
