package linklist;

import utils.Utils;

/**
 * @author BaiJY
 * @date 2023/02/27
 **/
public class ReversePrint {


    //记录数组的长度，按索引值更改
    public static int[] reversePrint(ListNode2 head) {

        if (head == null) {
            return new int[0];
        }
        ListNode2 pre = null;

        int size = 0;
        while (true) {
            size++;
            ListNode2 next = head.next;
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


    public static ListNode2 reverseList(ListNode2 head) {

        return null;
    }

    public static ListNode2 recur(ListNode2 cur, ListNode2 pre) {
        if (cur == null) {
            //只有递归到尾结点才能得到返回值
            //用递归方法栈的方式存储每个节点
            return pre;
        }
        //从下个节点开始递归，否则死循环
        ListNode2 res = recur(cur.next, cur);
        cur.next = pre;

        return res;
    }

    public static void main(String[] args) {

        ListNode2 l1 = new ListNode2(1);
        ListNode2 l2 = new ListNode2(2);
        ListNode2 l3 = new ListNode2(3);
        l1.next = l2;
        l2.next = l3;

        Utils.printIntArr(reversePrint(l1));

    }


}
