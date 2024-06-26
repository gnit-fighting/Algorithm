package Hot100.easy;

import java.util.List;

public class _141 {
    public boolean hasCycle(ListNode head) {
        //判断环形链表
        //快指针：每次走两步
        //满指针 ： 每次走一步
        //如果有环，快慢指针一定会相遇
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null) {

            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast && slow!=null) {
                return true;
            }


        }
        return false;
    }

    public boolean hasCycle0(ListNode head) {
        //快慢指针，
        //快指针每次走两步
        //满指针每次走一步
        //如果两指针相遇，一定有环
        if(head==null){
            return  false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if(fast==null ||slow ==null){
                return  false;
            }
            if(fast.next==null ){
                return false;
            }
            fast = fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return  true;
            }
        }

    }
}
