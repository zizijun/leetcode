package leetcode;

/**
 * Created by jinchuyang on 2017/12/15.
 */
public class Q121 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){return 0;}
        int n = prices.length;
        int profit[] = new int[n];
        profit[0] = 0;
        int min = prices[0];
        for(int i = 1; i < n; i++){

            profit[i] = Math.max(profit[i - 1], prices[i] - min);
            min = (min > prices[i]) ? prices[i] : min;
        }
        return profit[n - 1];
    }
}
