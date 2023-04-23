public class LongestCommonSubsequence {

    /* A subsequence of a string is a new string generated from the original string with some characters
     * (can be none) deleted without changing the relative order of the remaining characters. 
     */

    public static int lcsRecursion(String str1 , String str2 , int n , int m){

        // Base Condition
        if(n==0 || m==0){
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){  //same
            return lcsRecursion(str1, str2, n-1, m-1) + 1 ;
        }else{ //diff
            // first String reduce
            int first =lcsRecursion(str1, str2, n-1, m);
            // second String reduce
            int second = lcsRecursion(str1, str2, n, m-1);
            return Math.max(first, second);
        }

    }


    public static int lcsMemoization(String str1,String str2,int n,int m,int dp[][]){

         // Base Condition
         if(n==0 || m==0){
            return 0;
        }

        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){ //same
            dp[n][m] = lcsMemoization(str1, str2, n-1, m-1, dp)+1;
            return dp[n][m];
        }else{ //diff
            // first String reduce
            int ans1 =lcsMemoization(str1, str2, n-1, m,dp);
            // second String reduce
            int ans2 = lcsMemoization(str1, str2, n, m-1,dp);
            dp[n][m] = Math.max(ans1, ans2);
            return dp[n][m];
        }
    }

    public static int lcsTabulation(String str1,String str2){
        int n=str1.length();
        int m=str2.length();

        int dp[][] = new int[n+1][m+1];

        //initialization 
        // i = length of str1  j = length ofstr2
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }


        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]= 1 + dp[i-1][j-1];
                }else{//diff
                    // first String reduce
                    int ans1 =dp[i-1][j];
                    // second String reduce
                    int ans2 = dp[i][j-1];

                    dp[i][j] = Math.max(ans1, ans2);
                    
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1 ="abcdge";
        String str2 ="abedg";

        System.out.println(lcsRecursion(str1, str2, str1.length(), str2.length()));

        int dp[][] = new int[str1.length()+1][str2.length()+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }

        System.out.println(lcsMemoization(str1, str2, str1.length(), str2.length(), dp));

        System.out.println(lcsTabulation(str1, str2));

    }
}
