import java.util.*;

// Pair Sum :- find target is exist or not as a sum of element in Array/ArrayList
public class PairSum{
    public static void main(String[] args) {
        

        ArrayList<Integer> pair = new ArrayList<>();
        pair.add(0);
        pair.add(2);
        pair.add(4);
        pair.add(7);
        pair.add(9);
        pair.add(12);

        System.out.println(pairSum(pair, 70));
        System.out.println(pairSumPointer(pair, 7));


        // ArrayList is sorted and rotated
        ArrayList<Integer> rotatedPair = new ArrayList<>();

        rotatedPair.add(11);
        rotatedPair.add(15);
        rotatedPair.add(6);
        rotatedPair.add(8);
        rotatedPair.add(9);
        rotatedPair.add(10);

        System.out.println(pairSumRotated(rotatedPair, 16));


    }
    
    // BruteForce O(n^2) :- This approach can be for sorted or unsorted Array/ArrayList
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
    // PreRequisite Sorted array in ascending order

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


    // Pair Sum 2 : - Array is sorted and rotated O(n)

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