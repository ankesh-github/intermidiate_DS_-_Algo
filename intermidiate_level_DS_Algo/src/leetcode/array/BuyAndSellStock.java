package leetcode.array;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,2,7,9,3,1};
        //System.out.println(maxProfit(prices)); // Output: 5

        // Using two pointers approach
        // time complexity: O(n)
        //int maxProfit = maxProfitUsingTwoPointers(prices);

        int maxProfit = findMaxProfit(prices);
        System.out.println("Max Profit: " + maxProfit); // Output: 0

    }

    private static int findMaxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuyPrice = prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i] < minBuyPrice){
                minBuyPrice = prices[i];
            }
            if(prices[i] - minBuyPrice > maxProfit){
                maxProfit = prices[i] - minBuyPrice;
            }

        }
        return maxProfit;
    }

    private static int maxProfitUsingTwoPointers(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int maxProfit = 0;
        int left = 0;
        int right = 1;

        while(right < prices.length){
            if(prices[right] > prices[left]){
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[j] > prices[i]){
                    int profit = prices[j] - prices[i];
                    if(profit > maxProfit){
                        maxProfit = profit;
                    }

                }

            }

        }
        return maxProfit;
    }
}
