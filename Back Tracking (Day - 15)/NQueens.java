public class NQueens {
    public static void main(String[] args) {
        int n=5;
        char chess[][]= new char[n][n];
        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess.length;j++){
                chess[i][j]='X';
            }
        }
        queens(chess, 0);
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
    static int count=0;

    public static void queens(char arr[][],int row){
        if(row==arr.length){
            print2d(arr);
            // count++;
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
}
