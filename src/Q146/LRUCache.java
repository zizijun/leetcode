package Q146;

import java.util.*;

/**
 * Created by jinchuyang on 2018/4/8.
 */
class LRUCache {
    Map<Integer, Node> map;
    Node head, tail;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
        count = 0;
        map = new HashMap<Integer, Node>();
    }

    private void delete(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addFirst(Node node){
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            delete(node);
            addFirst(node);
            return  node.value;
        }else {
            return -1;
        }
    }



    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            delete(node);
            addFirst(node);
        }else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count >= capacity) {
                map.remove(tail.pre.value);
                delete(tail.pre);
                addFirst(node);
            }else {
                addFirst(node);
                count++;
            }
        }
    }


    private class Node{
        int value;
        int key;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }
}
