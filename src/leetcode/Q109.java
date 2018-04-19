package leetcode;

/**
 * Created by jinchuyang on 2017/12/2.
 */
public class Q109 {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(-10);
        ListNode n1 = new ListNode(-3);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(9);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        sortedListToBST(n0);
    }
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null){return null;}

        int size = 0;
        ListNode node = head;
        while(node != null){
            size++;
            node = node.next;
        }
        node = head;
        return buildBST(node, 0, size - 1);
    }

    public static TreeNode buildBST(ListNode node, int begin, int end){
        if(begin > end){return null;}

        int mid = begin + (end - begin) / 2;
        TreeNode left = buildBST(node, begin, mid -1);

        TreeNode treeNode = new TreeNode(node.val);
        node = node.next;

        TreeNode right = buildBST(node, mid + 1, end);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }
}
