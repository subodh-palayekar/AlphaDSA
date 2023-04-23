public class MinimumPartition {

    public static int minPartition(int arr[]){
        int n = arr.length;
        int sum=0;

        for(int i=0;i<n;i++){
            sum=sum+arr[i];
        }
        int w = sum/2;

        int dp[][] = new int[n+1][w+1];

        //initialization

        for(int i=0 ; i<n+1 ;i++){
            dp[0][i]=0;
        }

        for(int i=0 ; i<n+1 ;i++){
            dp[i][0]=0;
        }

        //bottom up
        // 0-1 knapsack code for sum1 = set1 number
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(arr[i-1]<=j){
                    int include = arr[i-1]+dp[i-1][j-arr[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j]=Math.max(include,exclude);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][w];
        int sum2 = sum-sum1;
        return Math.abs(sum2-sum1);



    }
    public static void main(String[] args) {
        int number[] = {1,6,11,5};
        System.out.println(minPartition(number));

    }
}
