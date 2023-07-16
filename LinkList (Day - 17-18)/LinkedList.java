public class LinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }

      
       
    }
      public static Node head;
      public static Node tail;
      public static int size;

      public void addFirst(int data){
        //step1 = create new node
        Node newNode = new Node(data);
        size++;

       //base case - when LinkedList is empty
        if(head==null){
            head=tail=newNode;
            return;
        }
        // step2 = newNode next = head
        newNode.next=head;
        // step3 = newNode become head of LinkedList
        head= newNode;
      }

      public void addLast(int data){

         // step1 :- Create a newNode
        Node newNode = new Node(data);
        size++;

        //base case - when LinkedList is empty
        if(head==null){
            head=tail=newNode;
            return;
        }
        // step2 :- linking tail and new node
        tail.next=newNode;

        // step3:- now newNode become tail
        tail=newNode; 
      }

      public void print(){
        if(head==null){
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp=head;

        while(temp!=null){
            System.out.print(temp.data + "-->");
            temp= temp.next;
        }
        System.out.print("null");
        System.out.println();
       
      }

      public void add(int index,int data){
        // Base case: when index is zero
        if(index==0){
            addFirst(data);
        }

        // zero base indexing follow
        Node newNode = new Node(data);
        size++;
        Node temp= head;
        int i=0;
       
        // iterate till index-1
        // this loop will break when i become equals to index-1;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        // i=index-1; temp -> prev
        newNode.next=temp.next;
        temp.next=newNode;
      }


      // return value of remove element
      public int removeFirst(){
        // base case : when LinkedList is empty
        if(size==0){
            System.out.println("LinkedList is empty");
        }else if(size==1){   // base case : when only one element in linnklist
            int data = head.data; 
            head=tail=null;
            size=0;
            return data;
        }
        int data = head.data;
        head=head.next;
        size--;
        return data;
      }

      public int removeLast(){
        Node temp = head;

        // base case : when LinkedList is empty
        if(size==0){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }else if (size==1){
            int val = head.data;
            head= tail=null;
            size=0;
            return val;
        }
        Node prev = head;
        
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        
        int data = prev.next.data; // tail.data
        prev.next=null;
        tail=prev;
        size--;
        return data;
      }

      public int iterativeSearch(int key){  // O(n)
        Node temp = head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;

        }
        return -1;
      }

      public int helper(Node head,int key){
    
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int index=helper(head.next,key);
        if(index==-1){
            return -1;
        }

        return index+1;

      }

      public int recursiveSearch(int key){
        return helper(head,key);
      }

      public void reverse(){
        Node prev=null;
        Node curr=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
    
            prev=curr;
            curr=next;
    
        }
        head=prev;
       
      }

      public int removeFromEnd(int index){
        Node temp= head;
        int sz=0;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        // corner case : when we want to delete head 
        //  because we are deleting from end when index==size we are actually want to delete head
        System.out.println(sz);
        if(index==sz){
            head=head.next; 
        }
        int i=1;
        Node prev= head;
        while(i<sz-index){
            prev=prev.next;
            i++;
        }
        int data= prev.next.data;
        prev.next=prev.next.next;


        return data;
      }

      public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        Node newNode = head;
        while(fast!=null && fast.next !=null){  // condition for  even and odd LinkedList
            newNode=newNode.next;
            slow=slow.next; //+1
            fast=fast.next.next; //+2
        }
        return slow;
      }

      public boolean isPalindrome(){
        // corner case when LinkedList is empty or have only one element
        if(head==null || head.next==null){
            return true;
        }
        // step 1:- find mide node
        Node midNode = findMid(head);
        
        // step 2:- reverse second half
        Node prev =  null;
        Node curr = midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        // step 3:- equate right and left half
        Node right=prev; // head of second part (reverse part)
        Node left=head;

        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
      }

      public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;

      }

      public static void removeCycle(){
        // detect cycle
        Node slow= head;
        Node fast = head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                cycle=true;
                break;
            }
        }
        if(cycle==false){
            return;
        } 

        // finding meeting point
        slow=head;
        Node prev=null; // last node
        while(slow!=fast){
            prev = fast;
            slow=slow.next;
            fast=fast.next;
        }

        // remove cycle last.next = null
        prev.next=null;
      }

    //   ---------------------------MergeSort On LinkedLIst ---------------------------------------------

    public Node mergeSort( Node head){

        if(head==null || head.next==null){
            return head;
        }
        // finding middle node
        Node slow=head;
        Node fast= head.next;
        while(fast!=null && fast.next!=null){
            if(slow==head){
                break;
            }
            slow=slow.next;
            fast=fast.next.next;
        }

        // dividing linkedlist from mid
        Node mid = slow;
        Node rightHead= mid.next;
        mid.next=null;
        Node left= mergeSort(head);
        Node right= mergeSort(rightHead);

        return merge(left,right);  
    }



    private Node merge(Node left, Node right) {

        Node mergeLL = new Node(-1);
        Node temp=mergeLL;

        while(left!=null && right!=null){
            if(left.data<=right.data){
                temp.next=left;
                left=left.next;
                temp=temp.next;
            }else{
                temp.next=right;
                right=right.next;
                temp=temp.next;
            }
        }

        while(left!=null){
            temp.next=left;
            left=left.next;
            temp=temp.next;
        }
        while(right!=null){
            temp.next=right;
            right=right.next;
            temp=temp.next;
        }

        return mergeLL.next;
    }

    public void zigZag(){
        // find mid node
        Node slow=head;
        Node fast=head.next;

        while(fast!= null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
        }
        Node midNode =  slow;

        // divide the LinkedList from mid
        Node rightHead = midNode.next;
        midNode.next=null;

        // reverse the right half
        Node curr=rightHead;
        Node prev=null;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        Node nextLeft ,nextRight;

        // add in ZigZag manner

        while(left!=null && right!=null){
            nextLeft=left.next;
            left.next=right;
            nextRight=right.next;
            right.next=nextLeft;

            left=nextLeft;
            right=nextRight;
        }
    }

    public static void main(String[] args) {

        //  
       

        // ll.print();
        // ll.add(2, 9);
        // ll.print();
   
        // System.out.println(ll.removeFirst());
        // System.out.println(ll.size);
        // ll.print();
        // System.out.println(ll.removeLast());
        // ll.print();
        // System.out.println(ll.iterativeSearch(3));
        // System.out.println(ll.recursiveSearch(2));

        // ll.reverse();
        // ll.removeFromEnd(3);

        // ll.print();
        // System.out.println(ll.isPalindrome());

        // ----------------------(LinkedList-Part2)-------------------------------//


        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;

        // 1->2->3->1

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        LinkedList ll = new LinkedList();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        System.out.println(ll.isPalindrome());

        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();
        // ll.zigZag();
        ll.print();
        // System.out.println(ll.iterativeSearch(4));
        


     
    }


}
