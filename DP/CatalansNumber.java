import java.util.Arrays;

public class CatalansNumber {

    public static int catalansRecursion(int n ){
        if(n==0 || n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<=n-1;i++){
            ans+=catalansRecursion(i)*catalansRecursion(n-i-1);
        }
        return ans;
    }

    public static int catalansMemoization(int n , int[]dp){
        if(n==0 || n==1){
            return 1;
        }

        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;

        for(int i=0;i<n;i++){
            ans+=catalansMemoization(i, dp)*catalansMemoization(n-i-1, dp);
        }
        dp[n]=ans;

        return ans;
    }

    public static int catalansTabulation(int n){
        int dp[] = new int[n+1];

        //initialization
        dp[0]=1;
        dp[1]=1;

        //bottom up
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];  // Ci += Cj*Ci-j-1   Cn += Cj*Cn-j-1
            }
            
        }

        return dp[n];
    }


    public static void main(String[]args) {
        int n=5;
        int dp[]= new int[n+1];
        Arrays.fill(dp, -1);

        // System.out.println(catalansRecursion(n));
        // System.out.println(catalansMemoization(n, dp));

        System.out.println(catalansTabulation(n));
    }
}
