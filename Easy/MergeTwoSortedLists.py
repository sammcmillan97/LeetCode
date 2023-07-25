class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def mergeTwoLists(self, list1, list2):
        
        if list1 is None and list2 is None:
            return None 
        
        if list1 is None:
            return list2
        
        if list2 is None:
            return list1
        
        if list1.val >= list2.val:
            head = ListNode(list1.val)
            head.next = self.mergeTwoLists(list1.next, list2)
            return head
        else:
            head = ListNode(list2.val)
            head.next = self.mergeTwoLists(list1, list2.next)
            return head


        



        
