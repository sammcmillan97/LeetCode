import Models.ListNode; 

public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        
        ListNode endOfFirst = head;
        ListNode halfwayHead = head;
        ListNode fastMovingHead = head;

        while(fastMovingHead != null) {
            endOfFirst = halfwayHead;
            halfwayHead = halfwayHead.next;
            fastMovingHead = fastMovingHead.next.next;
        }

        endOfFirst.next = null;

        halfwayHead = halfwayHead.reverseList(halfwayHead);
        int largestSum = 0;

        while(halfwayHead != null) {
            int sum = halfwayHead.val + head.val;
            if (sum > largestSum) {
                largestSum = sum;
            }
            halfwayHead = halfwayHead.next;
            head = head.next;
        }
        return largestSum;
    }
}
