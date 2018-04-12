package Q043;

/**
 * Created by jinchuyang on 2018/4/12.
 */
public class Solution {
    public static void main(String[] args) {
        //System.out.println(multiply("88994039749630997005046990281879989302276369350" ,"7107597799709428413456141937460470149011183145188544168453129168495306617"));
        //System.out.println(multiplyLeet("88994039749630997005046990281879989302276369350" ,"7107597799709428413456141937460470149011183145188544168453129168495306617"));
        System.out.println(Math.pow(-1, 0));
    }

    /**
     * 做法：用数组保存结果，而非使用字符串（消耗太大）
     * @param num1
     * @param num2
     * @return
     */
    public static String multiplyLeet(String num1, String num2) {
        int num1_length = num1.length();
        int num2_length = num2.length();
        int[] ans = new int[num1_length + num2_length];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int p1 = i + j, p2 = i + j+ 1;
                int mutiple = a * b;
                int sum = mutiple + ans[p2];
                ans[p2] = sum % 10;
                ans[p1] += sum / 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i : ans) {
            if(!(sb.length() == 0 && i == 0)){
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static String multiply(String num1, String num2) {
        String sum = "0";

        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                String temp = multiply(a, b, num1.length() - 1 - i, num2.length() - 1 - j);
                sum = add(sum, temp);
            }
        }
        return sum;
    }

    private static String add(String sum, String temp) {
        //"12345" + "23467"
        String ans = "";
        int sum_length = sum.length() - 1;
        int temp_length = temp.length() - 1;
        int isJinWei = 0;
        int tzero = 2 * '0';
        while (sum_length >= 0 && temp_length >= 0){
            int sum_num = isJinWei + sum.charAt(sum_length) + temp.charAt(temp_length) - tzero;
            isJinWei = sum_num >= 10 ? 1 : 0;
            ans = (sum_num % 10) + ans;
            sum_length--;
            temp_length--;
        }
        while (sum_length >= 0){
            int sum_num = isJinWei + sum.charAt(sum_length) - '0';
            isJinWei = sum_num >= 10 ? 1 : 0;
            ans = (sum_num % 10) + ans;
            sum_length--;
        }
        while (temp_length >= 0){
            int sum_num = isJinWei + temp.charAt(temp_length) - '0';
            isJinWei = sum_num >= 10 ? 1 : 0;
            ans = (sum_num % 10) + ans;
            temp_length--;
        }
        if (isJinWei == 1){
            ans = "1" + ans;
        }
        return ans;
    }

    private static String multiply(int a, int b, int i, int j) {
        if (a ==0 || b == 0){return "0";}
        StringBuffer sb = new StringBuffer();
        sb.append(a * b);
        for (int k = 0; k < i + j; k++) {
            sb.append(0);
        }
        return sb.toString();
    }



}
