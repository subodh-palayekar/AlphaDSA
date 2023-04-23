public class CircularQueue {

    static class Queue{
        static int arr [];
        static int size;
        static int rear;
        static int front;

        Queue(int n){
            arr = new int[n];
            size=n;
            rear=-1;
            front=-1;
        }

        public   boolean isEmpty(){
            return rear==-1 && front==-1;
        }

        public  boolean isFull(){
            return (rear+1)%size ==front;
        }

        public void add(int data){ //O(1)
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            //add 1st element
            if(front == -1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=data;
        }

        public  int remove(){ //O(1)
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            int data = arr[front];
           
            // last element delete
            if(rear==front){
                rear = front = -1;
            }else{
                front = (front +1)%size;
            }
            return data;
        }

        public  int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(3);
         
        q.add(1);
        q.add(2);
        q.add(3);

        // System.out.println(q.remove());
        // System.err.println(q.remove());

        q.remove();
        q.remove();
        q.add(10);
        q.add(20);

        while(!q.isEmpty()){
           System.out.println(q.remove());
        }
    }
}
