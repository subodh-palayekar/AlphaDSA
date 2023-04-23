import java.util.*;
public class Bipartite {

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
                    0 ------ 2
                   /        /
                  /        /
                 /        /
                1       4
                 \     / 
                  \   /
                   \ /    
                    3   
        */ 

       int V=5;

        for(int i=0;i<V;i++){
            graph[i]= new ArrayList<>();  // intializing array with empty arraylist
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 vertex
        graph[3].add(new Edge(3 , 1, 1));
        graph[3].add(new Edge(3 , 4, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 2));
        graph[4].add(new Edge(4, 3, 2));

    }

    public static boolean bipartite(ArrayList<Edge> graph[]){

        // 0 yellow  1 blue  -1 no color
        int color[] = new int[graph.length];
        // initializing color array with -1
        for(int i=0;i<color.length;i++){
            color[i]=-1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){

                q.add(i);
                color[i]=0; //yellow;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e = graph[curr].get(j);  //e.dest
                        if(color[e.dest]==-1){
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        }else if(color[e.dest]==color[curr]){
                            return false;   // not bipartite
                        } 
    
                    }
                }
            }


        }
        return true;

    }

    public static void main(String[] args) {
        int V=5; // vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        buildGraph(graph);

        System.out.println(bipartite(graph));
    }


}
