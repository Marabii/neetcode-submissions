# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        p1 = head
        p2 = head.next

        if p2 is None:
            return False

        while p2 and p2.next != None:
            if p1 == p2:
                return True
            p2 = p2.next.next
            p1 = p1.next
        
        return False