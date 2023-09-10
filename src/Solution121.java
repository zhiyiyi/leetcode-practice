public class Solution121 {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length;i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7,1,5,3,6,4 };
        System.out.println(maxProfit(prices));
    }
}
