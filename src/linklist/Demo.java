package linklist;

/**
 * @author BaiJY
 * @date 2022/08/30
 **/
public class Demo {
    // 翻转链表

    // 注意避免JVM垃圾回收，头结点一定要返回

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }


    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }

    public static void f(Node n) {
        n = n.next;
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);

        f(n1);
        System.out.println(n1.value);


    }

    public static Node reverseLinkedList(Node head) {
        // 找到单次递归的重复操作和递归的停止条件
        return null;
    }

    public static DoubleNode reverseDoubleLinkedList(DoubleNode doubleNode) {
        return null;
    }

    // TODO: 单链表逆序
    // TODO: 双链表逆序
    // TODO:单链表实现队列和栈
    // TODO:测试用例
    // TODO: 链表结构实现队列（两端存取值
}
