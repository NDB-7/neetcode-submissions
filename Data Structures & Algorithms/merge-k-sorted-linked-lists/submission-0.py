# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        for n in lists:
            while n:
                heapq.heappush(heap, n.val)
                n = n.next

        dummy = ListNode()
        head = dummy
        
        while heap:
            n = heapq.heappop(heap)
            ln = ListNode(n)
            head.next = ln
            head = ln

        return dummy.next