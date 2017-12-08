package Q001;

/**
 * Created by jinchuyang on 2017/9/5.
 */
public class main {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] result = twoSum(nums,6);
        System.out.println(result.toString());
    }

    public static int[] twoSum(int[] nums, int target) {
        int num1=-1, num2=-1;
        boolean isOK = false;
        for(int i = 0; i < nums.length; i++){
            num1 = i;
            for(int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    num2 = j;
                    isOK = true;
                    break;
                }
            }
            if (isOK){
                break;
            }
        }
        int[] result = {num1, num2};
        return result;
    }
}
