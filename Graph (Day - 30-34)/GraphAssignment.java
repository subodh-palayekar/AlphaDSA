import java.util.*;

public class GraphAssignment {
    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    public static void buildGraph (ArrayList<Edge> edges){

        edges.add(new Edge(9, 1, 1));
        edges.add(new Edge(9, 5, 1));
        edges.add(new Edge(5, 9, 1));
        edges.add(new Edge(5, 1, 1));
        edges.add(new Edge(5, 2, 1));
        edges.add(new Edge(2, 5, 1));
        edges.add(new Edge(2, 4, 1));
      
    }

    public static void buildGraph (ArrayList<Edge> graph[]){

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
    public static class Pair{
        int dest;
        int parent;

        Pair(int dest,int p){
            this.dest=dest;
            this.parent=p;

        }
    }

    // not tested for multiple test cases
    public static boolean detectCycle(ArrayList<Edge> edges){

        HashMap<Integer,Integer> map = new HashMap<>();  //<Destination,parent>

        // initialising map with starting node with parent as -1
        map.put(edges.get(0).src, -1);
        for(int i=0;i<edges.size();i++){
            Edge e = edges.get(i);
            int src =e.src;
            int dest =e.dest;
            if(map.containsKey(dest)){
                if(dest!=map.get(src)){
                    return true;
                }
            }else{
                map.put(dest,src);
            }
        }
        
        return false;

    }


    // actual answer (cycle detecting using bsf for graph with multiple component)
    public static boolean detectCycle(ArrayList<Edge> graph[]){

        boolean visited[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(detectCycleUtil(graph,visited,i)){
                    return true;
                } 
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[],boolean[] visited,int s){

        // fill parent array by -1
        int parent[] = new int[graph.length];
        for(int i=0;i<parent.length;i++){
            parent[i]=-1;
        }
        
        Queue<Integer> q = new LinkedList<>();
        visited[s]=true;
        q.add(s);

        while(!q.isEmpty()){
            int curr = q.remove();
            for(int i=0;i<graph[s].size();i++){
                Edge e = graph[s].get(i);
                int dest = e.dest;
                if(!visited[dest]){
                    visited[dest]=true;
                    parent[dest]=curr;
                    q.add(dest);
                }else if(parent[curr]!=dest){
                    return true;
                }
            }
            
        }

        return false;
    }

    // find minimum depth of a binary tree
    // Leetcode 111

    public static void main(String[] args) {

    
        ArrayList<Edge> edges = new ArrayList<>();
        buildGraph(edges);

        int V=9;
        ArrayList<Edge> graph[] = new ArrayList[V];
        buildGraph(graph);


        System.out.println(detectCycle(edges));
        
    }
}
