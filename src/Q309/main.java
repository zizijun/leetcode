package Q309;

/**
 * Created by jinchuyang on 2018/1/17.
 */
public class main {
    /**
     * 有一个限制，卖了之后必须休息，也就是说买的话，要用前两天的T_ik0
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE, T_ik0_pre = 0;

        for(int price : prices){
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
            T_ik0_pre = T_ik0_old;
        }
        return T_ik0;
    }
}
