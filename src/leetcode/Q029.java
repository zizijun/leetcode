package leetcode;

/**
 * Created by jinchuyang on 2018/4/11.
 */
public class Q029 {
    public static void main(String[] args) {
        divide(-2147483648, -1);
    }
    public static int divide(int dividend, int divisor) {
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        int flag = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long) divisor);
        long lans = 0;
        lans = divide(ldividend, ldivisor);
        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (flag == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (flag * lans);
        }
        return ans;
    }

    /**
     * 递归得到除数
     * @param ldividend
     * @param ldivisor
     * @return
     */
    private static long divide(long ldividend, long ldivisor) {
        if(ldividend < ldivisor){return 0;}

        long sum = ldivisor;
        long mutiple = 1;
        while((sum + sum) <= ldividend){
            sum += sum;
            mutiple += mutiple;
        }
        return mutiple + divide(ldividend - sum, ldivisor);
    }
}
