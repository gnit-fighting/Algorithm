package Hot100.easy;

/**
 * 翻转链表
 */
public class _206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode r = cur.next;

        while (true) {
            cur.next = pre;
            pre = cur;
            cur = r;
            if(cur ==null){
                return pre;
            }
            r = cur.next;
        }

    }
}
