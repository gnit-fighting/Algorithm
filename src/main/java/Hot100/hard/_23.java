package Hot100.hard;

import Hot100.easy.ListNode;

/**
 * 合并 k 个升序链表
 * 暴力解法：
 * 时间复杂度： O（n*k）
 */
public class _23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyhead = new ListNode(-1);
        ListNode pre = dummyhead;

        int minNode =-1;
        do{
            minNode = findMinNode(lists);
            if (minNode>=0) {
                pre.next = lists[minNode];
                pre = pre.next;
                lists[minNode] = lists[minNode].next;
            }
        }while (minNode!=-1);

        return dummyhead.next;
    }
    public int findMinNode(ListNode[] lists){
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                minIdx = i;
                min = lists[i].val;
            }
        }
        return minIdx;
    }
}
