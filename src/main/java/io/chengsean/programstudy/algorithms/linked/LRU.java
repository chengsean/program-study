package io.chengsean.programstudy.algorithms.linked;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖镇楼           BUG辟易
//
//                             佛曰:
//
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？

//
//                       .::::.
//                     .::::::::.
//                    :::::::::::  howdy!
//                 ..:::::::::::'
//              '::::::::::::'
//                .::::::::::
//           '::::::::::::::..
//                ..::::::::::::.
//              ``::::::::::::::::
//               ::::``:::::::::'        .:::.
//              ::::'   ':::::'       .::::::::.
//            .::::'      ::::     .:::::::'::::.
//           .:::'       :::::  .:::::::::' ':::::.
//          .::'        :::::.:::::::::'      ':::::.
//         .::'         ::::::::::::::'         ``::::.
//     ...:::           ::::::::::::'              ``::.
//    ```` ':.          ':::::::::'                  ::::..
//                       '.:::::'                    ':'````..
//

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 最近最少使用（LRU）算法
 * @author 程绍壮
 * @datetime 2020-08-08 15:47
 */
public class LRU<K,V> implements Iterable<K> {
    private static final int DEFAULT_CAPACITY = 0X400; // aka 1024
    private final int maxCapacity;
    private final Map<K, Node> nodeMap;
    private final Node head;
    private final Node tail;

    public LRU() {
        this(DEFAULT_CAPACITY);
    }

    public LRU(int maxCapacity) {
        if (maxCapacity < 0) {
            throw new IllegalArgumentException("illegalArgument "+ maxCapacity);
        }
        this.maxCapacity = maxCapacity == 0 ? DEFAULT_CAPACITY : maxCapacity;
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        this.nodeMap = new HashMap<>(this.maxCapacity / 4 * 3);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public void put(K key, V value) {
        Node node;
        if ((node = this.nodeMap.get(key)) != null) {
            this.unlink(node);
        }
        node = new Node(key, value);
        this.appendHead(node);
        this.nodeMap.put(key, node);
        if (this.nodeMap.size() > this.maxCapacity) {
            Node tail = this.removeTail();
            this.nodeMap.remove(tail.key);
        }
    }

    private Node removeTail() {
        Node removeTail = this.tail.pre;
        removeTail.pre.next = this.tail;
        this.tail.pre = removeTail.pre;
        // help GC
        removeTail.pre = null;
        removeTail.next = null;
        return removeTail;
    }

    public V get(K key) {
        Node node = this.nodeMap.get(key);
        if (node != null) {
            this.unlink(node);
            this.appendHead(node);
            return node.value;
        }
        return null;
    }

    private void appendHead(Node node) {
        Node next = this.head.next;
        this.head.next = node;
        node.pre = this.head;
        node.next = next;
        next.pre = node;
    }

    private void unlink(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        // help GC
        node.pre = null;
        node.next = null;
    }

    private class Node {
        private K key;
        private V value;
        private Node pre;
        private Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private Node current = head.next;

            @Override
            public boolean hasNext() {
                return current != tail;
            }

            @Override
            public K next() {
               Node node = current;
               current = current.next;
               return node.key;
            }
        };
    }

    @Override
    public String toString() {
        String clazzName = this.getClass().getSimpleName();
        if (this.nodeMap.isEmpty()) {
            return clazzName + "{}";
        }
        StringBuilder builder = new StringBuilder(this.nodeMap.size());
        builder.append(clazzName).append("[");
        Node node = this.head.next;
        boolean first = true;
        while (node != this.tail) {
            if (first) {
                builder.append("{").append(node.key)
                        .append(",").append(node.value).append("}");
                first = false;
            }
            else {
                builder.append(",").append("{").append(node.key)
                        .append(",").append(node.value).append("}");
            }
            node = node.next;
        }
        return builder.append("]").toString();
    }

    public static void main(String[] args) {
        LRU<String, String> lru = new LRU<>();
        lru.put("bk", "bk");
        lru.put("ak", "ak");
        lru.put("ck", "ck");
        lru.put("dk", "dk");
        System.out.println(lru.get("bk"));
        System.out.println(lru.get("ak"));
        System.out.println(lru);
    }
}
