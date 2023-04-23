import java.util.PriorityQueue;

public class ConnectingCities {
    // find the minimum cost for connecting all cities of the map


    
    public static void main(String[] args) {
    
        int cities[][] = {{0,1,2,3,4,},
                          {1,0,5,0,7},
                          {2,5,0,6,0},
                          {3,0,6,0,0},
                          {4,7,0,0,0}};

        System.out.println(connectingCititesMinCost(cities));
        
    }

    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;

        Edge(int dest,int cost){
            this.dest=dest;
            this.cost=cost;
        }
        @Override
        public int compareTo(Edge e2){
            return this.cost - e2.cost;
        }
    }

    public static int connectingCititesMinCost(int cities[][]){

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[cities.length];
        int cost=0;

        pq.add(new Edge(0, 0));
    

      
        while(!pq.isEmpty()){
            Edge curr = pq.remove();
            if(!visited[curr.dest]){
                visited[curr.dest]=true;
                cost+=curr.cost;
                for(int j=0;j<cities[curr.dest].length;j++){

                    if(cities[curr.dest][j]!=0){
                        pq.add(new Edge(j,cities[curr.dest][j]));
                    }

                }
            }
            
        }
        return cost;

    }
}
