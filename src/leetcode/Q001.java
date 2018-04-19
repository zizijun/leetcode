package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jinchuyang on 2017/9/5.
 */
public class Q001 {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int[] result = twoSum3(nums,6);
        System.out.println(result[0] + " " + result[1]);
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
    public static int[] twoSum1(int[] nums, int target) {
        int temp[] = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(temp);
        int i = 0;
        int j = nums.length - 1;
        while(temp[i] + temp[j] != target){
            if(temp[i] + temp[j] < target){
                i++;
            }else{
                j--;
            }
        }


        if(temp[i] == temp[j]){
            boolean isFirstFound = false;
            for(int k = 0; k < nums.length; k++){
                if(!isFirstFound){
                    if(nums[k] == temp[i]){
                        i = k;
                        isFirstFound = true;
                    }
                }else if(nums[k] == temp[j]){
                    j = k;
                }
            }
        }else{
            boolean found1 = false;
            boolean found2 = false;
            for(int k = 0; k < nums.length; k++){
                if(!found1 && nums[k] == temp[i]){
                    i = k;
                    found1 = true;
                }
                if(!found2 && nums[k] == temp[j]){
                    j = k;
                    found2 = true;
                }
            }
        }
        int[] result = new int[2];
        result[0] = Math.min(i, j);
        result[1] = Math.max(i, j);
        return result;
    }
    public static int[] twoSum3(int[] nums, int target) {
        int temp[] = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            temp[i] = nums[i];
        }
        int i = 0;
        int j = nums.length - 1;
        while(temp[i] + temp[j] != target){
            if(temp[i] + temp[j] < target){
                i++;
            }else{
                j--;
            }
        }
        int[] result = new int[2];
        result[0] = Math.min(map.get(nums[i]), map.get(nums[j]));
        result[1] = Math.max(map.get(nums[i]), map.get(nums[j]));
        return result;
    }
}
