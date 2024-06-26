package Hot100.easy;

import java.util.List;

/**
 * 回文链表
 */
public class _234 {
    public boolean isPalindrome(ListNode head) {
        //比较正序遍历序列 和 反转链表之后的遍历序列
        //想同 -》 是回文的
        //不同 -》 不是回文的
        ListNode p = head;
        StringBuilder sb1 = new StringBuilder();
        while (p != null) {
            sb1.append(p.val);
            p = p.next;
        }

        ListNode newHead = reverseList(head);
        StringBuilder sb2 = new StringBuilder();
        p = newHead;
        while (p != null) {
            sb2.append(p.val);
            p = p.next;
        }

        return sb1.toString().equals(sb2.toString());
    }

    //翻转链表 - 用 p、q、r 模拟一下注意一下边界条件即可
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode q = head;
        ListNode r = q.next;
        while (true) {
            q.next = p;
            p = q;
            q = r;
            if (q == null) {
                return p;
            }
            r = q.next;
        }
    }
}
