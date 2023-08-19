import java.util.*;

public class Graph2{

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

       int V=5;

        for(int i=0;i<V;i++){
            graph[i]= new ArrayList<>();  // intializing array with empty arraylist
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1 vertex
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 vertex
        graph[3].add(new Edge(3 , 2, 1));
        graph[3].add(new Edge(3 , 1, 3));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 2));


       
    }

    // bfs for graph with multiple component O(V+E)

    public static void bsf(ArrayList<Edge> graph[]){

        boolean visited[]= new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                bfsUtil(graph,visited);
            }
        }

    }

    public static void bfsUtil(ArrayList<Edge> graph[], boolean visited[]){
        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.println(curr+" ");
                visited[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // dsf for graph with multiple component  O(V+E)
    public static void dsf(ArrayList<Edge> graph[]){

        boolean visited[]= new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                dfsUtil(graph,i,visited);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[],int curr,boolean visited[]){
        System.out.println(curr);
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[i]){
               dfsUtil(graph, e.dest, visited);
            }
        }
    }

    public static boolean cycleDetectioon(ArrayList<Edge> graph[]){

        boolean visited[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
             if(cycleDetectionUtil(graph, i, -1, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleDetectionUtil (ArrayList<Edge> graph[],int curr,int parent ,boolean visited[] ){

        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            // case 1 
            if(!visited[e.dest]){
               if(cycleDetectionUtil(graph, e.dest, curr, visited)){
                return true;
               }
            
            } 
            // case 2
            else if(visited[e.dest] && e.dest != parent){
                return true;
            }
            // case 3 do nothing (if neighbour is already visited and it is our parent then cycle may or may not exist)
        }
        return false;
        
    }


    


    public static void main(String[] args) {
        int V=5; // vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        buildGraph(graph);
        // dsf(graph);


        //  cycle detection in undirected graph
        System.out.println(cycleDetectioon(graph));
    }
}