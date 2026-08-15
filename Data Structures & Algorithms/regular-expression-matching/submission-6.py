class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        n1, n2 = len(s), len(p)
        dp = {}

        def dfs(i1, i2):
            if i2 == n2:
                return i1 == n1
            
            if (i1, i2) in dp:
                return dp[(i1, i2)]
            
            matches = i1 < n1 and (s[i1] == p[i2] or p[i2] == ".")

            if i2 + 1 < n2 and p[i2 + 1] == "*":
                dp[(i1, i2)] = dfs(i1, i2 + 2) or (matches and dfs(i1 + 1, i2))
            else:
                dp[(i1, i2)] = matches and dfs(i1 + 1, i2 + 1)
            
            return dp[(i1, i2)]
        
        return dfs(0, 0)