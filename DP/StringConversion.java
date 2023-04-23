public class StringConversion {
    /*
     * Convert String1 to String2 with only insertion & deletion
     * Print number of deletions & insertions
     */

    public static int stringConversion(String str1 , String str2){
        // first find lcSubsequence

        int n = str1.length();
        int m = str2.length();
        int dp[][]=new int[n+1][m+1];


        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }

        for(int i=0;i<m+1;i++){
            dp[0][i]=0;
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    int firstReduce = dp[i-1][j];
                    int secondReduce = dp[i][j-1];
                    dp[i][j]=Math.max(firstReduce, secondReduce);
                }
            }
        }

        int ans = (n-dp[n][m] ) + (m-dp[n][m]);  // (length of str1 - length of lcs) + (length of str2 - length of lcs)
        System.out.println("Delete Operation perform "+ (n-dp[n][m]));
        System.out.println("Insert Operation perform "+ (m-dp[n][m]));

        return ans;

    }
    public static void main(String[] args) {
        String str1 ="pear";
        String str2 ="sea";

        System.out.println(stringConversion(str1, str2));
    }
}
