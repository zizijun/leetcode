package leetcode.Q740;

/**
 * Created by jinchuyang on 2017/12/11.
 */

/**
 * If we sort all the numbers into buckets indexed by these numbers, this is essentially asking you to repetitively take an bucket while giving up the 2 buckets next to it. (the range of these numbers is [1, 10000])

     The optimal final result can be derived by keep updating 2 variables skip_i, take_i, which stands for:
     skip_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you skip the ith bucket.
     take_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you take the ith bucket.

     DP formula:
     take[i] = skip[i-1] + values[i];
     skip[i] = Math.max(skip[i-1], take[i-1]);
     take[i] can only be derived from: if you skipped the [i-1]th bucket, and you take bucket[i].
     skip[i] through, can be derived from either take[i-1] or skip[i-1], whatever the bigger;
 */
public class Q740 {
    public static void main(String[] args) {
        int nums[] = {2,2,3,3,3,4};
        int max = dae(nums);
        System.out.println(max);
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int dae(int nums[]){
        if(nums.length == 0){return 0;}
        int[] values = new int[100001];
        for(int num : nums)
            values[num] += num;

        int take = 0;
        int skip = 0;
        for(int i = 0; i < 10000; i++){
            int takei = skip + values[i];
            int skipi = Math.max(take, skip);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }
}
