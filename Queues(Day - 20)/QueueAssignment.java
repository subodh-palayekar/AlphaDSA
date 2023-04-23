import java.util.*;

public class QueueAssignment {
    public static void main(String[] args) {

        // generateBinary(10);

        int arr[] = {1,2,3 };
    //    System.out.println(ropesMinCost(arr));
        // System.out.println(minCostRope(arr));

       Queue<Integer> q = new LinkedList<>();

       q.add(1);
       q.add(2);
       q.add(3);
       q.add(4);
       q.add(5);
       q.add(6);
       q.add(7);
       q.add(8);
       q.add(9);
       q.add(10);

       int k=3;

    //    kElementReverse(q, k);
    //    System.out.println(q);

       int arr2[] = {1,2,3,1,4,5,2,3,6};
    
    //    maxSubarray(arr2, 3);
    binaryNumbers(10);

    }
    

    // Generate Binary Numbers O(n^2)

    public static void generateBinary(int n){
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=n;i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            int curr = q.remove();

            if(curr==1){
                System.out.print(1 + " ");
            }else{
                System.out.print(binary(curr)+" ");
            }
        }
        System.out.println();

    }

    private static int binary(int curr) {
        Stack<Integer> s = new Stack<>();
        while(curr>0){
            s.add(curr%2);
            curr=curr/2;
        }
        int ans=0;
        while(!s.isEmpty()){
            ans = ans*10 + s.pop();
        }
        return ans;
    }


    // Generate n binary Numbers using queue O(n)
    
    public static void binaryNumbers(int n){
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n>0){
            String s1=q.remove();
            System.out.print(s1+" ");
            q.add(s1+"0");
            q.add(s1+"1");
            n--;
        } 
    }
    
    // Connect n ropes with minimum cost  O(n)
    
    // approach 1 - O(nlogn)
    public static int ropesMinCost(int arr[]){
        Queue<Integer> q  = new LinkedList<>();

        Arrays.sort(arr);
        int cost=arr[0] + arr[1];
        q.add(cost);

        for(int i=2;i<arr.length;i++){
            cost = cost+arr[i];
            q.add(cost);
        }
        cost=0;
        while(!q.isEmpty()){
            cost=cost + q.remove();
        }

        return cost;
    }

    // approach 2

    public static int minCostRope(int arr[]){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }

        int ans=0;

        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            int sum = first+second;
            ans+=sum;
            pq.add(sum);
        }
        return ans;
    }


    // Reversing the first k elements of a Queue
    public static void kElementReverse(Queue<Integer> q ,int k){
        int size=q.size();

        Stack<Integer> s = new Stack<>();

        for(int i=1;i<=k;i++){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }

        for(int i=k+1;i<=size;i++){
            q.add(q.remove());
        }
    }

    // maximum of all subarrays of size k
    public static void maxSubarray(int arr[] , int k){
        int size = arr.length;

        for(int i=0;i<=size-k;i++){
            int max = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                max = Math.max(max, arr[j]);
            }
            System.out.print(max+" "); 
        }
    }





}
