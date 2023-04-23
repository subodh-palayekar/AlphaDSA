public class StockProfit{
    /*Question: You are given an array prices where prices[i] is the price of a given stock on the ith day.
      You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
      Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     */


    public static void main(String[] args) {
        // int price[]={7,1,5,3,6,4};
        int price[]={5,4,3,2,1};
        stocks(price);
    }

    public static void stocks(int arr[]){
        int n=arr.length;
        int buyP=Integer.MAX_VALUE;
        int maxProfit=0;
        
        for(int i=0;i<n;i++){
            int sellP=arr[i];
            int profit = sellP - buyP;
            
            if(profit<0){
                buyP=arr[i];
                maxProfit=0;
            }
            // if(buyP<sellP){
            //     int profit = sellP - buyP;
            //     maxProfit=Math.max(maxProfit,profit);
            //    }else{
            //        buyP=sellP;
            //    } Alternative Code

    
            maxProfit=Math.max(maxProfit,profit);
        }
        System.out.println(maxProfit);
    }

}