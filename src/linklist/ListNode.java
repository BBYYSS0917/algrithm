package linklist;

/**
 * @author BaiJY
 * @date 2022/10/27
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
//
        n1.next = n2;
        n2.next = n3;
        ListNode head = Solution.reverseList(n1);
        System.out.println(head.val);

        System.out.println(Solution.reverseList(n1).val);
//        System.out.println(Solution.reverseList(n1).next.val);
        System.out.println(n2.val);
        System.out.println(n2.next.val);
//        n1.next = n2;
//        ListNode tmp = n1;
//        System.out.println(tmp.val);
//        n1.val = 11;
//        System.out.println(tmp.val);
    }


// 1->2-> 3-> null
// nullp<-1c 2n-> 3 null
// null 1p 2c 3n null
// null 1 2p 3c nnull

    static class Solution {
        public static ListNode reverseList(ListNode head) {
            // 每次拿到三个节点，前一个，当前，下一个，当前节点指向前一个节点，

            if (head == null) {
                return null;
            }
            ListNode pre = null;


            while (true) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                if (next == null) {
                    break;
                }
                head = next;
            }

            return head;
        }
    }

}
