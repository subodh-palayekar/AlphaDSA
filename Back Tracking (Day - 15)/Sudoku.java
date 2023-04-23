public class Sudoku {
    public static void main(String[] args) {
        int sudoku[][]={{3, 0, 6, 5, 0, 8, 4, 0, 0},
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
