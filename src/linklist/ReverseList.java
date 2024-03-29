package linklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Donquixote
 * @date 2022/11/02
 **/
public class ReverseList {
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

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        DoubleNode last = null;
        while (true) {
            DoubleNode next = head.next;
            head.last = next;
            head.next = last;

            last = head;
            if (next == null) {
                break;
            }
            head = next;
        }
        return head;
    }

    //不关心head节点，返回pre变量
    public static DoubleNode reverseDoubleList2(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    public static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            cur.last = pre;
            pre = cur;
            size--;
        }
        return head;
    }

    // for test
    public static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    // for test
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // for test
    public static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode head) {
        //正反都测试一遍
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
            end = head;
        }
        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.value)) {
                return false;
            }
            end = end.last;
        }
        return true;
    }

    public static void f(Node head) {
        head = head.next;
    }

    public static void main(String[] args) {

        DoubleNode d1 = new DoubleNode(1);
        DoubleNode d2 = new DoubleNode(2);
        DoubleNode d3 = new DoubleNode(3);
        d1.next = d2;
        d2.last = d1;
        d2.next = d3;
        d3.last = d2;
        List<Integer> originList = getDoubleListOriginOrder(d1);
        System.out.println(Arrays.toString(originList.toArray()));
//        originList.forEach(System.out::println);
        DoubleNode head = reverseDoubleList(d1);
        List<Integer> reverseList = getDoubleListOriginOrder(head);
        System.out.println(Arrays.toString(reverseList.toArray()));
        DoubleNode h = head;
        while (true) {
            System.out.println(h.value);
            h = h.next;
            if (h.next == null) {
                System.out.println("end" + h.value);
                break;
            }
        }
        while (true) {
            System.out.println(h.value);
            h = h.last;
            if (h.last == null) {
                System.out.println("begin" + h.value);
                break;
            }
        }


//        System.out.println(head);

//        return;
//        int len = 50;
//        int value = 100;
//        int testTime = 100000;
//        System.out.println("test begin!");
//        for (int i = 0; i < testTime; i++) {
//
//            DoubleNode node3 = generateRandomDoubleList(len, value);
//            List<Integer> list3 = getDoubleListOriginOrder(node3);
//            node3 = reverseDoubleList(node3);
//            if (!checkDoubleListReverse(list3, node3)) {
//                System.out.println("Oops3!");
//            }
//
//            DoubleNode node4 = generateRandomDoubleList(len, value);
//            List<Integer> list4 = getDoubleListOriginOrder(node4);
//            node4 = reverseDoubleList(node4);
//            if (!checkDoubleListReverse(list4, node4)) {
//                System.out.println("Oops4!");
//            }
//
//        }
    }

}
