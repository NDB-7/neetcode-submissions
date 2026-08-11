class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        n1, n2 = len(word1), len(word2)

        dp = {}

        def dfs(i1, i2):
            if not (i1, i2) in dp:
                if i1 == n1 and i2 == n2:
                    dp[(i1, i2)] = 0
                elif i1 == n1:
                    dp[(i1, i2)] = n2 - i2
                elif i2 == n2:
                    dp[(i1, i2)] = n1 - i1
                elif word1[i1] == word2[i2]:
                    dp[(i1, i2)] = dfs(i1 + 1, i2 + 1)
                else:
                    dp[(i1, i2)] = min(1 + dfs(i1, i2 + 1), 1 + dfs(i1 + 1, i2), 1 + dfs(i1 + 1, i2 + 1))
            
            return dp[(i1, i2)]
            
        return dfs(0, 0)