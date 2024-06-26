package Hot100.easy;

/**
 * 相交链表
 */
public class _160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //1.对齐两个链表的尾巴 - 借助求链表长度函数
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        if (lengthA < lengthB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;

            int templen = lengthA;
            lengthA = lengthB;
            lengthB = templen;
        }

        //2.长的链表的遍历指针先走，去对齐
        int step = lengthA - lengthB;
        ListNode p = headA;
        while (step != 0) {
            p = p.next;
            step--;
        }

        //3.长段指针一起遍历，一边遍历一边比较是不是相交的节点
        ListNode q = headB;
        while (p != q && p != null && q != null) {
            p = p.next;
            q = q.next;
        }
        //到这里，q==p 或者 null
        return p;
    }

    public static int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }
}
