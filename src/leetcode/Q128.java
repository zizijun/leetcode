package leetcode;

/**
 * Created by jinchuyang on 2017/11/30.
 */
public class Q128 {

    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = n2;
        n3.random = n5;
        copyRandomList(n1);
    }

    /**
     * 我觉得好像没什么问题
     * @param head
     * @return
     */
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return head;
        }
        RandomListNode node = head, next = null;
        while(node != null){
            next = node.next;
            RandomListNode rln = new RandomListNode(node.label);
            rln.next = next;
            node.next = rln;
            node = next;
        }
        node = head;
        while(node != null){
            if(node.random != null){
                node.next.random = new RandomListNode(node.random.label);
            }
            node = node.next.next;
        }

        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copy, copyIter = dummy;
        node = head;
        while(node != null && node.next != null){
            next = node.next.next;
            copy = node.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            node.next = next;

            node = next;
        }
        return dummy.next;
    }
}
