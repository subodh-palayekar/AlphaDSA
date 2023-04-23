import java.util.*;

public class HashingAssignment {
    public static void main(String[] args) {
        int sum[] = {2,7,11,15};
        // int sum[] = {3,2,4};
        int target = 9;

        // twoSum(sum, target);

        String s = "abbbb";
    
        System.out.println(sortByFreq(s));
        
    }


    public static void twoSum(int arr[],int target){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }

        for(int key : map.keySet()){
            if(key==target){
                System.out.println(map.get(key));
                return;
            }
            if(map.containsKey(target-key)){
                System.out.print(map.get(key)+" ");
                System.out.print(map.get(target-key)+" ");
                return;
            }
        }
        System.out.println("No sum exist");
    }

    public static String sortByFreq(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        // sorting in descending order
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()==b.getValue() ? a.getKey()-b.getKey() : b.getValue()-a.getValue());

        for(Map.Entry<Character,Integer> e : map.entrySet()){
            pq.add(e);
        }

        StringBuilder res = new StringBuilder();
        while(pq.size()!=0){
            char ch = pq.remove().getKey();
            int count = map.get(ch);

            while(count!=0){
                res.append(ch);
                count--;
            }
        }

        return res.toString();
        
    }
}
