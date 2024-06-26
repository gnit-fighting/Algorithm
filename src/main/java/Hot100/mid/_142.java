package Hot100.mid;

import Hot100.easy.ListNode;

import java.util.List;

public class _142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return  null;
        }
        ListNode fast = head;
        ListNode slow = head;

        //找相遇节点（如果没有环，fast、slow 会走到 null）
        do {
            if(fast.next==null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast==null || slow==null){
                return  null;
            }
        }while (fast != slow);
        //出循环时，fast==slow
        ListNode p = head;
        //定义一个 p 指针从头节点出发，slow 从相遇节点出发，当 p 和 slowi 相遇，就是环的入口
        while (p!=slow){
            p = p.next;
            slow = slow.next;
        }
        return p;

    }
}
