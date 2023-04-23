import java.util.*;

public class ArticulationTarjan {

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

        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));
        graph[0].add(new Edge(0, 3, 0));

        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 2, 0));

        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 1, 0));

        graph[3].add(new Edge(3, 0, 0));
        graph[3].add(new Edge(3, 4, 0));
        // graph[3].add(new Edge(3, 5, 0));


        graph[4].add(new Edge(4, 3, 0));
        // graph[4].add(new Edge(4, 5, 0));


        // graph[5].add(new Edge(5, 3, 0));
        // graph[5].add(new Edge(5, 4, 0));
        
    

    }

    public static void dfs(ArrayList<Edge> graph[],int dt[],int low[],boolean visited[],int curr,int parent,int time,boolean
     ap[]){
       
        visited[curr]=true;
        dt[curr]=low[curr]=++time;
        int children=0;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(parent==curr){
                continue;
            }else if(!visited[e.dest]){
                dfs(graph,dt, low, visited, e.dest, curr, time, ap);
                low[curr]=Math.min(low[curr], low[e.dest]);
                if(parent!=-1 && dt[curr]<=low[e.dest]){
                    ap[curr]=true;
                }
                children++;
            }else if(visited[e.dest]){ 
                low[curr]=Math.min(low[curr], dt[e.dest]);
            }

        }
        if(parent==-1 && children>1){
            ap[curr]=true;
        }

    }


    public static void articulationTarjan(ArrayList<Edge> graph[],int V){
        int dt[]= new int[V];
        int low[]= new int[V];
        boolean visited[] = new boolean[V];
        int time=0;
        boolean ap[]=new boolean [V];
    

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(graph,dt, low, visited, i, -1, time, ap);
            }
        }

        for(int i=0;i<ap.length;i++){
            if(ap[i]){
                System.out.println("AP : "+i);
            }
        }
    }
    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        articulationTarjan(graph, V);
    }
}
