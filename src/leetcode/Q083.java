package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jinchuyang on 2017/12/3.
 */
public class Q083 {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;

        deleteDuplicates(n1);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){return head;}
        Set<Integer> set = new HashSet<Integer>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode iter = dummy;
        while(iter.next != null){
            int val = iter.next.val;
            if (set.contains(val)){
                iter.next = iter.next.next;
            }else {
                set.add(val);
                iter = iter.next;
            }

        }

        return dummy.next;
    }
}
