import java.util.*;

public class CollectionQueue {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        // Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);


        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        // System.out.println(q);

        String str = "aabccxb";
  
        // firstNonRepeating(str);

        interleave(q);

        reverse(q);

        System.err.println(q);


    }

    public static void firstNonRepeating(String str){
        Queue<Character> q = new LinkedList<>();

        int freq[] = new int[26];

        for(int i=0;i<str.length();i++){

            char curr = str.charAt(i);

            freq[curr-'a']++;
            q.add(curr);

            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
             System.out.print(-1+" ");
            }else{
               System.out.print(q.peek()+" ");
            }

        }

        System.out.println();
    }

    public static void interleave ( Queue<Integer> q){
        int size = q.size();

        Queue<Integer> firstHalf = new LinkedList<>();

        for(int i=0;i<size/2;i++){
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
        // System.out.println(q);
    }

    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }
        // System.out.println(q);
    }

}
