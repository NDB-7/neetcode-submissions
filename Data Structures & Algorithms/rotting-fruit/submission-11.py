class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        q = collections.deque()
        fresh = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    q.append((i, j))
        
        DIRS = [(1,0),(-1,0),(0,1),(0,-1)]
        currMin = 0
        while fresh > 0 and q:
            length = len(q)
            for _ in range(length):
                i, j = q.popleft()
                for D in DIRS:
                    newI, newJ = D[0] + i, D[1] + j
                    if 0 <= newI < m and 0 <= newJ < n and grid[newI][newJ] == 1:
                        grid[newI][newJ] = 2
                        q.append((newI, newJ))
                        fresh -= 1
            currMin += 1
        
        return currMin if fresh == 0 else -1