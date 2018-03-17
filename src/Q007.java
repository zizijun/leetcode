/**
 * Created by jinchuyang on 2018/3/17.
 */
public class Q007 {
    public static void main(String[] args) {

    }
    public int reverse(int x) {
        int signed = x > 0 ? 1 : -1;
        int y = Math.abs(x);
        long returnX = 0;
        while( y > 0){
            int gewei = y % 10;
            returnX = returnX * 10 + gewei;
            y /= 10;
        }

        if(returnX > Math.pow(2, 31) - 1){
            return 0;
        }
        return (int) (returnX * signed);
    }


    /**
     * 别的人优美的代码
     */
    public int reverse1(int x) {
        long result = 0;


        for(; x != 0; x /= 10){
            result = result * 10 + x % 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) { return 0; }

        return (int)result;
    }
}
