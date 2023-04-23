import java.util.*;
public class ContainerWater {

    // Array/ArrayList is given find maximum water store in max-size container
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(containerMostWater(height));

        System.out.println(containerMaxWater(height));
    }
   
    // BruteForce O(n^2)
    public static int containerMostWater(ArrayList<Integer> list){
        int maxWater=0;
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                int width=j-i;
                int height=Math.min(list.get(i), list.get(j));
                maxWater=Math.max(maxWater, height*width);

            }
        }
        return maxWater;
    }

    // Optimized approach O(n) two Pointer approach
    public static int containerMaxWater(ArrayList<Integer> list){
        int left=0;
        int right=list.size()-1;
        int maxWater=0;

        while(left<right){
            if(list.get(left)>list.get(right)){
                right--;
            }else{
                left++;
            }
            int width = right-left;
            int height = Math.min(list.get(left),list.get(right));
            maxWater=Math.max(maxWater, height*width);

        }
        return maxWater;
    }

}
