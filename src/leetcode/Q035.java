package leetcode;

/**
 * Created by jinchuyang on 2018/3/20.
 */
public class Q035 {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while(i < nums.length && nums[i] < target){
            i++;
        }

        return i;
    }
}
