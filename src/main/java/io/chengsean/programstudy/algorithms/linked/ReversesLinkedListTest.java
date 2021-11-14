package io.chengsean.programstudy.algorithms.linked;


import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/**
 *
 * @author 程绍壮
 * @dateTime 2020-12-18 23:09
 */
public class ReversesLinkedListTest<T> {
    private static final String[] _NAMES = new String[]{"赵","钱","孙","李","周","吴","郑","王"};
    private static final String _DELIMITER = " —> ";
    private Node<String> head;
    private final StringJoiner before = new StringJoiner(_DELIMITER);

    public ReversesLinkedListTest() {
    }

    public ReversesLinkedListTest(boolean reverse) {
        boolean first = true;
        if (reverse) {
            for (int i = _NAMES.length - 1; i >= 0; i--) {
               first = this.initHead(_NAMES[i], first);
            }
            Arrays.stream(_NAMES).forEach(this.before::add);
        } else {
            for (String name : _NAMES) {
                first = this.initHead(name, first);
            }
            for (int i = _NAMES.length - 1; i >= 0; i--) {
                this.before.add(_NAMES[i]);
            }
        }
    }

    private boolean initHead(String name, boolean first) {
        if (first) {
            this.head = new Node<>(name);
            return false;
        } else {
            Node<String> node = new Node<>(name);
            node.next = this.head;
            this.head = node;
        }
        return false;
    }

    public static void main(String[] args) {
        ReversesLinkedListTest<String> test = new ReversesLinkedListTest<>(true);
        Node<String> reverseNode = test.reverse(test.head);
        StringJoiner after = new StringJoiner(_DELIMITER);
        while (Objects.nonNull(reverseNode.next)) {
            if (Objects.nonNull(reverseNode.data)) {
                after.add(reverseNode.data);
            }
            reverseNode = reverseNode.next;
        }
        after.add(reverseNode.data);
        System.out.printf("反转链表之前：%s%n",test.before);
        System.out.printf("反转链表之后：%s%n",after);
    }

    /**
     * 反转链表
     * before: 赵 —> 钱 —> 孙 —> 李 —> 周 —> 吴 —> 郑 —> 王
     * after: 王 —> 郑 —> 吴 —> 周 —> 李 —> 孙 —> 钱 —> 赵
     * @author 程绍壮
     * @date 2020-12-20 22:40
     * @param head
     * @return io.chengsean.programstudy.algorithms.linked.ReversesLinkedListTest.Node<java.lang.String>
     * @throws
     */
    private Node<String> reverse(Node<String> head) {
        return this.reverse(new Node<>(null), head);
    }

    private Node<String> reverse(Node<String> head, Node<String> next) {
        if (Objects.isNull(next.next)) {
            head.data = next.data;
            return head;
        }
        if (Objects.isNull(head.data)) {
            head.data = next.data;
        }
        Node<String> node = new Node<>(null);
        node.next = head;
        return reverse(node, next.next);
    }


    static class Node<T> {
        private T data;

        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
