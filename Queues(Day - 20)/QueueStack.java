import java.util.*;

public class QueueStack {
    // Queue using two stack  push O(n)  remove O(1) peek O(1)

     static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public static int remove(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return s1.pop();
        }

        public static int peek(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return s1.peek();
        }
     }

     static class QueueB{
        static Stack<Integer> s3 = new Stack<>();
        static Stack<Integer> s4 = new Stack<>();

        public static boolean isEmpty(){
            return s3.isEmpty();
        }

        public static void add(int data){
            s3.push(data);
        }

        public static int remove(){

            if(s3.isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            while(!s3.isEmpty()){
                s4.push(s3.pop());
            }
             int data = s4.pop();
            while(!s4.isEmpty()){
                s3.push(s4.pop());
            }
            return data;
        }

        public static int peek(){
            if(s3.isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            while(!s3.isEmpty()){
                s4.push(s3.pop());
            }
             int data = s4.peek();
            while(!s4.isEmpty()){
                s3.push(s4.pop());
            }
            return data;
        }
     }


    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
 // -----------------------------------------------------------------------------
        
        QueueB q2 = new QueueB();

        q2.add(1);
        q2.add(2);
        q2.add(3);

        while(!q2.isEmpty()){
            System.out.println(q2.peek());
            q2.remove();
        }
    }
}
