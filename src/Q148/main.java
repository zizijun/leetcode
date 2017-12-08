package Q148;

import common.ListNode;

import java.util.Arrays;

/**
 * Created by jinchuyang on 2017/10/10.
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class main {
    /**
     * 这个方法不是很好，在本题中主要考核排序方法，需要自己实现，如果其他机试题重点不是排序，可以用Arrays.sort，若面试时遇到，可以向面试官提出这种方面，然后再用具体方法实现
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        if(head == null) return head;
        ListNode dummy = head;
        int len = 0;
        while(dummy != null){
            len++;
            dummy = dummy.next;
        }
        int nums[] = new int[len];
        dummy = head;
        for(int i = 0; i < len; i++){
            nums[i] = dummy.val;
            dummy = dummy.next;
        }
        Arrays.sort(nums);
        dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int i = 0; i < len; i++){
            ListNode next = new ListNode(nums[i]);
            curr.next = next;
            curr = next;
        }
        return dummy.next;
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null, fast = head, slow = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //将链表截断
        prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), prev = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;

        }
        if (l1 != null){
            prev.next = l1;
        }
        if (l2 != null){
            prev.next = l2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        ListNode listNode = sortList(head);
    }
}
