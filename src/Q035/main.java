package Q035;

/**
 * Created by jinchuyang on 2018/3/20.
 */
public class main {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while(i < nums.length && nums[i] < target){
            i++;
        }

        return i;
    }
}
