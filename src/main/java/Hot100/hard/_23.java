package Hot100.hard;

import Hot100.easy.ListNode;

/**
 * 合并 k 个链表
 */
public class _23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyhead = new ListNode(-1);
        ListNode pre = dummyhead;


        ListNode min = null;
        for (int i = 0; i < lists.length - 1; i++) {
            if (lists[i].val < lists[i + 1].val) {
                min = min.val < lists[i].val ? min : lists[i];
            }
        }
        for (int i = 0; i < lists.length; i++) {
            if(min == lists[i]){
                lists[i]= lists[i].next;
                pre.next = min;
                pre = pre.next;
                break;
            }
        }


        return null;

    }
}
