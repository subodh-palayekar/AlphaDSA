public class AssignmentLinkedList {

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

    public void addFirst(int data){

        Node newNode = new Node(data);

        if(head==null){
            head=tail=newNode;   
            return;    
        }
        newNode.next=head;
        head=newNode;
    }
    public static void intersection(Node head1,Node head2){

        while(head2!=null){

            Node temp = head1;

            while(temp!=null){
                if(temp==head2){
                    System.out.println("I ntersection found At Node "+ temp.data );
                    return;
                } 
                temp=temp.next;
            }
            head2=head2.next;
        }
        System.out.println("no intersection found");
    }

    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
        
    }
 
    // skip m , Delete n
    public void jumpDelete(int m,int n){
         Node mhead=head;
         Node nhead=head;
         Node mTemp ,nTemp;
         int mCounter=1;
         int nCounter=0;

         while(mhead!=null && nhead!=null){
            mhead=mhead.next;
            mCounter++;
            nhead=nhead.next; 
            if(mCounter==m){
                mCounter=0;
                mTemp=mhead;
                while(nCounter<n){
                    if(mhead==null || nhead==null){
                        return;
                    }
                    mhead=mhead.next;
                    nhead=nhead.next; 
                    nCounter++;
                }
                nCounter=0;
                nTemp=nhead;
                mhead=mhead.next;
                nhead=nhead.next;
                mCounter++;
                mTemp.next=nTemp.next;
                nTemp.next=null;
                
            }

         }
    }

    public void skipMdeleteN(int m , int n){
        Node curr =head;
        

        while(curr!=null){
            for(int i=1;i<m && curr!=null ;i++){
                curr=curr.next;
            }
            // curr is at end of m cycle
            if(curr==null){
                return; 
            }
            Node nStart = curr.next;

            for(int i=1;i<=n && nStart!=null;i++){
                nStart=nStart.next;
            }
            // we are now at one node after the end of nCycle or we can say we are at the start of new m cycle
            curr.next=nStart;
            curr=nStart;
            
        }
    }
    public void linkSwap(int firstKey ,int secondKey){
        Node runner=head;
        Node prev=head;
        Node first = head;
        Node second = head;
        Node firstPrev=head;
        Node secondPrev=head;
        Node firstNext,secondNext;

        
        runner=runner.next;
        while(runner!=null){
            
            if(runner.data==firstKey){
                first=runner;
                firstPrev=prev;
            }
            if(runner.data==secondKey){
                second=runner;
                secondPrev=prev;
            }
            runner=runner.next;
            prev=prev.next;
            
        }
        
        firstNext=first.next;
        secondNext=second.next;
        // edge case when our first key is head (head has no prev)
        if(firstPrev==head){
            secondPrev.next=first;
            first.next=secondNext;
            second.next=firstNext;
            head=second;
            return;
        }
        firstPrev.next=second;
        secondPrev.next=first;
        first.next=secondNext;
        second.next=firstNext;

    }

    public void swapByKey(int x,int y){
        if(x==y){
            return;
        }
        Node currX=head;
        Node prevX=null;

        while(currX!=null && currX.data!=x){
            prevX=currX;
            currX=currX.next;
        }

        Node currY=head;
        Node prevY=null;

        while(currY!=null && currY.data!=y){
            prevY=currY;
            currY=currY.next;
        }

        if(currX==null || currY==null){
            return;
        }
        if(prevX!=null){
            prevX.next=currY;
        }
        if(prevY!=null){
            prevY.next=currX;
        }
        Node temp = currX.next;
        currX.next=currY.next;
        currY.next=temp; 

    }

    public void oddEven(){
        Node end=head;
        Node prev=null;

        // travelling till the last node
        while(end.next!=null){
            end=end.next;
        }
        Node newEnd=end;
        Node curr = head;

        // if value is odd
        while(curr.data%2!=0 && curr!=end){
            // puting odd node at end
            newEnd.next=curr;

            curr=curr.next;

            // making next of end node to null
            newEnd.next.next=null;

            // updating value of newEnd
            newEnd=newEnd.next;
        }

        if(curr.data%2==0){
            head=curr;

            while(curr!=end){
                if(curr.data%2==0){
                    prev=curr;
                    curr=curr.next;
                }else{
                    prev.next=curr.next;
                    curr.next=null;
                    newEnd.next=curr;
                    newEnd=curr;
                    curr=prev.next;
                }

            }
        }else{
            prev=curr;
        }
        if(newEnd!=end && end.data%2!=0){
            prev.next=end.next;
            end.next=null;
            newEnd.next=end;
        }
 
    }

    public static Node kSortedList(int k,int n,Node arr[]){

        Node temp = head;

        for(int i=1;i<k;i++){
            temp = mergeSort( arr[0], arr[i]);
        }
        return temp;
    }

    public static Node mergeSort(Node list1,Node list2){
        Node newNode = new Node(-1);
        Node temp=newNode;

        while(list1!=null && list2!=null){
            if(list1.data<=list2.data){
                temp.next=list1;
                temp=temp.next;
                list1=list1.next;
            }else{
                temp.next=list2;
                temp=temp.next;
                list2=list2.next;
            }
        }
        while(list1!=null){
            temp.next=list1;
            temp=temp.next;
            list1=list1.next;
        }
        while(list2!=null){
            temp.next=list2;
            temp=temp.next;
            list2=list2.next;
        }

        return newNode.next;
    }


    

    
    public static void main(String[] args) {

        // head = new Node(1);
        // head.next= new Node(2);
        // head.next.next= new Node(3);
        // Node intersection = new Node(6);
        
        // head.next.next.next = intersection;
        // intersection.next = new Node(50);
        // intersection.next.next = new Node(100);

        // Node head2 = new Node(4);
        // head2.next= new Node(5);
        // head2.next.next = intersection;
      
        // intersection(head, head2);
        
        AssignmentLinkedList ll = new AssignmentLinkedList();

        ll.addFirst(12);
        ll.addFirst(11);
        ll.addFirst(10);
        ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();
        // ll.jumpDelete(2, 3);
        ll.skipMdeleteN(2,3);
        // ll.linkSwap(4, 10);
        // ll.oddEven();
        ll.print();

        // ------------------------------------------------------------------
        // int k=3;
        // int n=4;
        // Node arr[] = new Node[k];
        // arr[0] = new Node(1);
        // arr[0].next = new Node(3);
        // arr[0].next.next = new Node(5);
        // arr[0].next.next.next = new Node(7);

        // arr[1] = new Node(2);
        // arr[1].next = new Node(4);
        // arr[1].next.next = new Node(6);
        // arr[1].next.next.next = new Node(8);

        // arr[2] = new Node(0);
        // arr[2].next = new Node(9);
        // arr[2].next.next = new Node(10);
        // arr[2].next.next.next = new Node(11);
        // Node head = kSortedList(k, n, arr);

        // while(head!=null){
        //     System.out.print(head.data+" ");
        //     head=head.next;
        // }
        // System.out.println();

      



    }


}
