
public class Nknights{
    public static void main(String[] args) {
        int n=8;
        knight(new int[n][n], 0, 0, 1);
    }
    private static void print2DArray(int[][] maze) {
        System.out.println("---------------------------------");
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze.length;j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean knight(int board[][],int row,int col,int move){
        int n=board.length;
        if(move==(n*n)){
            print2DArray(board);
            return true;
        }

        int rowMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int colMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        board[0][0]=0;

        for(int i=0;i<8;i++){
            int nextRow = row + rowMove[i];
            int nextCol = col + colMove[i];

            if(isSafe(board,nextRow,nextCol)){
                board[nextRow][nextCol]=move;
                if(knight(board, nextRow, nextCol, move+1)){
                    return true;
                }else{
                    board[nextRow][nextCol]=0;
                }
               
            }
        }
        return false;

    }
    private static boolean isSafe(int[][] board, int nextRow, int nextCol) {
        // if(nextRow<0 || nextCol <0 || nextRow>=board.length || nextCol>=board.length || board[nextRow][nextCol]>0){
        //     return false;
        // }
        // return true;

        return(nextRow>=0 && nextRow<board.length && nextCol>=0 && nextCol<board.length && board[nextRow][nextCol] == 0);
    }
}