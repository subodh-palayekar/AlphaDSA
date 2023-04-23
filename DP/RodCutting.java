public class RodCutting {

    /*Given a rod of length ‘N’ units. The rod can be cut into different sizes and each size has a cost 
     * associated with it. Determine the maximum cost obtained by cutting the rod and selling its pieces.
     */


    public static int rodCutting(int length[],int price[],int totRod){

        //Creation
        int dp[][] = new int[price.length+1][totRod+1];

        // initialization
        // i = price(piece count) j=length

        for(int i=0;i<price.length+1;i++){
            for(int j=0;j<totRod+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1;i<price.length+1;i++){
            for(int j=1;j<totRod+1;j++){
                if(length[i-1]<=j) { // valid
                    int include = price[i-1] + dp[i][j-length[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j]=Math.max(include, exclude);
                }else{  //invalid
                    dp[i][j]=dp[i-1][j];

                }
            }
        }

        return dp[price.length][totRod];



    }
    public static void main(String[] args) {
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int totRod =8;

        System.out.println(rodCutting(length, price, totRod));
    }
}
