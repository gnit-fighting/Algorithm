package Hot100.mid;

import Hot100.easy.ListNode;

/**
 * 两数相加
 */
public class _2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //链表存的数字是倒序的，
        //设置并计算进位 ，可以很好的直接一边遍历链表一边计算
        ListNode p1 = l1;
        ListNode p2 = l2;
        int pre = 0; // 进位
        ListNode dummyhead = new ListNode(0);
        ListNode p = dummyhead;
        int p1val = 0;
        int p2val = 0;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                p1val = 0;
            } else {
                p1val = p1.val;
            }
            if (p2 == null) {
                p2val = 0;
            } else {
                p2val = p2.val;
            }
            int sum = p1val + p2val + pre;
            if (sum >= 10) {
                pre = 1;
            } else {
                pre = 0;
            }
            ListNode listNode = new ListNode(sum % 10);
            p.next = listNode;
            p = p.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }


        }
        //注意是否存在最后一个进位！！
        if (pre == 1) {
            ListNode listNode = new ListNode(pre);
            p.next = listNode;

        }

        return dummyhead.next;

    }
}
