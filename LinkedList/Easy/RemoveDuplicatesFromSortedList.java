package LinkedList.Easy;
import Models.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode headCopy = head;
        ListNode parent = head;
        ListNode child = parent.next;

        while(child != null) {
            if (parent.val != child.val) {
                parent.next = child;
                parent = child;
            }
            child = child.next;
        }

        parent.next = child;
        return headCopy;
    }

}
