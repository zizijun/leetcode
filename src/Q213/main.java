package Q213;

/**
 * Created by jinchuyang on 2018/1/23.
 */
public class main {
    public int rob(int[] nums) {
        if(nums.length <=1) return nums.length == 1 ? nums[0] : 0;
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    private int rob(int[] nums, int begin, int end){
        int include = 0,exclude = 0;
        for(int j = begin; j <= end; j++){
            int i = include, e = exclude;
            include = e + nums[j];
            exclude = Math.max(i, e);
        }
        return Math.max(include, exclude);
    }

}
