import java.util.Arrays;

public class BackTracking{
    public static void main(String[] args) {
        int arr[] = new int[5];
        // changeArray(arr, 0, 1);
        // System.out.println(Arrays.toString(arr));
        // subSet("abc", "", 0);
        // permutation("abc", "");
        int n=5;
        char chess[][]= new char[n][n];
        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess.length;j++){
                chess[i][j]='X';
            }
        }
        // queens(chess, 0);
        // System.out.println(count);
        System.out.println(gridWays(0, 0, 3, 3));


        int sudoku[][]={ {3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0} };

        sudokuSolver(sudoku, 0, 0);
    }

    public static void changeArray(int arr[],int i,int value){
        if(i==arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }

        arr[i]=value;
        changeArray(arr, i+1, value+1);
        arr[i]=value-2;
    }

    public static void subSet(String given , String ans,int index){
      
        if(index==given.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        char ch = given.charAt(index);
        subSet(given, ans+ch, index+1);
        subSet(given, ans, index+1);

    }

    public static void permutation(String given, String ans){
        if(given.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<given.length();i++){
            char current = given.charAt(i);
            String newString = given.substring(0, i) + given.substring(i+1);
            permutation(newString, ans+current);

        }
    }
    public static void print2d(char arr[][]){
        System.out.println("-----------------------------------");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char arr [][] , int row,int column){

        //vertically
        for(int i=row-1;i>=0;i--){
           if(arr[i][column]=='Q'){
            return false;
           }
        }

        // left Diagonal
        for(int i=row-1,j=column-1;i>=0 && j>=0;i--,j--){
            if(arr[i][j]=='Q'){
             return false;
            }
         }

        // right Diagonal
        for(int i=row-1,j=column+1;i>=0 && j<arr.length;i--,j++){
            if(arr[i][j]=='Q'){
             return false;
            }
         }
         return true;

    }
    static int count=0;;
    public static void queens(char arr[][],int row){
        if(row==arr.length){
            // print2d(arr);
            count++;
            return;
        }
        for(int j=0;j<arr.length;j++){
            if(isSafe(arr, row, j)){
                arr[row][j]='Q';
                queens(arr, row+1);
                arr[row][j]='X';
            }
            
        }
    }

    public static int gridWays(int i,int j,int n,int m){
        if(i==n-1 && j==m-1){
            return 1;
        }else if(i>=n || j>=m){
            return 0;
        }
        return gridWays(i+1, j, n, m) + gridWays(i, j+1, n, m); // down + right
    }


    public static boolean sudokuSolver(int sudoku[][],int row,int col){
        int nextRow=row;
        int nextCol = col+1;
        if(nextCol==9){
            nextRow=row+1;
            nextCol=0;
        }
        if(row==9){
            for(int i=0;i<sudoku.length;i++){
                for(int j=0;j<sudoku.length;j++){
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        if(sudoku[row][col]!=0){
            
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        
        for(int digit=1;digit<=9;digit++){
            if(digitSafe(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    return true;
                }
               sudoku[row][col]=0;
            }  
        }
        return false;
    }

    private static boolean digitSafe(int[][] sudoku, int row, int col, int digit) {

        //row
        for(int j=0;j<9;j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }

        // column
        for(int i=0;i<9;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        // section grid

        int startRow = (row/3)*3;
        int starCol= (col/3)*3;

        for(int i=startRow;i<startRow+3;i++){
            for(int j=starCol;j<starCol+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }

}