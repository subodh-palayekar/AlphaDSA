import java.util.PriorityQueue;

public  class PathWithMinEffort {

    static class Point implements Comparable<Point>{
        int data;
        int i;
        int j;
        int path[][];

        Point(int i,int j,int path[][]){
            this.i=i;
            this.j=j;
            this.path=path;
            this.data=path[i][j];
        }
        @Override
        public int compareTo(Point p2){
            return this.data-p2.data;
        }
        
    }
    

    static int minPath;

    public static void minEffortPath(int path[][],Point runner,PriorityQueue<Point> pq){

        if(runner.i==path.length-1 && runner.j==path.length-1){
            minPath+=runner.data;
            return;
        }
        // move up
        if(runner.i>0){
            pq.add(new Point(runner.i-1,runner.j , path));
        }

        // move right
        if(runner.j<path.length-1.){
            pq.add(new Point(runner.i, runner.j+1, path));
        }

        // move down
        if(runner.i<path.length-1){
            pq.add(new Point(runner.i+1, runner.j, path));
        }

        runner = pq.remove();
        minPath+=runner.data;
        while(!pq.isEmpty()){
            pq.remove();
        }
        minEffortPath(path, runner, pq);

    }
    public static void main(String[] args) {
        int path[][]={{31,100,65,12,18},
        {10,13,47,157,6},
        {100,113,174,11,33},
        {88,124,41,20,140},
        {99,32,111,41,20}};
        Point runner = new Point(0, 0, path);
        minPath = runner.data;

        PriorityQueue<Point> pq= new PriorityQueue<>();

        minEffortPath(path, runner, pq);


    }
    
}
