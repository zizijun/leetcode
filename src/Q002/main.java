package Q002;

import common.ListNode;

/**
 * Created by jinchuyang on 2017/9/25.
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8


 */
public class main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
//        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(3);

        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);

        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;




        ListNode target = addTwoNumbers(node1, node2);
        System.out.println(target.val);
    }

    public static ListNode mySolution(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode iter1 = l1, iter2 = l2, curr = dummyNode;
        int carry = 0;
        while(iter1!= null || iter2 != null){
            int val1 = iter1 != null ? iter1.val : 0;
            int val2 = iter2 != null ? iter2.val : 0;
            carry = val1 + val2 + carry;
            ListNode t = new ListNode(carry % 10);
            carry = carry / 10;
            curr.next = t;
            curr = t;
            if (iter1 != null) {
                iter1 = iter1.next;
            }
            if (iter2 != null) {
                iter2 = iter2.next;
            }
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyNode.next;


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
