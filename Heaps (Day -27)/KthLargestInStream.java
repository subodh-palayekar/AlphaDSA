import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestInStream{

    static class KthLargest  {
        int k;
        int nums[];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        KthLargest(int k,int []nums){
            this.k=k;
            for(int i=0;i<nums.length;i++){
                pq.add(nums[i]);

            }
            while(pq.size()>k){
               pq.remove();
            }
        }

        public  int add(int val){
   
            if(pq.peek()<val){
                pq.remove();
                pq.add(val);
            }
            return pq.peek();
        }


    }
    public static void main(String[] args) {
        
    }
}