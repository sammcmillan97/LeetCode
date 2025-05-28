import Models.ListNode;

public class OddEvenLinkedList {


    public ListNode oddEvenList(ListNode head) {
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode prevOdd;
        ListNode prevEven;

        while(true) {
            if(oddNode.next.next == null & evenNode.next.next == null) {
                //both at the end of there lists no further iteration (Even number total)
                break;
            } else if (evenNode.next.next == null) {
                prevOdd = oddNode;
                oddNode = oddNode.next.next;
                
            }

            } else if (oddNode) {}
        }


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
