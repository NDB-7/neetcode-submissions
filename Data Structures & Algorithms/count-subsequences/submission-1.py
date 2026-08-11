class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        n1, n2 = len(s), len(t)
        dp = {}

        def dfs(i1, i2):
            if not (i1, i2) in dp:
                if i2 == n2:
                    dp[(i1, i2)] = 1
                elif i1 == n1:
                    dp[(i1, i2)] = 0
                elif s[i1] == t[i2]:
                    dp[(i1, i2)] = dfs(i1 + 1, i2 + 1) + dfs(i1 + 1, i2)
                else:
                    dp[(i1, i2)] = dfs(i1 + 1, i2)
            return dp[(i1, i2)]
        
        return dfs(0, 0)