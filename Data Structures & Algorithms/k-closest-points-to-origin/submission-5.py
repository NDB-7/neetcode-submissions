class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        h = [] # dist, x, y
        res = []

        for p in points:
            d = math.sqrt((p[0] * p[0]) + (p[1] * p[1]))
            heapq.heappush(h, (-d, p[0], p[1]))
            if len(h) > k:
                heapq.heappop(h)

        while h:
            p = heapq.heappop(h)
            res.append([p[1], p[2]])

        return res