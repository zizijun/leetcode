package OJ.weizhong;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/4/16.
 */
public class main3 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        long p = in.nextLong();
//        String str_p = Long.toBinaryString(p);
//        int ans = 0;
//        for (int i = 1; i < str_p.length(); i++) {
//            int b = (i - 1) / 2;
//            ans += (int)Math.pow(2, b);
//        }
//        int form = getForm(str_p, (str_p.length() + 1) / 2);
//        int latter = getLatter(str_p, (str_p.length() + 1) / 2);
//        ans += form > latter ? form - 1 : form;
//        System.out.println(ans);
//    }
//
//    static int getForm(String s, int length){
//        int ans = 0;
//        for (int i = length - 1; i >= 0; i--) {
//            ans += s.charAt(i) == 1 ? Math.pow(2, length - 1 - i) : 0;
//        }
//        return ans;
//    }
//
//    static int getLatter(String s, int length){
//        int ans = 0;
//        for (int i = 0; i < length; i++) {
//            ans += s.charAt(length - 1 - i) == 1 ? Math.pow(2, i) : 0;
//        }
//        return ans;
//    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigDecimal bd = new BigDecimal(sc.nextLine());
        int count = 0;
        long n = bd.longValue();
        for (long i=0;i<=n;i++){
            if (isPalindomeString(i)){
                count++;
            }
        }

        System.out.println(count);
    }
    private static boolean isPalindomeString(long n) {
        String str = Long.toBinaryString(n);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String newStr = new String(sb);
        if(str.equals(newStr)){
            return true;
        }else {
            return false;
        }
    }
}
