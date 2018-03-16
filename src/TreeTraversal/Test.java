package TreeTraversal;

/**
 * Created by jinchuyang on 2018/3/16.
 */
public class Test {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        head.leftNode = node1;
        head.rightNode = node4;
        node1.leftNode = node2;
        node2.rightNode = node3;
        node3.leftNode = node5;
        node5.leftNode = node6;

//        LDRWithRecursion ldrWithRecursion = new LDRWithRecursion();
//        ldrWithRecursion.traveral(head);
        LDRWithNoRecursion ldrWithNoRecursion = new LDRWithNoRecursion();
        ldrWithNoRecursion.traveral(head);
    }
}
