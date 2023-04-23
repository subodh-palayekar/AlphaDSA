public class UnboundedKnapSack {


    public static int unboundedKnapsack(int val[],int wt[],int w){
        int n=val.length;
        int dp[][]=new int[n+1][w+1];

        // initialization of first column as zero
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        // initialization of first row as zero
        for(int j=0;j<w+1;j++){
            dp[0][j]=0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = val[i-1];
                int weight = wt[i-1];

                // valid
                if(weight<=j){
                    // include
                    int ans1 = v + dp[i][j-weight];

                    //exclude
                    int ans2 = dp[i-1][j];

                    dp[i][j]=Math.max(ans1, ans2);
                }else{
                    //exclude
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int w=7;
        System.out.println(unboundedKnapsack(val, wt, w));
    }
}
