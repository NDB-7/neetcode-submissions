class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = {}

        def dfs(i, j):
            if i == m - 1 or j == n - 1:
                return 1

            state = (i, j)
            if not state in dp:
                dp[state] = dfs(i + 1, j) + dfs(i, j + 1)
            
            return dp[state]
        
        return dfs(0, 0)