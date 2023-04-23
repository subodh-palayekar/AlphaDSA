import java.util.*;
public class Graph{

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


        //  2's neighbours
        // for(int i=0;i<graph[2].size();i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.dest);
        // }
    }

    public static void bfs(ArrayList<Edge> graph[]){
       Queue<Integer> que = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];

        que.add(0); // source = 0;

        while(!que.isEmpty()){
            int curr = que.remove();
            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    que.add(e.dest);
                }
            }
        }

    }

    public static void dsf(ArrayList<Edge> graph[],int curr,boolean visited[]){
        System.out.print(curr+" ");
        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dsf(graph, e.dest, visited);
            }
        }
    }
    public static void main(String[] args) {

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

        int V=5; // vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        buildGraph(graph);
        // bfs(graph);

        dsf(graph, 0, new boolean[V]);

       




    }
}