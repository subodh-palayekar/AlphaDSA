public class Maze {
    public static void main(String[] args) {
        int maze[][]= { { 1, 0, 0, 0 },
                        { 1, 1, 0, 1 },
                        { 1, 1, 0, 0 },
                        { 1, 1, 1, 1 } };
        int n= maze.length;
        int sol[][]=new int[n][n];
        rateMaze(maze, 0, 0, sol); // Returns all possible solution
        mazeSolver(maze); // Return one possible solution



    }

    // Question 1: Rat in a maze

    public static void rateMaze(int maze[][],int row,int col,int sol[][]){
       
        // Base case
        if(row==maze.length-1 && col==maze.length-1){
            sol[row][col]=1;
            print2DArray(sol);
            return;
        }
        if(row==maze.length || col==maze.length || row<0 || col<0 || maze[row][col]==0 ){
            return;
        }
           
        
        if(isSafe(maze, row, col,sol)){
            sol[row][col]=1;
            rateMaze(maze, row, col+1,sol); // Right
            sol[row][col]=0;   
        }
        if(isSafe(maze, row, col,sol)){
            sol[row][col]=1;
            rateMaze(maze, row+1, col,sol); // Down
            sol[row][col]=0;
        }
        if(isSafe(maze, row, col,sol)){
            sol[row][col]=1;
            rateMaze(maze, row, col-1,sol); // left
            sol[row][col]=0; 
        }
        if(isSafe(maze, row, col,sol)){
            sol[row][col]=1;
            rateMaze(maze, row-1, col,sol); // up
            sol[row][col]=0;
        }
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

    

    private static boolean isSafe(int[][] maze, int row, int col,int[][]sol) {
        if(row>=maze.length || col>=maze.length || row<0 || col<0 || maze[row][col]==0 || sol[row][col]==1){
            return false;
        }
        return true;

        // return (row>=0 && row<maze.length && col>=0 && col<maze.length && maze[row][col]==1);
    }

     

    // This function only move right and down

    public static boolean mazeSolver(int maze[][]){
        int n = maze.length;
        int sol[][]= new int [n][n];
        if(solveMazeUtil(maze,0,0,sol)==false){
            System.out.println("solution doesn't exist");
            return false;
        }
        print2DArray(sol);
        return true;
    }


    
    private static boolean solveMazeUtil(int[][] maze, int row, int col, int[][] sol) {
        if(row==maze.length-1 && col==maze.length-1 && maze[row][col]==1){
            sol[row][col]=1;
            return true;
        }

        // Check is maze[row][col] is valid
        if(isSafe(maze,row,col,sol)==true){
            if(sol[row][col]==1){
                return false;
            }
            sol[row][col]=1;
            if(solveMazeUtil(maze, row+1, col, sol)){
                return true;
            }
            if(solveMazeUtil(maze, row, col+1, sol)){
                return true;
            }
            sol[row][col]=0;
            return false;
        }
        return false;
    }
}
