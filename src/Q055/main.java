package Q055;

/**
 * Created by jinchuyang on 2018/3/20.
 */
public class main {
    /**
     * 贪心算法：每一步都确定能够跳跃的最大距离，如果最后一个元素在这个距离内则表示可达；
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if(nums.length <= 0){return false;}
        int maxStep = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            maxStep = maxStep > nums[i] ? maxStep : nums[i];
            if(maxStep >= nums.length - i - 1){return true;}
            if(maxStep == 0){return false;}
            maxStep--;
        }
        return false;
    }
}
