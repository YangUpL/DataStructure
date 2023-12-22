package LinkedList_;

public class two {
    public static void main(String[] args) {

    }


    //1ms
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int total = 0;
        int nextAdd = 0;

        ListNode resultNode = new ListNode();
        ListNode curNode = resultNode;

        while (l1 != null && l2 != null){
            total = l1.val + l2.val + nextAdd;

            curNode.next = new ListNode(total % 10);

            nextAdd = total / 10;

            l1 = l1.next;
            l2 = l2.next;
            curNode = curNode.next;
        }

        while (l1 != null){
            total = l1.val + nextAdd;
            curNode.next = new ListNode(total % 10);

            nextAdd = total / 10;

            l1 = l1.next;
            curNode = curNode.next;
        }


        while (l2 != null){
            total = l2.val + nextAdd;
            curNode.next = new ListNode(total % 10);

            nextAdd = total / 10;

            l2 = l2.next;
            curNode = curNode.next;
        }

        if(nextAdd != 0){
            curNode.next = new ListNode(nextAdd);
        }

        return resultNode.next;
    }

}



class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

