import java.util.ArrayList;

public class StackArraylist{
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty(){
            return list.size()==0;
        }

        public void push(int data){
            list.add(data);
        }   

        public int pop(){
            int data = list.get(list.size()-1);
            list.remove(list.size()-1);
            return data;
        }

        public static int peek(){
            return list.get(list.size()-1);
        }

    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.pop() + " ");
        }

    }
}