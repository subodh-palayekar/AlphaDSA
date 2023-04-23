import java.util.*;

public class CheapestFlight {
    /*  Ther are n cities connected by some number of flights. You are given an array flights where
        flights[i] = [from,to,price] indicates that there is a flight. 
        You are also given three integers src,dst,and k, return the cheapest price from src to dst with
        at most k stops.
        if there is no such route,return -1.
    */

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

    public static void createGraph(int flight[][],ArrayList<Edge> graph[]){

        // initializing graph arr with empty arraylist
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
       
        for(int i=0;i<flight.length;i++){
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];
            Edge e = new Edge(src, dest, wt);

            graph[src].add(e);

        }
    }

    static class Info{
        int node;
        int stop;
        int cost;

        public Info(int node,int stop,int cost){
            this.node=node;
            this.stop=stop;
            this.cost=cost;
        }
    }

    public static int cheapestFlightWithKstops(int n,int flight[][],int src,int dest,int k){
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flight, graph);

        // performing dijkstar's algorithm
        int cost [] = new int[n];

        // initializing cost array
        for(int i=0;i<cost.length;i++){
            if(i!=src){
                cost[i]=Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stop > k){
                break;
            }
            for(int i=0;i<graph[curr.node].size();i++){
                Edge e = graph[curr.node].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                
                // relaxation
                if( curr.cost +wt <cost[v] && curr.stop<=k){
                    cost[v] = curr.cost + wt;
                    q.add(new Info(v, curr.stop+1, cost[v]));
                }

            }
        }

    
        if(cost[dest]!=Integer.MAX_VALUE){

            return cost[dest];
        }
        return -1;
    }

    // leet code solution

    public static int findCheapestPrice(int n,int[][]flights,int src,int dest,int k){
        int path[]= new int[n];
        Arrays.fill(path,Integer.MAX_VALUE);
        path[src]=0;
        for(int i=0;i<=k;i++){
            int temp[]=Arrays.copyOf(path, n);
            for(int arr[]:flights){
                int u = arr[0];
                int v = arr[1];
                int wt = arr[2];
                if(path[u]==Integer.MAX_VALUE)
                continue;
                temp[v]=Math.min(temp[v], path[u]+wt);

            }
            path=temp;
        }
        return path[dest]==Integer.MAX_VALUE ? -1 :path[dest];
    }


    public static void main(String[] args) {
        int n=4;
        int flight[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0 , dest = 3, k = 1;

        System.out.println(cheapestFlightWithKstops(n, flight, src, dest, k));
        System.out.println(findCheapestPrice(n, flight, src, dest, k));

    }

    
}
