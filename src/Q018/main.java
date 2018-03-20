package Q018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jinchuyang on 2018/3/19.
 */
public class main {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        if(length < 4){return res;}
        if(4 * nums[0] > target || 4 * nums[length - 1] < target){return res;}
        for(int i = 0; i < length - 3; i++){  //固定一个元素
            if(nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target){continue;}//比最大的小
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){break;}//比最小的小
            if(i > 0 && nums[i] == nums[i - 1]){continue;}
            //if( 4 * nums[i] == target && i < length - 3 && nums[i] == nums[i + 3]){res.add(Arrays.asList(nums[i], nums[i], nums[i], nums[i]));}

            for(int j = i + 1; j < length - 2; j ++){//固定第二个元素
                if(nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target){continue;}
                if(nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target){ break;}
                if(j > i + 1 && nums[j] == nums[j - 1]){continue;}
                int low = j + 1;
                int high = length - 1;
                while(low < high){
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[low] , nums[high]));
                        while(low < high && nums[low] == nums[low + 1]){low++;}
                        while(low < high && nums[high] == nums[high - 1]){high--;}
                        low++;
                        high--;
                    }else if(sum > target){
                        high--;
                    }else{
                        low++;
                    }
                }
            }
        }

        return res;
    }
}
