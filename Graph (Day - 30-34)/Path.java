import java.util.*;
public class Path {
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
        graph[0].add(new Edge(0, 3, 1));

        // 2 vertex
        graph[2].add(new Edge(2, 3, 1));

        // 3 vertex
        graph[3].add(new Edge(3 , 1, 1));

        // 4 vertex
        graph[4].add(new Edge(4 , 0, 1));
        graph[4].add(new Edge(4 , 1, 1));

        // 5 vertex
        graph[5].add(new Edge(5 , 0, 1));
        graph[5].add(new Edge(5 , 2, 1));
    
      
    }


    // all path from source to target
    public static void allPath(ArrayList<Edge> graph[],int src,int dest,String path){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }

        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            allPath(graph, e.dest, dest, path+src);
        }
    }

   public static void main(String[] args) {
    
    int V=6;
    @SuppressWarnings("unchecked")
    ArrayList<Edge> graph[] = new ArrayList[V];
    buildGraph(graph);
    allPath(graph, 5, 1, "");

   }
}
