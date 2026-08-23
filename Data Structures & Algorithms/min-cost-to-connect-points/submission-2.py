class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        # Build adj list
        distances = { i: [] for i in range(len(points)) }

        for i in range(len(points)):
            x1, y1 = points[i]
            for j in range(len(points)):
                if i == j:
                    continue
                x2, y2 = points[j]
                dist = abs(x1 - x2) + abs(y1 - y2)
                distances[i].append((dist, j))
                distances[j].append((dist, i))

        # Prim's
        visited = set()
        heap = [(0, 0)] # dist, index
        res = 0

        while len(visited) < len(points):
            edge = heapq.heappop(heap)
            dist, i = edge[0], edge[1]
            if i in visited:
                continue
            visited.add(i)
            res += dist
            for e in distances[i]:
                if e[1] not in visited:
                    heapq.heappush(heap, e)

        return res