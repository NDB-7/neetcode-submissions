class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        visited = set()
        heap = [(0, 0)] # dist, index
        res = 0

        while len(visited) < len(points):
            dist, i = heapq.heappop(heap)

            if i in visited:
                continue

            visited.add(i)
            res += dist

            x1, y1 = points[i]
            for j in range(len(points)):
                if j not in visited:
                    x2, y2 = points[j]
                    dist = abs(x1 - x2) + abs(y1 - y2)
                    heapq.heappush(heap, (dist, j))

        return res