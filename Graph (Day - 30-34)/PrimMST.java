import java.util.*;
public class PrimMST{

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
                         0 ------ 1
                                 / \
                            (1) /   \ (3)
                               /     \
                              2 ----- 3
                              |  (1)
                           (2)|
                              |
                              4
              */ 
      
     
      
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();  // intializing array with empty arraylist
        }
      
        // 0 vertex
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
      
        // 1 vertex
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
      
        // 2 vertex
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
      
        // 3 vertex
        graph[3].add(new Edge(3 , 1, 40));
        graph[3].add(new Edge(3 , 2, 50));
      
    
      
    }
    static class Pair implements Comparable<Pair> {
        int node;
        int wt;

        Pair(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
        @Override
        public int compareTo(Pair p2){
            return this.wt - p2.wt;
        }
    }

    public static void prims(ArrayList<Edge> graph[]){

        boolean visited[] = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0));
        int minCost=0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.node]){
                visited[curr.node]=true;
                minCost=minCost+curr.wt;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println(minCost);

    }
    
    public static void main(String args[]){
        int V=4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        buildGraph(graph);

        prims(graph);
    }
}