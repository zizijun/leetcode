package leetcode;

/**
 * Created by jinchuyang on 2018/4/19.
 */
public class Q124 {
    static int ans;
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(3);
        n1.right = new TreeNode(-3);
        System.out.println(maxPathSum(new TreeNode(-3)));
    }
    public static int maxPathSum(TreeNode root){
        ans = Integer.MIN_VALUE;
        if (root == null){return 0;}
        dfs(root);
        return ans;
    }
    public static int dfs(TreeNode root) {
        if (root == null){return 0;}
        int l = Math.max(0, dfs(root.left));
        int r = Math.max(0, dfs(root.right));
        ans = Math.max(ans, Math.max(l ,Math.max(r , r + l)) + root.val);
        return root.val + Math.max(r, l);
    }
}
