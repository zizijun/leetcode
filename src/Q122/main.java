package Q122;

/**
 * Created by jinchuyang on 2018/1/16.
 */
public class main {
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
}
