public class CoinChange{
    /*Given an integer array of coins[ ] of size N representing different types of currency and an integer 
    sum, The task is to find the number of ways to make sum by using different combinations from coins[].

    Note: Assume that you have an infinite supply of each type of coin.  
    */ 


    public static int coinChange(int coin[],int sum){
        int n=coin.length;

        int dp[][] = new int[n+1][sum+1];

        // initialization 
        // When sum is zero (j=0) then their is only 1 Way
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        // when we have coin zero (i=0) then any sum greater than zero is not possible therefore 
        // their is zero way (i.e. impossible)
        for(int j=1;j<sum+1;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){ // i coins
            for(int j=1;j<sum+1;j++){  // j sum

                if(coin[i-1]<=j){ //valid
                    dp[i][j]= dp[i][j-coin[i-1]] + dp[i-1][j];  // include + exclude
                }else{ //invalid
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];

    
    }
    public static void main(String[] args) {
        int coin [] = {1,2,3};
        int sum =4;

        System.out.println(coinChange(coin, sum));
    }
}