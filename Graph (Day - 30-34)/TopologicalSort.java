import java.util.*;
public class TopologicalSort{

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
 /*           
            5        4 
            |\     / |
            | \   /  |
            v  v v   v
            2   0   1
             \     ^
              \   /
               v /             
                4

              */ 
      
    
      
        for(int i=0;i<graph.length;i++){
          graph[i]= new ArrayList<>();  // intializing array with empty arraylist
        }
      
      
        // 2 vertex
        graph[2].add(new Edge(2, 3, 1));
      
        // 3 vertex
        graph[3].add(new Edge(3 , 1, 1));
         
        // 4 vertex
        graph[4].add(new Edge(4, 2, 2));
        graph[4].add(new Edge(4, 3, 2));
        // 5 vertex
        graph[5].add(new Edge(5, 0, 2));
        graph[5].add(new Edge(5, 2, 2));
       
      
    }

    // using dsf
    public static void topologicalSort(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];

        Stack<Integer> st = new Stack<>();

        for (int i=0;i<graph.length;i++){
            if(!visited[i]){
                topoSortUtil(graph,visited,i,st);
            }
        }

        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }

    // using dsf
    public static void topoSortUtil(ArrayList<Edge> graph[],boolean visited[] , int curr , Stack<Integer> st){
        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){

                topoSortUtil(graph, visited, e.dest, st);
            }
        }
        st.push(curr);
    }

    public static void calIndegree(ArrayList<Edge> graph[],int inDegree[]){

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                inDegree[e.dest]++;
            }
        }
    }
    public static void topoSortBsf(ArrayList<Edge> graph[]){
        int inDegree[] = new int[graph.length];
        calIndegree(graph, inDegree);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                inDegree[e.dest]--;
                if(inDegree[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }


   public static void main(String[] args) {
    int V=6;
    ArrayList<Edge> graph[] = new ArrayList[V];
    buildGraph(graph);


    // Topological sort using dsf
    // topologicalSort(graph);

    // Topological sort using bsf
    topoSortBsf(graph);

   }
    
}