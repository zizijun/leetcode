package Q147;

import common.ListNode;

/**
 * Created by jinchuyang on 2017/11/22.
 */
public class main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        listNode.next = listNode1;
        insertionSortList(listNode);
    }
    public static ListNode insertionSortList(ListNode head) {
        if(head == null){return head;}
        ListNode dummy = new ListNode(0);
        ListNode currNode = head;
        while(currNode != null){
            ListNode next = currNode.next;//currNode的next会被覆盖，所以要先保存下来
            ListNode curr = currNode;
            ListNode dummys = dummy;
            while(dummys.next != null){
                if(dummys.next.val > curr.val){
                    break;
                }
                dummys = dummys.next;
            }
            curr.next = dummys.next;
            dummys.next = curr;
            currNode = next;
        }
        return dummy.next;
    }
}
