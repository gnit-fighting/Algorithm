package Hot100.mid;

import Hot100.easy.ListNode;

import javax.xml.stream.XMLInputFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * 排序链表
 */
public class _148 {
    public ListNode sortList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        list.sort((o1, o2) -> {
            return o1 - o2;
        });
        p = head;
        for (int i = 0; i < list.size(); i++) {
            p.val = list.get(i);
            p = p.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode l3 = new ListNode(3);
        ListNode l1 = new ListNode(1, l3);
        ListNode l2 = new ListNode(2, l1);
        ListNode l4 = new ListNode(4, l2);
        sortList(l4);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //找中点 - 把链表分成左右两个链表
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //根据 mid把链表分成左右两个半链表
        ListNode righthead = slow.next;
        slow.next = null;
        ListNode llist = sortList(head);
        ListNode rlist = sortList(righthead);
        //merge
        ListNode dummyhead = new ListNode(-1);
        ListNode pre = dummyhead;
        ListNode left = llist;
        ListNode right = rlist;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        if (left != null) {
            pre.next = left;
        } else {
            pre.next = right;
        }
        return dummyhead.next;
    }


}
