import java.util.*;

public class MajorityElement{
    public static void main(String[] args) {
        // int nums[] = {1,3,2,5,1,3,1,5,1};
        int nums[] = {1,2};

        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            // if(hm.containsKey(curr)){
            //     int freq = hm.get(curr);
            //     freq=freq+1;
            //     hm.put(curr, freq);
            // }else{
            //     hm.put(curr, 1);
            // }

            hm.put(curr, hm.getOrDefault(curr, 0)+1);

        }

        for(int key :  hm.keySet()){
            if(hm.get(key)>nums.length/3){
                System.out.print(key+" ");
            }
        }

    }
}