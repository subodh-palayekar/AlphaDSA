import java.util.Arrays;

public class Assignment2D {
    public static void main(String[] args) {
        int matrix1[][] = { {4,7,8},{8,8,7} };
        // System.out.println(numCount(matrix1, 8));

        int nums[][] = {{1,4,9},{11,4,3},{2,2,3}};
        // System.out.println(rowSum(nums, 2));

        transpose(matrix1);
    }

    // Question 1 : Print the number of 7’s that are inthe 2d array.

    public static int numCount(int matrix[][],int key){
        int counter=0;

        int n= matrix.length;
        int m=matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(key==matrix[i][j]){
                    counter++;
                }
            }
        }

       return counter;
    }

    //  Question 2 : Print out the sum of the numbers in the second row of the “nums” array.

    public static int rowSum (int matrix[][],int rowNum){
        
        int sum=0;
        int row=rowNum-1;
        int m=matrix[row].length;

        for(int j=0;j<m;j++){
            sum+=matrix[row][j];
        }
        return sum;
    }

    //  Question 3 : Transpose of matrix

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
