class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = collections.deque()
        fresh = 0
        time = 0
        m, n = len(grid), len(grid[0])

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    q.append((i, j))

        DIRS = [(1,0),(-1,0),(0,1),(0,-1)]

        while fresh > 0 and q:
            l = len(q)
            for _ in range(l):
                i, j = q.popleft()
                for D in DIRS:
                    nI, nJ = D
                    newI, newJ = nI + i, nJ + j
                    if 0 <= newI < m and 0 <= newJ < n and grid[newI][newJ] == 1:
                        fresh -= 1
                        grid[newI][newJ] = 2
                        q.append((newI, newJ))
            time += 1

        return time if fresh == 0 else -1