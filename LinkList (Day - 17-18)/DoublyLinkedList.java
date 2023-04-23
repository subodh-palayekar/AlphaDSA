public class DoublyLinkedList {

    class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;
  
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null ){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;

    }

    // public void addLast(int data){
    //     Node newNode = new Node(data);
    //     size++;
    //     if(head==null){
    //         head=tail=newNode;
    //     }

    //     Node temp=head;

    //     while(temp.next!=null){
    //         temp=temp.next;
    //     }
    //     temp.next=newNode;
    //     newNode.prev=temp;
    //     tail=newNode;
    // }

    public void addLast(int data){
        Node newNode = new Node(data);

        tail.next=newNode;
        newNode.prev = tail;
        tail=newNode;
    }

    public int removeFirst(){
        if(head==null){
            System.out.println("DoublyLinkedList is empty");
            return Integer.MIN_VALUE;
        }
        int data = head.data;
        head=head.next;
        head.prev=null;
        return data;
    }

    public int removeLast(){
        if(head==null){
            System.out.println("DoublyLinkedList is empty");
            return Integer.MIN_VALUE;
        } 
        Node temp = head;
    
        while(temp.next!=null){
            temp=temp.next;

        }
        int data = temp.data;
        Node seclast = temp.prev;
        seclast.next=null;
        return data;
    }

    public void reverse(){
        Node prev=null;
        Node curr=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public void print(){
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.data+" <-> ");
            temp=temp.next;
        }
        System.out.println("null");

    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.addLast(10);


        dll.print();
        // dll.removeFirst();
        // dll.removeLast();
        // System.out.println(dll.removeLast());
        // dll.reverse();
        // dll.print();
    }
}