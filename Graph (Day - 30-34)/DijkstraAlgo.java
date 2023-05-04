import java.util.*;

public class DijkstraAlgo {

    static class Edge{
        int src; //source
        int dest; // destination
        int wt; // weight

        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }

    }

    public static void buildGraph (ArrayList<Edge> graph[]){
    
    /*             (5)
                    0 ------> 2
                   ^ ^       /
                  /   \     /
                 /     \   v
                1        3
                 
        */ 

      

        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();  // intializing array with empty arraylist
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // 0 vertex
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        // 2 vertex
        graph[2].add(new Edge(2, 4, 3));

        // 3 vertex
        graph[3].add(new Edge(3 , 5, 1));

        // 4 vertex
        graph[4].add(new Edge(4 , 3, 2));
        graph[4].add(new Edge(4 , 5, 3));

      
    }
    static class Point implements Comparable<Point>{
        int node;
        int path;

        Point(int node,int path){
            this.node=node;
            this.path=path;
        }
        @Override
        public int compareTo(Point p2){
            return this.path-p2.path;
        }
    }

    // Shortest paths from the source to all vertices
    public static void shortestPath(ArrayList<Edge> graph[],int src){

        int distance[] = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(i!=src){
                distance[i]=Integer.MAX_VALUE;
            }
        }
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point (src,0));

        while(!pq.isEmpty()){
            Point curr = pq.remove();
            if(!visited[curr.node]){

                visited[curr.node]=true;
                // neighbours
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    int u =e.src;
                    int v=e.dest;
                    int wt = e.wt;
    
                    if(distance[u]+wt <distance[v]){   //update distance of src to v (instead of distance[u] you can use curr.path)
                        distance[v]=distance[u]+wt;
                        pq.add(new Point(v, distance[v]));
    
                    }
                }
            }

        }

        // print all source to vertices shortest dist
        for(int i=0;i<distance.length;i++){
            System.out.println(distance[i]+" ");
        }
        System.out.println();
        

    }




    public static void main(String args[]){

        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        buildGraph(graph);

        shortestPath(graph, 0); // O(T.C)  V+ElogV
    }
}
