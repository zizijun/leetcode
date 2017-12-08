package Q015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The idea is to sort an input array and then run through all indices of a possible first element of a triplet.
 * For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array.
 * Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
 */
public class main {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> listList = threeSum(nums);
        System.out.println(listList.size());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> listList = new ArrayList<>();
        for(int i = 0; i < nums.length-2;i++){
            if (i == 0 || (i >0 && nums[i] != nums[i-1])){
                int middle = i+1, high = nums.length-1,sum = 0 -nums[i];
                while (middle < high){
                    if (nums[middle] + nums[high] == sum){
                        listList.add(Arrays.asList(nums[i], nums[middle], nums[high]));
                        while (middle < high && nums[middle] == nums[middle+1]) middle++;
                        while (middle < high && nums[high] == nums[high-1]) high--;
                        middle++;high--;
                    }else if(nums[middle] + nums[high] > sum){
                        high--;
                    }else {
                        middle++;
                    }
                }
            }
        }
        return listList;
    }
}
