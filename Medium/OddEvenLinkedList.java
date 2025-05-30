import Models.ListNode;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;

        ListNode oddNode = head;
        ListNode evenNode = head.next;
        
        ListNode prevOdd;
        ListNode prevEven;

        while(true) {
            if(oddNode.next.next == null & evenNode.next == null) {
                //End of list even total
                break;
                //End of list odd total
            } else if (evenNode.next.next == null) {
                prevOdd = oddNode;
                oddNode = oddNode.next.next;
                prevOdd.next = oddNode;
                break;
            } else {
                prevOdd = oddNode;
                oddNode = oddNode.next.next;
                prevOdd.next = oddNode;

                prevEven = evenNode;
                evenNode = evenNode.next.next;
                prevEven.next = evenNode;
            }
        }
        evenNode.next = null;
        oddNode.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode four = new ListNode(4, null);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        OddEvenLinkedList s = new OddEvenLinkedList();
        System.out.println(s.oddEvenList(one).val);
    }
}
