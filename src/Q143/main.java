package Q143;

import common.ListNode;

/**
 * Created by jinchuyang on 2017/11/27.
 */
public class main {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        reorderList(n1);
    }
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){return;}

        ListNode p1 = head, p2 = head;
        // find middle
        while(p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        //reverse half of middle
        ListNode preMiddle = p1;
        ListNode preCurrent = p1.next;
        while(preCurrent.next != null){
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }
        //insert half of middle
        p1 = head;
        p2 =preMiddle.next;
        while(p1 != preMiddle){
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }
}
