package Hot100.hard;

import Hot100.easy.ListNode;

import java.util.PriorityQueue;

/**
 * 合并 k 个升序列表
 * 最小堆：时间复杂度O(n*logk)
 */
public class _23_1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyhead = new ListNode(-1);
        ListNode pre = dummyhead;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);//最小堆
        //new PriorityQueue<>(Comparator.reverseOrder()) 最大堆

        for (ListNode listNode :lists) {
            if (listNode!=null) {
                minHeap.add(listNode);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode poll = minHeap.poll();
            pre.next = poll;
            pre = pre.next;

            if (poll.next!=null) {
                minHeap.add(poll.next);
            }
        }

        return dummyhead.next;
    }
}
