package Hot100.hard;

import Hot100.easy.ListNode;

/**
 * k 个一组翻转链表
 */
public class _25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyhead = new ListNode(0, head);
        //初识化 pre、cur、q
        ListNode pre;
        ListNode cur = head;
        ListNode q;
        ListNode newhead;
        ListNode newtail;
        ListNode tail = cur; //tail寻找本组的尾巴
        ListNode lasttail = dummyhead;
        while (cur != null) {
            newtail = cur;//cur指向本组未翻转前的第一个节点，也是翻转之后的尾巴

            //找到本组的尾巴
            tail = cur;
            for (int i = 0; i < k - 1; i++) {
                tail = tail.next;
                //如果 tail 没能走完 k 步，则说明剩下的不足 k，不用反转
                if (tail == null) {
                    return dummyhead.next;
                }
            }

            //翻转本组的 k 个节点
            pre = null;//初识化pre 为 null 即可，因为后面会通过上一组的尾巴来连接到本组的新头
            q = cur.next;
            while (cur != tail) {
                cur.next = pre;
                pre = cur;
                cur = q;
                q = cur.next;
            }
            // 出循环时，cur=tail,处理最后一个节点
            cur.next = pre;
            pre = cur; //此时 pre 指向本组的最后一个节点
            cur = q;//此时 cur 指向下一组的头
            newhead = pre; //本组的新头就是 翻转前的最后一个节点

            //上一组的尾巴 连到 这一组的新头
            lasttail.next = newhead;

            //这一组的新尾巴 连到 下一组的头
            newtail.next = cur;

            //更新lasttail
            lasttail = newtail;
        }
        return dummyhead.next;
    }
}
