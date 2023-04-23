import java.util.*;

public class RottenOrange {

    static class Pair{
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

    }

    public static int rottenOrange(int grid[][]){
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q = new  LinkedList<>();
        int visited[][] = new int[m][n];
        int countFreshBefore =0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i, j, 0));
                    visited[i][j]=2;
                }else if(grid[i][j]==1){
                    visited[i][j]=1;
                    countFreshBefore++;

                }else{
                    visited[i][j]=0;
                }
            }
        }

      int time=0;
      int moveR [] ={0,0,1,-1};   //left,right,up,down
      int moveC [] ={1,-1,0,0};  
      int freshToRotten =0;
      

      while(!q.isEmpty()){
        Pair e = q.remove();
        int row=e.row;
        int col=e.col;
        int t =e.time;
        time = Math.max(time,t);

        for(int i=0;i<4;i++){
            // travers to its neighbour
            int nextRow = row + moveR[i];
            int nextCol = col + moveC[i];

            if(nextRow>=0 && nextCol>=0 && nextRow<m && nextCol<n && grid[nextRow][nextCol]==1 && visited[nextRow][nextCol]==0){
                q.add(new Pair(nextRow, nextCol, time+1));
                visited[nextRow][nextCol]=2;
                freshToRotten++;
            }
        }
      }

      if(freshToRotten != countFreshBefore){
        return -1;
      }
      return time;


    
    }
    public static void main(String[] args) {
        
    }
}
