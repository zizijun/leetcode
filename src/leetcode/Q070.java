package leetcode;
/**
 * Created by jinchuyang on 2017/12/16.
 */
public class Q070 {
    //裴波那切数列
    public int climbStairs(int n) {
        if(n <= 0){return 0;}
        if(n == 1){return 1;}
        int step[] = new int[n + 1];
        step[0] = 1;
        step[1] = 1;
        for(int i = 2; i <= n; i++){
            step[i] = step[i - 1] + step[i - 2];
        }
        return step[n];
    }
}
