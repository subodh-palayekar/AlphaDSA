import java.util.*;

public class MotherVertex {
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
      
             int V=graph.length;
      
              for(int i=0;i<V;i++){
                  graph[i]= new ArrayList<>();  // intializing array with empty arraylist
              }
      
              // 0 vertex
              graph[0].add(new Edge(0, 1, 1));
              graph[0].add(new Edge(0, 2, 1));
      
              // 1 vertex
              graph[1].add(new Edge(1, 3, 1));
            //   graph[1].add(new Edge(1, 3, 3));
      
              // 2 vertex
            //   graph[2].add(new Edge(2, 1, 1));
            //   graph[2].add(new Edge(2, 3, 1));
            //   graph[2].add(new Edge(0, 0, 2));
      
              // 3 vertex
            //   graph[3].add(new Edge(3 , 2, 1));
            //   graph[3].add(new Edge(0 , 0, 3));
      
              // 4 vertex
              graph[4].add(new Edge(4, 1, 1));

              // 5 vertex
              graph[5].add(new Edge(5, 6, 1));
              graph[5].add(new Edge(5, 2, 1));

              // 6 vertex
              graph[6].add(new Edge(6, 0, 1));
      
      
            
    }

    private static void dfsUtil(ArrayList<Edge> graph[] ,int curr,boolean visited[]){
        visited[curr]=true;

        if(graph[curr]==null){
            return;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfsUtil(graph, e.dest, visited);
            }
        }
    }

    public static int motherVertex( ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        int v=-1;

        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                dfsUtil(graph,i,visited);
                v=i;
            }
        }

        boolean check[] = new boolean[graph.length];
        dfsUtil(graph, v, check);

        for(int i=0;i<check.length;i++){
            if(!check[i]){
                return -1;
            }
        }
        return v;
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];

        System.out.println(motherVertex(graph));

    }
}
