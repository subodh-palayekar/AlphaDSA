public class SubArrays {
    public static void main(String[] args) {
        int arr[]={2,4,6,8,9};
        // printSubArray(arr);
        // maxAndMinSubArray(arr);
        // maxSubArrayPrefix(arr);
        kadanesMaxSubArray(arr);
    }


    public static void printSubArray(int [] arr){

        int n= arr.length;
       
        for(int i=0 ; i<n ; i++){
           int start = i;
 
           for(int j=i;j<n;j++){
             int last = j;
           
             for(int k=start;k<=last;k++){
                 System.out.print(arr[k]+" ");
                 
             }
             
             System.out.println();
           }
           System.out.println();
        }
 
     }
     
     // BruteForce Method TimeComplexity O(n^3) 
     public static void maxAndMinSubArray(int [] arr){
         int n= arr.length;
         int sum=0;
         int maxSum=Integer.MIN_VALUE;
         int minSum = Integer.MAX_VALUE;
  
         for(int i=0 ; i<n ; i++){
            int start = i;
  
            for(int j=i;j<n;j++){
              int last = j;
              sum=0;
              for(int k=start;k<=last;k++){
                 
                  sum = sum + arr[k];
              }
              if(maxSum<sum){
                  maxSum=sum;
              }
             
              if(minSum>=sum){
                  minSum=sum;
              }
              
            }
         }
         System.out.println("max "+ maxSum);
         System.out.println("min "+ minSum);
     }

     // MaxSubArray Prefix Array

     public static void maxSubArrayPrefix(int arr[]){
     int n = arr.length;
     int prefixArr[]= new int[n];
     int maxSum = Integer.MIN_VALUE;
     int currSum=0;

     prefixArr[0]=arr[0];

     // creating prefix Array
     for(int i=1;i<n;i++){
        prefixArr[i]=arr[i]+prefixArr[i-1];
     }

     for(int i=0;i<n;i++){
        int start=i;
        for(int j=i;j<n;j++){
            int end =j;
             currSum = start==0 ? prefixArr[end]: (prefixArr[end]-prefixArr[start-1]);
            if(maxSum<currSum){
                maxSum=currSum;
            }
        }
     }
     System.out.println(maxSum);


     }

     // kadane's Algorithm to calculate max sum of sub array
     public static void kadanesMaxSubArray (int arr[]){
        int currSum=0;
        int maxSum=0;

        for(int i=0;i<arr.length;i++){
            currSum=currSum+ arr[i];
            if(currSum<0){
                currSum=0;
            }
            maxSum =Math.max(maxSum, currSum);
            
        }
        System.out.println(maxSum);
     }
}