import java.util.PriorityQueue;

public class WeakestSoldier {

    static class Soldier implements Comparable<Soldier>{
        int solCount;
        int idx;

        public Soldier(int solCount,int idx){
            this.solCount=solCount;
            this.idx=idx;
        }
        @Override
        public int compareTo(Soldier s2){
            if( this.solCount==s2.solCount){
                return this.idx-s2.idx;
            }
            
            return this.solCount-s2.solCount;
        }

    }
    public static void main(String[] args) {
        int soldier[][] = {{1,0,0,0},
                            {1,1,1,1},
                            {1,0,0,0},
                            {1,0,0,0}};
        int k=2;

        PriorityQueue<Soldier> pq = new PriorityQueue<>();

        for(int i=0;i<soldier.length;i++){
            int count=0;
            for(int j=0;j<soldier[i].length;j++){
                if(soldier[i][j]==1){
                    count++;
                }
            }
            pq.add(new Soldier(count, i));
        }

        for(int i=0;i<k;i++){
            System.out.println("Soldier "+ pq.remove().idx);
        }
    }

}
