package Q050;

/**
 * Created by jinchuyang on 2018/4/12.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }
    public static double myPow(double x, int n) {
        if(n == 0){return 1d;}

        //递归二分做
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
