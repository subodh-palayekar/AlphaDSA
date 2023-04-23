import java.util.*;

public class StackQueue {
    // Creating stack using  two Queue

    // method1 push O(1)  pop O(n) peek O(n)
    static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data); 
            }else{
                q2.add(data);
            }
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println(" Stack is empty");
                return -1;
            }
            int top=-1;
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){

                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            } else{
                while(!q2.isEmpty()){

                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static  int peek(){

            if(isEmpty()){
                System.out.println(" Stack is empty");
                return -1;
            } 
            int top=-1;
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    
                    q2.add(top);
                }
            }else{
                
                while(!q2.isEmpty()){
                    top = q2.remove();
                    
                    q1.add(top);
                }
            }
            return top;
        }
        // ---------------------------------------------------------------------------------------------------
        // Method 2 push O(n)  peek O(1)  pop O(1)


        public static void push2(int data){

            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
            if(q1.isEmpty()){
                q1.add(data);
            }
            while(!q2.isEmpty()){
                q1.add(q2.remove()); 
            }
        }


        public static int pop2(){
            if(q1.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return q1.remove();
        }

        public static int peek2(){
            if(q1.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }

            return q1.peek();
        }
    }

// ----------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Stack s = new Stack();

        // s.push(1);
        s.push2(2);
        s.push2(3);
        s.push2(10);

        while(!s.isEmpty()){
            System.out.println(s.peek2());
            s.pop2();
        }
    }
}
