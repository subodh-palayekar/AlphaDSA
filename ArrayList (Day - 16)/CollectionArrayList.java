import java.util.*;
public class CollectionArrayList{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(5);
        list.remove(2);
        list.add(2,10);
        // System.out.println(list.get(0));
        list.set(0, 20);
        // System.out.println(list.contains(20));

        // System.out.println(list);

        // for(int i=0;i<list.size();i++){
        //     System.out.print(list.get(i)+" ");
        // }


        // print Reverse array


        // for(int i=list.size()-1;i>=0;i--){
        //     System.out.print(list.get(i)+" ");
        // }

        // Maximum Element of array
        // int max = Integer.MIN_VALUE;

        //  for(int i=0;i<list.size();i++){
        //   max = Math.max(max, list.get(i));
        // }

        // System.out.println(max);
        swap(list, 0, 5);
        Collections.sort(list);
        // System.out.println(list);


        Collections.sort(list,Collections.reverseOrder());
        // System.out.println(list);

        // ---------------------------------------------------------
        // 2D ArrayList

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        ArrayList<Integer> childList1 = new ArrayList<>();
        ArrayList<Integer> childList2 = new ArrayList<>();
        ArrayList<Integer> childList3 = new ArrayList<>();
        ArrayList<Integer> childList4 = new ArrayList<>();

        for(int i=1 ; i<=5 ;i++){
            childList1.add(i);
            childList2.add(i*2);
            childList3.add(i*3);
            childList4.add(i*4);
        }
        mainList.add(childList1);
        mainList.add(childList2);
        mainList.add(childList3);
        mainList.add(childList4);

        // System.out.println(mainList);


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
        
        // System.out.println(containerMostWater(height));
        // System.out.println(containerMaxWater(height));

        ArrayList<Integer> pair = new ArrayList<>();
        pair.add(0);
        pair.add(2);
        pair.add(4);
        pair.add(7);
        pair.add(9);
        pair.add(12);
        System.out.println(pairSum(pair, 70));
        System.out.println(pairSumPointer(pair, 7));

        ArrayList<Integer> rotatedPair = new ArrayList<>();

        rotatedPair.add(11);
        rotatedPair.add(15);
        rotatedPair.add(6);
        rotatedPair.add(8);
        rotatedPair.add(9);
        rotatedPair.add(10);
        

        
      System.out.println(pairSumRotated(rotatedPair, 16));


    }
    public static void swap (ArrayList<Integer> list , int first,int second){
        int temp = list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }


    // Container with most water

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


    // Pair Sum 
    // BruteForce O(n^2)
    public static boolean pairSum(ArrayList<Integer> list , int target){

        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(list.get(i)+list.get(j)==target){
                    return true;
                   
                }
            }
        }
        return false;
    }

    // Optimized approach O(n) two pointer approach 
    // preRequisite Sorted array

    public static boolean pairSumPointer(ArrayList<Integer> list , int target){
        int left=0;
        int right=list.size()-1;

        while(left<right){
            int sum = list.get(left)+list.get(right);
            if(sum==target){
                return true;
            }
            if(sum<target){
                left++;
            }else{
                right--;
            }

        }
        return false;
    }

    public static boolean pairSumRotated(ArrayList<Integer> list , int target){
        int n= list.size();
        int breakingPoint=-1;
        for(int i=0;i<n;i++){
           if(list.get(i)>list.get(i+1)){
                breakingPoint=i;
                break;
           }

        }
        int left=breakingPoint+1;
        int right=breakingPoint;
        
        while(left!=right){
            int sum=list.get(left)+list.get(right);
            if(sum==target){
                return true;
            }
            if(sum<target){
                left=(left+1)%n;
            }else{
                right=(right+n-1)%n;
            }
        }
        return false;
    }

}