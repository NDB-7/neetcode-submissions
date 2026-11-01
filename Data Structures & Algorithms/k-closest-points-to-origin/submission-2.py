class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        max_heap = []
        for p in points:
            dist = math.sqrt(p[0]**2 + p[1]**2)
            tup = (-dist, p[0], p[1])
            heapq.heappush(max_heap, tup)
            if len(max_heap) > k:
                heapq.heappop(max_heap)
        res = []
        for p in max_heap:
            res.append([p[1], p[2]])
        return res