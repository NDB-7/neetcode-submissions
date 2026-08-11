class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        rows, cols = len(matrix), len(matrix[0])
        dp = {}

        def dfs(i, j):
            if (i, j) in dp:
                return dp[(i, j)]
                
            res = 1

            if i + 1 < rows and matrix[i + 1][j] > matrix[i][j]:
                res = max(res, 1 + dfs(i + 1, j))
            if j + 1 < cols and matrix[i][j + 1] > matrix[i][j]:
                res = max(res, 1 + dfs(i, j + 1))
            if i - 1 >= 0 and matrix[i - 1][j] > matrix[i][j]:
                res = max(res, 1 + dfs(i - 1, j))
            if j - 1 >= 0 and matrix[i][j - 1] > matrix[i][j]:
                res = max(res, 1 + dfs(i, j - 1))
            
            dp[(i, j)] = res
            return res

        maxPath = 0
        
        for i in range(rows):
            for j in range(cols):
                maxPath = max(maxPath, dfs(i, j))
        
        return maxPath
