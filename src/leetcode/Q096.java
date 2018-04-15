package leetcode.Q96;

/**
 * Created by jinchuyang on 2018/1/18.
 */
public class Q096 {
    /**
     * BST二叉查找树，二叉查找树可以任意取根，只要满足中序遍历有序的要求就可以；
     * 中间节点可以任意取，因此以中间节点分为两边，分解为自问题
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if(n == 1){return 1;}
        int nums[] = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                nums[i] += nums[j - 1] * nums[i - j];
            }

        }
        return nums[n];
    }
}
