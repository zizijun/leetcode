package leetcode.Q746;

/**
 * Created by jinchuyang on 2018/1/15.
 */
public class Q746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length <= 2){return 0;}
        int pay[] = new int[cost.length + 1];
        pay[0] = 0;
        pay[1] = 0;
        for(int i = 2; i < pay.length; i++){
            pay[i] = Math.min(pay[i - 1] + cost[i - 1], pay[i - 2] + cost[i - 2]);
        }
        return pay[cost.length];
    }
}
