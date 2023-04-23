import java.util.Arrays;
public class Transpose{
    public static void main(String[] args) {

        int matrix1[][] = { {4,7,8},{8,8,7} };

        transpose(matrix1);
    }


    public static void transpose (int matrix[][]){

        int n=matrix.length;
        int m=matrix[0].length;

        int transpose[][] = new int[m][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                transpose[j][i]=matrix[i][j];
            }
        }
        for(int i=0;i<transpose.length;i++){
            System.out.println(Arrays.toString(transpose[i]));
        }
    }
}