import java.util.*;

public class CollectionDeque {

    static class stack{
        static Deque<Integer> deque = new LinkedList<>();


        public boolean isEmpty(){
            return deque.isEmpty();
        }

        public  void push(int data){
            deque.addLast(data);
        }
        public  int pop(){
            if(deque.isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            int data = deque.removeLast();
            return data;
        }

        public  int peek(){
            if(deque.isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            return deque.getLast();
        }
    }

    static class Queue{

        static Deque<Integer> deque = new LinkedList<>();

        public boolean isEmpty(){
            return deque.isEmpty();
        }

        public void add(int data){
            deque.addLast(data);
        }

        public int remove(){
            if(deque.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return deque.removeFirst();
        }

        public int peek(){
            if(deque.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return deque.peekFirst();
        }
    }



    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();

        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(10);
        dq.addLast(20);
        dq.add(3); // add element at the rear( i.e last)

        // System.out.println(dq.getFirst());

        // System.out.println(dq.getLast());

        // System.out.println(dq);

        stack s = new stack();

        s.push(1);
        s.push(2);
        s.push(3);

        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }


        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
      
    }
}
