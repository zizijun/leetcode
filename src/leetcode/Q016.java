package leetcode.Q016;

import java.util.Arrays;

/**
 * Created by jinchuyang on 2017/9/25.
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class Q016 {
    public static void main(String[] args) {
        int nums[] = {-1, 2, 1, -4};
        int cTarget = fastSolution(nums, 1);
        System.out.println(cTarget);
    }

    public static int mySolution(int[] nums, int target) {
        int cTarget = 0;
        int dif = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -2; i++){
            int middle = i +1, high = nums.length - 1;
            while(middle < high){
                int tempDif = Math.abs(nums[i]+nums[middle]+nums[high]-target);
                if (tempDif<dif){
                    dif = tempDif;
                    cTarget = nums[i]+nums[middle]+nums[high];
                }
                if (nums[i]+nums[middle]+nums[high]-target >0){
                    high--;
                }else {
                    middle++;
                }
            }
        }

        return cTarget;
    }

    public static int fastSolution(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int less = nums[0] + nums[1] + nums[2];
        int more = nums[len - 3] + nums[len - 2] + nums[len - 1];
        if(less >= target) return less;
        if(more <= target) return more;
        for(int i = 0; i < len - 2; i++){
            int min = nums[i] + nums[i + 1] + nums[i + 2];
            if(min > target){
                if(more > min) more = min;
                break;
            }
            int max = nums[i] + nums[len - 2] + nums[len - 1];
            if(max < target){
                if(less < max) less = max;
                continue;
            }
            int low = i + 1;
            int high = len - 1;
            while(low < high){
                int sum = nums[low] + nums[high] + nums[i];
                if(sum == target){
                    return target;
                }else if(sum < target){
                    if(less < sum) less = sum;
                    while(++low < len - 1 && nums[low] == nums[low - 1]) ;
                }else{
                    if(more > sum) more = sum;
                    while(--high > i + 1 && nums[high] == nums[high + 1]) ;
                }
            }
        }
        if(more == target) return less;
        if(less == target) return more;
        if((more - target) > (target - less)){
            return less;
        }
        return more;

    }
}
