package leetcode.Q011;

/**
 * Created by jinchuyang on 2018/3/19.
 */
public class Q011 {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;

        int left = 0, right = height.length - 1;
        while(left < right){
            int area = (height[left] > height[right] ? height[right] : height[left]) * (right - left);
            max = max > area ? max : area;
            if(height[left] > height[right]){ //比较左右两边的高度，哪边比较小，哪边往中间移动
                right--;
            }else{
                left++;
            }
        }
        return max;
    }
}
