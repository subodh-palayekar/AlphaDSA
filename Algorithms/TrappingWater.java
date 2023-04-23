import java.util.Arrays;

public class TrappingWater {
    /*Question: Given n non-negative integers representing
      an elevation map where the width of each bar is 1,compute 
      how much water it can trap after raining.
    */




    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};
        
        trapWater(height);
    }

    public static void trapWater(int arr[]){
        int n= arr.length;
        int leftArr[] = new int[n];
        int rightArr[] = new int[n];
        leftArr[0] = arr[0];
        rightArr[n-1]=arr[n-1];
        int water=0;
        int finalwater=0;
    
        for(int i=1;i<n;i++){
            leftArr[i]=Math.max(arr[i], leftArr[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rightArr[i]=Math.max(arr[i], rightArr[i+1]);
        }
        for(int i=0;i<n;i++){
            int currentBar = arr[i];
            int barHeight=Math.min(leftArr[i],rightArr[i]);
            water=(barHeight-currentBar);  // if width is given then water=(barHeight-arr[i])*width
            if(water<0){
                water=0;
            }
            finalwater=finalwater+water;
            
        }
        // System.out.println(Arrays.toString(leftArr));
        // System.out.println(Arrays.toString(rightArr));
        System.out.println(finalwater);

    }
}
