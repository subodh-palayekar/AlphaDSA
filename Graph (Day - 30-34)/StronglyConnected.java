import java.util.*;

public class StronglyConnected {

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

    public static void createGraph(ArrayList<Edge> graph[]){


        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();  // intializing array with empty arraylist
        }

        graph[0].add(new Edge(0, 2, 0));
        graph[0].add(new Edge(0, 3, 0));

        graph[1].add(new Edge(1, 0, 0));

        graph[2].add(new Edge(2, 1, 0));

        graph[3].add(new Edge(3, 4, 0));

    }

    public static void topoSort(ArrayList<Edge>  graph[] , int curr,boolean visited[],Stack<Integer> st){
        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topoSort(graph, e.dest, visited,st);
            }
        }
        st.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr,boolean visited[]){
        visited[curr]=true;
        System.out.print(curr+" ");

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }


    public static void stronglyConnectedComponent(ArrayList<Edge> graph[] , int V){


        // step 1 Topological sort

        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[V];

        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                topoSort(graph, i, visited, st);
            }
        }


        // step 2 Transpose the graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transpose[] = new ArrayList[V];

        for(int i=0;i<transpose.length;i++){
            visited[i]=false;  // re-initialize the visited array
            transpose[i]= new ArrayList<>();  // intializing array with empty arraylist
        }

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                int src = e.src;
                int dest = e.dest;

                transpose[dest].add(new Edge(dest, src, e.wt));
            }
        }

        // step 3 perform dfs on transpose graph according to stack order

        while(!st.isEmpty()){

            int curr = st.pop();
            if(!visited[curr]){
                System.out.print("SCC --> ");
                dfs(transpose, curr, visited);
                System.out.println();
            }
            

        }




    }

    public static void main(String[] args) {
        int V =5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        stronglyConnectedComponent(graph, V);



    }
}
