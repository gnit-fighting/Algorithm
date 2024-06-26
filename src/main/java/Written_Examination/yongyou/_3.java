package Written_Examination.yongyou;


import java.util.*;

public class _3 {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node6 = new ListNode(6);
        node6.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node6;
        ListNode listNode = new _3().groupSort(node1, 2);
    }

    public ListNode groupSort(ListNode head, int n) {
        // write code here
        if (n == 1) {
            return head;
        }
        ListNode dummyhead = new ListNode(-1);
        ListNode pre = dummyhead;
        pre.next = null;

        ListNode p = head;
        int step = 0;

        while (true) {
            List<ListNode> list = new ArrayList<>();
            while (step != n) {
                //不够一组
                if (p == null) {
                    return dummyhead.next;
                }
                list.add(p);
                step++;
                p = p.next;
            }
            list.sort((o1, o2) -> {
                return o2.val - o1.val;
            });
            for (int i = 0; i < list.size(); i++) {
                ListNode node = list.get(i);
                pre.next = node;
                pre = pre.next;
            }
            pre.next = null;

            //此时 p 指向下一组的头
            step = 0;
            if (p == null) {
                return dummyhead.next;
            }
        }

    }
}
