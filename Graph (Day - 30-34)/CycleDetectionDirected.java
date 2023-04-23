import java.util.*;

public class CycleDetectionDirected {
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

        int V=4;

        for(int i=0;i<V;i++){
            graph[i]= new ArrayList<>();  // intializing array with empty arraylist
        }

        // 0 vertex
        graph[0].add(new Edge(0, 2, 1));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));
       
        // 2 vertex
        graph[2].add(new Edge(2, 3, 1));

        // 3 vertex
        graph[3].add(new Edge(3 , 0, 1));
    
      
    }

    // cycle detection for directed grpah
    public static boolean isCycle(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(isCycleUtil(graph, i, visited, stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[],int curr,boolean visited[],boolean stack[]){

        visited[curr]=true;
        stack[curr]=true;
        
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]  && isCycleUtil(graph, e.dest, visited, stack)){
                return true;
            } if(stack[e.dest] == true){
                return true;
            }
        }
        stack[curr]=false;

        return false;
    }


    public static void main(String[] args) {

        int V=4;
        ArrayList<Edge> graph[] = new ArrayList[V];

        buildGraph(graph);

        System.out.println(isCycle(graph));
    }
}
