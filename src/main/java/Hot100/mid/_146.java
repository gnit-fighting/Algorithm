package Hot100.mid;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class _146 {


}

class LRUCache {
    class DeListNode {
        int key;
        int value;
        DeListNode pre;
        DeListNode next;

        DeListNode() {
        }

        DeListNode(int key) {
            this.key = key;
        }

        DeListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, DeListNode> map;
    DeListNode dummyhead;
    DeListNode dummytail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
        dummyhead = new DeListNode(-1);//虚拟头节点
        dummytail = new DeListNode(-1);//虚拟尾节点
        dummyhead.next = dummytail;
        dummytail.pre = dummyhead;
    }

    public int get(int key) {
        //判断 key 是否存在（通过 map.get()方法直接判断），不存在返回-1
        DeListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        //若key 存在，从 map 中取出 value - node（DeListNode）
        //把 node 移到双向链表的头部
        node.pre.next = node.next;
        node.next.pre = node.pre;


        node.next = dummyhead.next;
        node.pre = dummyhead;
        node.next.pre = node;
        dummyhead.next = node;

        return node.value;
    }

    public void put(int key, int value) {
        //判断 key 是否存在
        DeListNode node = map.get(key);
        //key存在，更新 key 的 value，并且把 node 移到双向链表的头部
        if (node != null) {
            node.value = value;

            //在原位置删除 node
            node.pre.next = node.next;
            node.next.pre = node.pre;

            //把 node 插入到双向链表的头部
            node.next = dummyhead.next;
            node.pre = dummyhead;
            node.next.pre = node;
            dummyhead.next = node;
            return;
        }

        //key 不存在，新建 node 节点
        DeListNode newNode = new DeListNode(key, value);
        //把 node 添加到 map  并且  插入到双向链表的头部
        map.put(key, newNode);
        newNode.next = dummyhead.next;
        newNode.pre = dummyhead;
        newNode.next.pre = newNode;
        dummyhead.next = newNode;
        size++;
        //检查size是否超过 capacity
        if (size > capacity) {
            //超过，删除双向链表的尾部元素 dummytail.pre.pre.next = dummytail
            DeListNode deletenode = dummytail.pre;
            deletenode.pre.next = dummytail;
            dummytail.pre = deletenode.pre;
            size--;

            //从 map 中删除 k-v
            map.remove(deletenode.key, deletenode);

        }

    }
}

class LRUCache0 extends LinkedHashMap<Integer, Integer> {
    int capacity;


    public LRUCache0(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);

    }

    public void put(int key, int value) {
        super.put(key, value);

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

