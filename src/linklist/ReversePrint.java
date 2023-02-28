package linklist;

import utils.Utils;

/**
 * @author BaiJY
 * @date 2023/02/27
 **/
public class ReversePrint {


    //记录数组的长度，按索引值更改
    public static int[] reversePrint(ListNode head) {

        if (head == null) {
            return new int[0];
        }
        ListNode pre = null;

        int size = 0;
        while (true) {
            size++;
            ListNode next = head.next;
            head.next = pre;
            if (next == null) {
                break;
            }
            pre = head;
            head = next;
        }

        int[] arr = new int[size];
        int index = 0;
        while (true) {
            arr[index] = head.val;
            head = head.next;
            index++;
            if (index == size) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        Utils.printIntArr(reversePrint(l1));

    }


}
