package Hot100.easy;

import java.util.List;

/**
 * 合并两个有序链表
 */
public class _21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode dummyhead = new ListNode(0);
        ListNode pre = dummyhead;


        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                pre.next = p1;
                p1 = p1.next;
                pre = pre.next;
            } else {
                pre.next = p2;
                p2 = p2.next;
                pre = pre.next;
            }

        }
        while (p1 != null) {
            pre.next = p1;
            p1 = p1.next;
            pre = pre.next;
        }
        while (p2 != null) {
            pre.next = p2;
            p2 = p2.next;
            pre = pre.next;
        }
        return dummyhead.next;
    }
}
