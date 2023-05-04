package linklist;

public class GetKthFromEnd {


  private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public ListNode solution(ListNode head, int k) {

    ListNode p1=head;
    ListNode p2=head;

    for(int i=1;i<=(k-1);i++){
        p1=p1.next;
    }
    while(p1.next!=null){
        p1=p1.next;
        p2=p2.next;
    }
    //倒数第K个节点

    return p2;
  }



    public static void main(String[] args) {
        System.out.println(null==null);
    }
}
