import java.util.Arrays;

public class ClimbingStairs {

    // Count ways to reach the nth stair.The person can climb after 1 stair or 2 stairs at a time


    // recursive approach to calculate O(2^n)
    public static int ways(int n){

        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        return ways(n-1)+ways(n-2);
    }
 
    // dp - memoization approach O(n)
    public static int countWays(int n,int count[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(count[n]!=-1){
            return count[n];
        }
        count[n] = countWays(n-1, count) + countWays(n-2, count);
        return count[n];
    }

    // dp - tabulation approach O(n)

    public static int countWays(int n){
        int dp[] = new int[n+1];
        dp[0]=1;
        
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i] = dp[i-1]+0;
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(ways(n));

        int count[] = new int[n+1];
        Arrays.fill(count, -1);
        System.out.println(countWays(n, count));

        System.out.println(countWays(n));

    }
}
