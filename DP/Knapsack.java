import java.util.Arrays;

public class Knapsack{

    // 0-1 knapsack bounded  

    // recursion appraoch

    public static int knapsack(int val[],int wt[],int n,int w){

        if(w==0 || n==0){
            return 0;
        }
        if(wt[n-1]<=w){
            //incliud
            int ans1 = val[n-1] + knapsack(val, wt, n-1, w-wt[n-1]);
            //exclude
            int ans2 = knapsack(val, wt, n-1, w);
            return Math.max(ans1, ans2);
        }else{
            //exclude
            return knapsack(val, wt, n-1, w);
        }
    }

    // DP - Memoization

    public static int knapsack(int val[],int wt[],int n,int w,int dp[][]){
         
        if(n==0 || w==0){
            return 0;
        }
        if(dp[n][w]!=-1){
            return dp[n][w];
        }

        if(wt[n-1]<=w){
            //include
            int ans1 = val[n-1] + knapsack(val, wt, n-1, w-wt[n-1], dp);
            //exclude
            int ans2 = knapsack(val, wt, n-1, w, dp);
            dp[n][w] = Math.max(ans1, ans2);

            return dp[n][w];
        }else{
            dp[n][w]=knapsack(val, wt, n-1, w, dp);
            return dp[n][w];
        }
    }

    // DP - tabulation

    public static int knapsack(int val[],int wt[],int w){

        int dp[][] = new int[val.length+1][w+1];

        // initialization of row as 0
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        // initialization of col as 0
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }

        // i = number of items starts from 0 to i
        // j = size of knapsack
        for(int i=1;i<val.length+1;i++){

            for(int j=1;j<w+1;j++){
                int v = val[i-1];
                int weight = wt[i-1];
                if(weight<=j){
                //include
                int ans1 = v + dp[i-1][j-weight];
                //exclude
                int ans2 =  dp[i-1][j];

                dp[i][j] = Math.max(ans1, ans2);

                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for (int index = 0; index < dp.length; index++) {
            System.out.println(Arrays.toString(dp[index]));
        }
        System.out.println();
        return dp[val.length][w];

    }



    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int w = 7;
        int dp[][] = new int[val.length+1][w+1];
        System.out.println(knapsack(val, wt, val.length,w));

        // initializing first row and first column
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }

        // System.out.println(knapsack(val, wt, val.length, w, dp));

        System.out.println(knapsack(val, wt, w));


    }
}