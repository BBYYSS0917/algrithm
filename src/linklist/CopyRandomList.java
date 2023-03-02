package linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BaiJY
 * @date 2023/03/01
 **/
public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node Solution(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node res = new Node(head.val);
        map.put(head, res);


        Node point1 = res;
        Node point2 = res;

        Node next = head.next;
        while (next != null) {
            Node node = new Node(next.val);
            point1.next = node;
            map.put(next, node);
            next = next.next;
            point1 = node;
        }

        while (true) {
            Node random = head.random;
            point2.random = map.get(random);

            if (head.next == null) {
                break;
            }

            point2 = point2.next;
            head = head.next;
        }
        return res;
    }

    public static Node Solution2(Node head) {
        if (head == null) {
            return null;
        }
        //copy node list
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        //copy random node
        Node cur2 = head;
        while (cur2 != null) {
            if (cur2.random != null) {
                cur2.next.random = cur2.random.next;
            }
            cur2 = cur2.next.next;
        }

        //split list
        Node newHead = head.next;
        Node cur3 = newHead;
        while (cur3 != null) {
            Node next = cur3.next.next;
            cur3.next = next;
            if (next.next == null) {
                break;
            }
            cur3 = next;
        }


        return newHead;
    }

    public static void printNodeListVal(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            System.out.print(",");
            if (cur.random == null) {
                System.out.print("null");
            } else {
                System.out.print(cur.random.val);
            }
            System.out.print(" ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {

        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node res = Solution2(node1);
//        System.out.println(res.val);
        printNodeListVal(res);
    }
}
