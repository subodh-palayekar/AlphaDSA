import java.util.*;

public class FindUnionCycle {

    static int n =3;
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
    }

    public static int find(int x){
        if(parent[x]==x){
            return x;
        }

        return find(parent[x]);
    }

    public static void union(int a,int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA]==rank[parB]){
            parent[parB]=parA;
            rank[parA]++;
        }else if(rank[parA]<rank[parB]){
            parent[parA]=parB;
        }else if(rank[parA]>rank[parB]){
            parent[parB]=parA;
        }
    }

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
                  graph[i]= new ArrayList<>();  // initializing array with empty arraylist
              }
      
              // 0 vertex
              graph[0].add(new Edge(0, 1, 1));
              graph[0].add(new Edge(0, 2, 1));
      
              // 1 vertex
              graph[1].add(new Edge(1, 0, 1));
              graph[1].add(new Edge(1, 2, 1));
      
              // 2 vertex
              graph[2].add(new Edge(2, 1, 1));
              graph[2].add(new Edge(2, 0, 1));
                    
          }

    public static boolean dfsUtil(ArrayList<Edge> graph[],boolean visited[],int curr,int par){
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                union(e.src, e.dest);
                dfsUtil(graph, visited, e.dest,curr);
            }else if(visited[e.dest] && parent[curr]==parent[e.dest] && e.dest!=par){
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(graph[i]==null){
                visited[i]=true;
                continue;
            }
            if(!visited[i]){
                if(dfsUtil(graph,visited,i,-1)){
                    return true;
                }
            }
            
        }

        return false;
        
    }
         
    


    

    public static void main(String[] args) {
     
        int V=3;
        ArrayList<Edge> graph[] = new ArrayList[V];
        buildGraph(graph);
        System.out.println(isCycle(graph));
        System.out.println(Arrays.toString(parent));



    }
}
