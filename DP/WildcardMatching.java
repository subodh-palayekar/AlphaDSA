public class WildcardMatching {


    public static boolean wilcardMatching(String s , String p){
        int n=s.length();
        int m=p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        //initialization
        dp[0][0]=true;

        // when pattern is empty j=0 and string is not empty
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }

        // when string is empty and pattern is not empty
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    boolean ignore = dp[i][j-1];
                    boolean match = dp[i-1][j];
                    dp[i][j]= ignore || match;
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];



    }
    public static void main(String[] args) {
        String str =  "aa"; //"baaabab";
        String pattern = "?"; //*ba*****ab

        System.out.println(wilcardMatching(str, pattern));
    }
}
