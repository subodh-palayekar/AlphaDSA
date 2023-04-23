

public class StackLinkedList {
   // implementation of stack using linkedlist
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;


    static class Stack{
        public void push(int data){
            Node newNode= new Node(data);

            if(isEmpty()){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
    
        public int pop(){

            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int data=head.data;
            head=head.next;
            return  data;
        }
    
        public int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }

        public boolean isEmpty(){
            return head==null;
        }
    }
   

   


    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
        
        
    }
}
