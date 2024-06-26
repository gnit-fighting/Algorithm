package Hot100.mid;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 随机链表的复制
 */
public class _138 {
    public Node copyRandomList(Node head) {
        //定义一个 map，保存原链表节点和复制链表节点的对应关系
        Map<Node, Node> map = new HashMap<>();

        //遍历原链表，开始复制链表，并记录原链表节点和复制链表节点的对应关系
        Node p = head;
        Node dummyhead = new Node(-1);
        Node pre = dummyhead; //pre指向复制链表的前一个节点
        while (p != null) {
            Node node = new Node(p.val); //新建复制节点
            node.next = null;
            pre.next = node;
            pre = node;

            map.put(p, node);

            p = p.next;
        }

        //处理复制链表的 random 指针
        p = head; //原链表的遍历节点
        Node q = dummyhead.next;  //复制链表的遍历节点
        while (p != null) {
            Node origin_random = p.random;
            Node copy_random = map.get(origin_random);
            q.random = copy_random;

            p = p.next;
            q = q.next;
        }
        return dummyhead.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
