public class TargetSum {

    // Return true if Any subset Exist which sum is equal to targetSum

    public static boolean targetSum(int arr[],int targetSum){
        int n=arr.length;
        boolean dp[][] = new boolean[n+1][targetSum+1];

        // initialize first column as true
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int v = arr[i-1];
                // include if valid
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }
                // exclude
                else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
        return dp[n][targetSum];

    }
    public static void main(String[] args) {
        int number[]={4,2,7,1,3};
        int targetSum = 10;

        System.out.println(targetSum(number, targetSum));

        
    }
}
