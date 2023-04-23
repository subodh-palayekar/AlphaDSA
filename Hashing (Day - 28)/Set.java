import java.util.*;

public class Set{
    
    public static void main (String args[]){

        // unordered set
        HashSet<Integer> set = new HashSet<>();

        set.add(10);
        set.add(3);
        set.add(5);
        set.add(3);
        set.add(1);


        // System.out.println(set);
        // System.out.println(set.remove(3));
        // System.out.println(set.contains(3));
        
        // set.clear(); 
        // System.out.println(set.size());
        // System.out.println(set.isEmpty());


        // iteration on HashSet

        // Iterator it = set.iterator();

        // while(it.hasNext()){
        //     System.out.print(it.next()+" ");
        // }

        // for(Integer num : set){
        //     System.out.print(num+" ");
        // }



        // ordered set usign DLL
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();

        lhs.add(2);
        lhs.add(3);
        lhs.add(32);
        lhs.add(40);

        // System.out.println(lhs);


        // sorted in ascending order
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(40);
        ts.add(20);
        ts.add(10);
        ts.add(2);

        System.out.println(ts);


    }
}