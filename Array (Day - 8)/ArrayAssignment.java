import java.util.*;

public class ArrayAssignment {
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,1};
        int arr2[] = {4,5,6,7,0,1,2};
        int price[]={7, 6, 4, 3, 1};
        int height[]={0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};
        int nums[]={-1, 0,  1, 2, -1, -4};
        // System.out.println( repeatValue(arr));
        System.out.println(pivotSearch(arr2, 2));
        // System.out.println(StockProfit(price));
        // System.out.println(trapWater(height));
        // System.out.println(trapWater(nums));

        

    }

    /*  Question 1:Given an integer array nums,return true
     if any value appears at least twice in the array, 
     and return false if every element is distinct*/
    public static boolean repeatValue(int arr[]){


      for(int i=0;i<arr.length;i++){
        int count=0;
        for(int j=0;j<arr.length;j++){
            if(arr[i]==arr[j]){
                count++;
            }
            
        }
        if(count>=2){
          return true;
        }
        
      }
      return false;
    }

    // Assignment answer O(n^2)
    public  static boolean containsDuplicate(int[] nums){
        for(int i=0; i<nums.length-1 ; i++) {
         for(int j=i+1; j<nums.length ; j++ ) {
             if( nums[i] == nums[j] ) { 
                return true ; 
              }
            }
        }
          return false;
    }
    // Assignment answer O(n)
    public boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
         for(int i=0; i<nums.length; i++) { 
            if(set.contains(nums[i])) { 
                return true; 
            } else { 
                set.add(nums[i]); 
            }
         } 
         return false; 
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

     
    //  ---------------------------------------------------------------------------------------------------------------------

    // Assignment method
     
    //smallest element index
    public  static int minSearch(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(mid > 0 && nums[mid-1] > nums[mid]){
                return mid;
            }
            else if(nums[left] <= nums[mid] && nums[mid] > nums[right]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
       
    public int search(int[] nums, int target) {
        //min will have index of minimum element of nums
        int min = minSearch(nums);
        //find in sorted left
        if(nums[min] <= target && target <= nums[nums.length-1]){
            return search(nums,min,nums.length-1,target);
        }
        //find in sorted right
        else{
            return search(nums,0,min,target);
        }
        }
        //binary search to find target in left to right boundary
        public int search(int[] nums,int left,int right,int target){
        int l = left;
        int r = right;
        // System.out.println(left+" "+right);
        while(l <= r){
        int mid = l + (r - l)/2;
        if(nums[mid] == target){
        return mid;
        }
        else if(nums[mid] > target){
        r = mid-1;
        }
        else{
        l = mid+1;
        }
        }
        return -1;
        }

    //  ---------------------------------------------------------------------------------------------------------------------

    /* Question:3 Stocks profit
      Buy on day 2 (price = 1) and sell on day 5 (price = 6),
       profit = 6-1 = 5. Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     */

     public static int StockProfit(int arr[]){
        int n= arr.length;
        int maxProfit=0;
        int buyPrice=arr[0];
        for(int i=1;i<n;i++){
            int sellPrice=arr[i];
            int profit = sellPrice-buyPrice;
            if(profit<0){
                buyPrice=sellPrice; 
            }
            maxProfit=Math.max(maxProfit, profit);
        }
        return maxProfit;
     }


     /* 
    Question 4 : Given n non-negative integers representing an 
    elevation map where the width of each bar is 1, compute how much 
    water it can trap after raining.
     */
    
     public  static int trapWater(int arr[]){
        int n= arr.length;
        int leftBoundary[]= new int [n];
        int rightBoundary[]= new int [n];
       
        leftBoundary[0]=arr[0];
        rightBoundary[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            leftBoundary[i]=Math.max(arr[i], leftBoundary[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rightBoundary[i]=Math.max(arr[i], rightBoundary[i+1]);
        }
        int totalWater=0;
        for(int i=0;i<n;i++){
            int barHeight=Math.min(leftBoundary[i], rightBoundary[i]);
            int waterTraped = barHeight-arr[i];
            if(waterTraped<0){
                waterTraped=0;
            }
            totalWater+=waterTraped;
        }
        return totalWater;
     }

     /* Question 5 : 
      Given an integer array nums, return all the triplets [nums[i], nums[j],
      nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
      Notice that the solution set must not contain duplicate triplets
      */


      public static void triplet(int arr[]){
        int n=arr.length;
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if( arr[i]+arr[j]+arr[k]==0){
                        System.out.println("["+i+","+j+","+k+"]");
                    }
                }
                System.out.println();
            }
         }
      }

}
