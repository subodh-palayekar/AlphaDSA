import java.util.*;

public class CollectionHashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();

        hm.put("Tea", 10);
        hm.put("Samosa", 15);
        hm.put("vadapav", 15);
        hm.put("coffee", 10);
        hm.put("Biscuits", 5);
        hm.put("Tea", 30);

        System.out.println(hm);

        // Get O(1)
        // int price = hm.get("Tea");
        // System.out.println(price);

        // containsKey - O(1)
        // System.out.println(hm.containsKey("vadapav"));

        // Remove - O(1)
        // System.out.println(hm.remove("Samosa"));
        // System.out.println(hm);

        // Size - O(1)
        // System.out.println(hm.size());

        // Is empty
        // hm.clear();
        // System.out.println(hm.isEmpty());


        // Iterate
        // Set<String> keys = hm.keySet();
        // System.out.println(keys);

        // for(String key : keys){
        //     System.out.println("key = "+key+","+"values = "+hm.get(key));
        // }


        // ------------------------------------------------------------------------------------------------------
        // keys are insertion ordered 
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();

        lhm.put("logan", 1);
        lhm.put("mark", 2);
        lhm.put("Mike",3);

        // System.out.println(lhm);

        // ------------------------------------------------------------------------------------------------------
        // keys are sorted  put,get,remove are O(logn)
        // implemented using Red Black tree

        TreeMap<String,Integer> thm = new TreeMap<>();

        thm.put("apple", 10);
        thm.put("mango",20);
        thm.put("banana", 5);
        thm.put("oranges",30);

        System.out.println(thm);

    }
 
}
