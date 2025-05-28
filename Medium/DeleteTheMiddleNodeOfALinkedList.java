import Models.ListNode;

public class DeleteTheMiddleNodeOfALinkedList {

    public ListNode deleteMiddle(ListNode head) {

        int numberOfNodes = 1;
        ListNode copyOfHead = head;

        while(head.next != null) {
            head = head.next;
            numberOfNodes++;
        }
        
        head = copyOfHead;
        
        if (numberOfNodes == 1) {
            return head;
        }
        if (numberOfNodes == 2) {
            head.next = null;
            return head;
        }
        
        int remove = numberOfNodes / 2 - 1;

        while(remove >= 0) {
            head = head.next;
            remove--;
        }

        head.next = head.next.next;

        return copyOfHead;
    }

    public static void main(String[] args) {
        // ListNode four = new ListNode(4, null);
        // ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, null);
        ListNode one = new ListNode(1, two);

        DeleteTheMiddleNodeOfALinkedList s = new DeleteTheMiddleNodeOfALinkedList();

        ListNode head = s.deleteMiddle(one);
        System.out.println(head.val);
        // System.out.println(head.next.val);
        // System.out.println(head.next.next.val);



    }
}
