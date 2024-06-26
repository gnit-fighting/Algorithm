package Hot100.mid;

import Hot100.easy.ListNode;

/**
 * 删除链表的倒数第 n 个节点
 */
public class _19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //快慢指针
        ListNode dummyhead = new ListNode(-1,head);
        ListNode fast =  dummyhead;
        ListNode slow =  dummyhead;

        //fast指针先走 n 步，
        //fast 和 slow 一起走
        //当 fast 指向最后一个节点（fast.next==null）时，
        //slow 指向倒数第 n 个节点的前一个

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        //到这里，fast.next==null
        slow.next = slow.next.next; //删除倒数第 n 个节点


        return  dummyhead.next;
    }
}
