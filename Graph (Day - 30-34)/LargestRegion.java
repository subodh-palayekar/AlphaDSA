public class LargestRegion {


    static int count;
    public static boolean isSafe(int [][]region,boolean[][]visited,int row,int col){

        return (row>=0 && (row<region.length) && (col<region[0].length) && (col>=0) && (region[row][col]==1 && !visited[row][col]));

    }
    public static int largestRegion(int[][] region){
    
        int maxCount=0;

        boolean visited[][] = new boolean[region.length][region[0].length];
        for(int i=0;i<region.length;i++){
            for(int j=0;j<region[i].length;j++){
                if(region[i][j]==1 && !visited[i][j]){
                    count=1;
                    dfs(region,visited,i,j);
                   
                    maxCount=Math.max(maxCount,count);
                }
                
            }
           
        }
        return maxCount;
    }

    public static void dfs(int[][] region,boolean[][] visited,int i,int j){
        visited[i][j]=true;
        // count++;

        int rowMove[]={-1,1,0,0,-1,-1,1,1}; // up down left right leftUpDig rightUpDig downLeftDig downRightDig
        int colMove[]={0,0,-1,1,-1,1,-1,1}; // up down left right leftUpDig rightUpDig downLeftDig downRightDig

        for(int k=0;k<8;k++){
            int nextRow=i+rowMove[k];
            int nextCol=j+colMove[k];

            if(isSafe(region, visited, nextRow, nextCol) ){
                count++;
                dfs(region, visited, nextRow, nextCol);
                
            }
        }
    }
    public static void main(String[] args) {
        int region[][] = { {0,0,1,1,0},
                           {0,1,1,1,0},
                           {0,0,1,1,0},
                           {0,0,0,0,1}};

        System.out.println(largestRegion(region));
  
    }
}
