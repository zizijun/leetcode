package Q86;

import common.ListNode;

/**
 * Created by jinchuyang on 2017/12/3.
 */
public class main {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(2);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        partition(n0, 3);
    }

    public static ListNode partition(ListNode head, int x) {
        if(head ==  null){return head;}
        ListNode dummy = new ListNode(0), iter = dummy;
        dummy.next = head;
        int site = 0;
        while(iter.next != null){
            ListNode node = iter.next;
            int val = node.val;
            if(val < x){
                iter.next = node.next;
                ListNode iter1 = head;
                while(iter1.next != null && iter1.next.val < val){
                    iter1 = iter1.next;
                }
                node.next = iter.next;
                iter.next = node;
            }
            iter = iter.next;

        }
        return dummy.next;
    }
}
