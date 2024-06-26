package Hot100.mid;

import Hot100.easy.ListNode;

/**
 * 两两交换链表的节点
 */
public class _24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyhead = new ListNode(0, head);
        ListNode cur = dummyhead;
        ListNode p = cur.next;
        if(p==null){
            return  dummyhead.next;
        }
        ListNode q = p.next;
        if(q==null){
            return  dummyhead.next;
        }
        ListNode r = q.next;
        while (true) {
            cur.next = q;
            q.next = p;
            p.next = r;

            cur = p;
            if (cur.next == null) {
                return dummyhead.next;
            }
            p = cur.next;
            if(cur.next.next==null){
                return  dummyhead.next;
            }
            q = p.next;
            r = q.next;
        }


    }
}
