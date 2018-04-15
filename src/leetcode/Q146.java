package leetcode.Q146;

/**
 * Created by jinchuyang on 2018/4/8.
 */
public class Q146 {
    public static void main(String[] args) {
        leetcode.Q146.LRUCache lruCache = new leetcode.Q146.LRUCache(1);
        lruCache.put(2, 1);
        //lruCache.put(2, 2);
        lruCache.get(2);
        //lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}
