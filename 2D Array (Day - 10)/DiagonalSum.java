public class DiagonalSum {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
                
                // diagonalSum(matrix);
                optimizeDiagonalSum(matrix);
    }
    // Diagonal Sum is valid only if Row==Column (n=m)



    // BruteForce approach  O(n^2)
    public static void diagonalSum(int matrix[][]){
        int n=matrix.length;
        int sum=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                  sum+=matrix[i][j]; // Primary Diagonal Sum
                }else if(i+j==n-1){
                    sum+=matrix[i][j]; // // Secondary Diagonal Sum
                }
            }
        }
        System.out.println(sum);
    }

    // optimize approach O(n)
    public static void optimizeDiagonalSum(int matrix[][]){
        int n=matrix.length;
        int sum=0;

        for(int i=0;i<n;i++){
            //Primary Diagonal Sum
            sum+=matrix[i][i]; 

            // Secondary Diagonal Sum
            //value of j for condition of Secondary Diagonal Sum (i+j==n-1)  --> j=n-1-i;
            if(i!=n-1-i){
                sum+=matrix[i][n-1-i];
            }
        }
        System.out.println(sum);
    }
    
}
