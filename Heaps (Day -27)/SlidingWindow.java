import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindow {
    static class Point implements Comparable<Point>{
        int data;
        int idx;

        public Point(int data,int idx){
            this.data=data;
            this.idx=idx;
        }
        @Override
        public int compareTo(Point p2){
          return p2.data - this.data;
        }

    }
    public static void main(String[] args) {

        int arr[] ={1,2,3,4,5,6,7,8,9,10};
        int k=3;
        int res[] = new int[arr.length-k+1];

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i=0;i<k;i++){
            pq.add(new Point(arr[i], i));
        }

        res[0]=pq.remove().data;

        for(int i=k;i<arr.length;i++){
            pq.add(new Point(arr[i],i));

            while(pq.peek().idx>0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }

            res[i-k+1]=pq.peek().data;

        }

        System.out.println(Arrays.toString(res));


    }


}
