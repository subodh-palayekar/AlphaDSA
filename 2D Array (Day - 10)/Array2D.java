import java.util.Arrays;
import java.util.Scanner;

public class Array2D {
    public static void main(String[] args) {

        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        // maxAndMin(matrix);        
        array();
    }

    public static  void maxAndMin (int matrix[][]){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                min=Math.min(min,matrix[i][j]);
                max=Math.max(max, matrix[i][j]);
            }
        }
        System.out.println("max: "+max + " min:"+min);
    }

    public static void array(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Row size");
        int n = sc.nextInt();
        System.out.println("Enter Column size");
        int m = sc.nextInt();
        int matrix[][]= new int[n][m];

        System.out.println("Enter Elements of Matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
