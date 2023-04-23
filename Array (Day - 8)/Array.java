import java.util.*;

public class Array{
    public static void main(String[] args) {
        int [] arr ={2,4,6,8,1};

         // Creating an Array
         int marks[] = new int[50];
         int numbers[]={3,2,4,5,1};
         String fruits[]={"apple","mango","orange"};
        
        Scanner sc = new Scanner(System.in);

        // Input value to the array
        // marks[0] = sc.nextInt(); //phy
        // marks[1] = sc.nextInt(); //chem
        // marks[2] = sc.nextInt(); //math

        // //Output of array
        // System.out.println("phy " + marks[0]);
        // System.out.println("chem " + marks[1]);
        // System.out.println("math " + marks[2]);
        
        // // update array value
        // marks[1] = 99;
        // System.out.println("math " + marks[1]);

        // printSubArray(arr);
        // maxAndMinSubArray(arr);
        largeAndSmall(arr);





    }
    public static void largeAndSmall(int arr[]){
        int n= arr.length;
        int large = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>large){
                large=arr[i];
            }
            if(arr[i]<small){
                small=arr[i];
            }
        }
        System.out.println( "Max Num is " + large);
        System.out.println( "Min Num is " + small);

    }

    

    public static void printSubArray(int [] arr){

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
                System.out.print(arr[k]+" ");
                sum = sum + arr[k];
            }
            if(maxSum<sum){
                maxSum=sum;
            }
           
            if(minSum>=sum){
                minSum=sum;
            }
            
            System.out.println();
          }
          System.out.println();
       }
       System.out.println("max "+ maxSum);
       System.out.println("min "+ minSum);

    }
    
    // BruteForce Method TimeComplexity o(n^3) 
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
}