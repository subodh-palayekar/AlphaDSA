import java.util.LinkedList;
public class CollectionsLinkedlist {
    public static void main(String[] args) {
        
        LinkedList <Integer> ll = new LinkedList<>();

        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(5);
        ll.addLast(6);

        System.out.println(ll);

        ll.removeFirst();
        ll.removeLast();
        
        System.out.println(ll);
    }


}
