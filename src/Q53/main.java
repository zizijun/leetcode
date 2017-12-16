package Q53;

/**
 * Created by jinchuyang on 2017/12/16.
 */
public class main {
    /**
     * 分析如下:
     一开始比较难想到最简洁的算法。写得很挫。后来找到了简洁的办法。拜。 Kadane's algorithm。
     max_sum 必然是以A[i](取值范围为A[0] ~ A[n-1])结尾的某段构成的，也就是说max_sum的candidate必然是以A[i]结果的。如果遍历每个candidate，然后进行比较，那么就能找到最大的max_sum了。

     假设把A[i]之前的连续段叫做sum。可以很容易想到:

     1. 如果sum>=0，就可以和A[i]拼接在一起构成新的sum'。因为不管A[i]多大，加上一个正数总会更大，这样形成一个新的candidate。

     2. 反之，如果sum<0，就没必要和A[I]拼接在一起了。因为不管A[i]多小，加上一个负数总会更小。此时由于题目要求数组连续，所以没法保留原sum，所以只能让sum等于从A[i]开始的新的一段数了，这一段数字形成新的candidate。

     3. 如果每次得到新的candidate都和全局的max_sum进行比较，那么必然能找到最大的max sum subarray.
     在循环过程中，用max_sum记录历史最大的值。从A[0]到A[n-1]一步一步地进行。

     我的代码:
     上面的分析过程是一个简单的动态规划，这个算法叫做 Kadane's algorithm。时间复杂度显然是O(N)因为数组只被扫描了一遍。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = Integer.MIN_VALUE;
        int max_sum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(sum >= 0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            if(sum > max_sum){
                max_sum = sum;
            }
        }
        return max_sum;
    }
}
