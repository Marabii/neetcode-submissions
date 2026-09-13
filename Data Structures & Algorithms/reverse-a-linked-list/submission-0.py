# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return None
        head_next = head.next
        head.next = None
        while head_next is not None:
            rest = head_next.next
            head_next.next = head
            head = head_next
            head_next = rest
        
        return head