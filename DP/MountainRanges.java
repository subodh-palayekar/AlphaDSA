public class MountainRanges {

    public static int mountainRanges(int n){
        int dp[] = new int[n+1];
        
        //initialization
        dp[0]=1;
        dp[1]=1;

        //bottom up
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        System.out.println(mountainRanges(n));
    }
}
