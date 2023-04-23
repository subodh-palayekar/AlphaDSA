import java.util.PriorityQueue;

public class ConnectNRopes {

    // Given are N ropes of different lengths, the task is to connect these ropes into one rope with minimum cost,such that the cost to connect two ropes is equal to the sum of their lenghts.
    public static void main(String[] args) {
        int arr[] = {2,3,3,4,6};
        System.out.println(connectRopes(arr));

    }

    public static int connectRopes(int arr[]){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : arr){
            pq.add(i);
        }
        int sum=0;

        while(pq.size()>1){
            int min1=pq.remove();
            int min2=pq.remove();
            
           sum += min1+min2;
            pq.add(min1+min2);
        }
        return sum;
    }
}
