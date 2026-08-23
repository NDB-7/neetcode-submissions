class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        visited = set()
        min_heap = [(grid[0][0], 0, 0)] # max height so far, row, col
        visited.add((0, 0))

        while min_heap:
            max_h, r, c = heapq.heappop(min_heap)

            if r == len(grid) - 1 and c == len(grid[0]) - 1:
                return max_h
            
            for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nr, nc = r + dr, c + dc
                if 0 <= nr < len(grid) and 0 <= nc < len(grid[0]) and not (nr, nc) in visited:
                    visited.add((nr, nc))
                    heapq.heappush(min_heap, (max(max_h, grid[nr][nc]), nr, nc))