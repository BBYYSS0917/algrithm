package array;

/**
 * @author Donquixote
 * @date 2023/02/12
 **/
public class Stock {
    public static void main(String[] args) {
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int index = 0;
        int totalProfit = 0;
        while (index < prices.length - 1) {
            int diff = prices[index + 1] - prices[index];
            if (diff > 0) {
                totalProfit += diff;
            }
            index++;
        }
        return totalProfit;
    }
}
