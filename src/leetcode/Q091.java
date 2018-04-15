package leetcode;

/**
 * Created by jinchuyang on 2018/1/23.
 */

/**
 * 这道题的动归思路：从后往前计算，当前能分解的code数量nums[i]是先需要判断i与i+1组成的数字能否解码为字母即小于等于26；
 * 如果大于26，即为nums[i + 1]能够解码的数量；
 * 如果小于等于26，即分为两位与一位，即计算nums[i + 1]与nums[i + 2]只和;
 * 如果最后一位为零时，则对应的nums[n - 1]为0；
 */
public class Q091 {
    public static void main(String[] args) {
        String s = "1234";
        System.out.println(s.substring(2, 4));
    }
    public static int numDecodings(String s) {
        int length = s.length();
        if(length == 0) return 0;

        int[] nums = new int[length + 1];
        nums[length] = 1;
        nums[length - 1] = s.charAt(length - 1) == '0' ? 0 : 1;

        for(int i = length - 2; i >= 0; i--){
            if(s.charAt(i) == '0') continue;//如果出现0，首位为零是不存在的
            else nums[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? nums[i + 1] + nums[i + 2] : nums[i + 1];
        }
        return nums[0];
    }

}
