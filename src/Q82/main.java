package Q82;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jinchuyang on 2017/12/4.
 */
public class main {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){return head;}
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ListNode iter = head;
        while(iter != null){
            Integer val = iter.val;
            Integer time = 0;
            if(map.containsKey(val)){
                time = map.get(val);
            }
            time++;
            map.put(val, time);
            iter = iter.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        iter = dummy;
        while(iter.next != null){
            ListNode next = iter.next;
            Integer time = map.get(next.val);
            if(time != 1){
                iter.next = next.next;
            }else {
                iter = iter.next;
            }
        }
        return dummy.next;
    }
}
