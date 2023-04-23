import javax.print.event.PrintJobEvent;

public class AssignmentBackTrack {
 
    public static void main(String[] args) {
        int maze[][]= { { 1, 0, 0, 0 },
                        { 1, 1, 0, 1 },
                        { 1, 1, 0, 0 },
                        { 1, 1, 1, 1 } };
        int n= maze.length;
        int sol[][] = new int[n][n];
        // mazeSolver(maze);  // returns only 1 solution
        // rateMaze(maze, 0, 0,sol);  // returns all possible solution
        // keypad("24");
        // keypadCom("");
        // knight(8);
        int board[][]= new int [5][5];
      
        knightSolver(board, 0, 0,1);
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
        
        if(isSafe(maze, row, col)){
            sol[row][col]=1;
            rateMaze(maze, row, col+1,sol); // Right
            sol[row][col]=0; 
            
        }
        if(isSafe(maze, row, col)){
            sol[row][col]=1;
            rateMaze(maze, row+1, col,sol); // Down
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

    private static boolean isSafe(int[][] maze, int row, int col) {

        return (row>=0 && row<maze.length && col>=0 && col<maze.length && maze[row][col]==1);
    }


    private static boolean solveMazeUtil(int[][] maze, int row, int col, int[][] sol) {
        if(row==maze.length-1 && col==maze.length-1 && maze[row][col]==1){
            sol[row][col]=1;
            return true;
        }

        // Check is maze[row][col] is valid
        if(isSafe(maze,row,col)==true){
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

    // Question 2: Keypad Combination

    public static void keypad (String digit){
        String phone[]= {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String first =  digit.substring(0, 1);
        String second  = digit.substring(1);
        int indexI = Integer.parseInt(first)-1;
        int indexJ = Integer.parseInt(second)-1;
        
        for(int i=0;i<phone[indexI].length();i++){
            for(int j=0;j<phone[indexJ].length();j++){
                System.out.print(phone[indexI].charAt(i)+""+phone[indexJ].charAt(j)+" ");
            }
        }
    }


    // ---------------------------------------------------------------

    public static void keypadCom(String digit){
        char letter[][] = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        int n = digit.length();
        if(n==0){
            System.out.println("");
            return;
        }
        combination(0,digit,letter,n,new StringBuilder());
    }
    public static void combination(int pos,String digit,char letter[][],int size,StringBuilder ans){
        if(pos==size){
            System.out.print(ans.toString()+" ");
        }else{
           char current[]=letter[Character.getNumericValue(digit.charAt(pos))];
           for(int i=0;i<current.length;i++){
            combination(pos+1, digit, letter, size,new StringBuilder(ans).append(current[i]));
           }
        }
    }

    //------------------------------------------------------------
    
    public static void knight(int n){
        int board[][]= new int [n][n];
      
        knightSolver(board, 0, 0,1);
    }

    public static void knightSolver(int board[][],int row,int col,int steps){
        int n = board.length;
        if(row<0 || col<0 || row>=n||col>=n|| board[row][col]>0){
            return;
        }else if(steps==(n*n)){
            board[row][col]=steps;
            print2DArray(board);
            board[row][col]=0;
            return;
        }
        // if(knightSafe(board,row,col)){
            board[row][col]=steps;
            knightSolver(board, row-2, col+1,steps+1);//
            knightSolver(board, row-1, col+2,steps+1);//
            knightSolver(board, row+1, col+2,steps+1);//
            knightSolver(board, row+2, col+1,steps+1);//
            knightSolver(board, row+2, col-1,steps+1);//
            knightSolver(board, row+1, col-2,steps+1);//
            knightSolver(board, row-1, col-2,steps+1); //
            knightSolver(board, row-2, col-1,steps+1);//
            board[row][col]=0;
        // }else{

        //     return;
        // }
        
    }


    private static boolean knightSafe(int[][] board, int row, int col) {
        if(row>=0 && col>=0 &&  row<board.length && col<board.length &&  board[row][col]==0){
            return true;
        }
        return false;
    }
}
