# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode()
        curr = dummy
        heap = []

        for i, l in enumerate(lists):
            if l:
                heapq.heappush(heap, (l.val, i, l))
        
        while heap:
            val, i, n = heapq.heappop(heap)
            curr.next = n
            curr = curr.next

            if n.next:
                heapq.heappush(heap, (n.next.val, i, n.next))

        return dummy.next