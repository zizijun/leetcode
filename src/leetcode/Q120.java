package leetcode.Q120;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinchuyang on 2018/1/18.
 */
public class Q120 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();l1.add(-1);
        List<Integer> l2 = new ArrayList<>();l2.add(3);l2.add(2);
        List<Integer> l3 = new ArrayList<>();l3.add(1);l3.add(-2);l3.add(-1);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(l1);triangle.add(l2);triangle.add(l3);
        minimumTotal(triangle);
    }

    /**
     * 注意啊 这个链表里面的横纵坐标与二维数组不一样
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        if (length == 0) return 0;
        int l[][] = new int[length][length];
        l[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < length; i++){
            l[0][i] = l[0][i - 1] + triangle.get(i).get(0);
            l[i][i] = l[i - 1][i - 1] + triangle.get(i).get(i);
        }
        for (int i = 2; i < length; i++){
            for (int j = 1; j < i; j++){
                l[j][i] = Math.min(l[j - 1][i - 1], l[j][i - 1]) + triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            min = Math.min(min, l[i][length - 1]);
        }
        return min;
    }
}
