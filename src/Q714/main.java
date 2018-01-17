package Q714;

/**
 * Created by jinchuyang on 2018/1/17.
 */
public class main {
    public int maxProfit(int[] prices, int fee) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
        for(int price : prices){
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price - fee);
        }
        return T_ik0;
    }
}
