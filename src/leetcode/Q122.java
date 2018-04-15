package leetcode;

/**
 * Created by jinchuyang on 2018/1/16.
 */
public class Q122 {
    public static void main(String[] args) {
        int[] prices = {1,2, 3};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices)  {
        if(prices.length <= 1){return 0;}
        int total = 0;
        for(int i = 1; i < prices.length; i++){
            total += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return total;
    }

    /**
     * T_ik0表示在i天，做了k笔交易，手上没有股票的情况，T_ik1表示在i天，做了k笔交易，手上有股票的情况
     * 当第一天的时候，T_ik1是不存在的
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }

        return T_ik0;
    }
}
