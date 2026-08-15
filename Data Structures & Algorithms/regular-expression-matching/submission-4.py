class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        dp = {}

        def dfs(i1, i2):
            if i2 == len(p):
                return i1 == len(s)
            
            if (i1, i2) in dp:
                return dp[(i1, i2)]

            first_match = i1 < len(s) and (p[i2] == s[i1] or p[i2] == '.')

            if i2 + 1 < len(p) and p[i2 + 1] == "*":
                dp[(i1, i2)] = dfs(i1, i2 + 2) or (first_match and dfs(i1 + 1, i2))
            else:
                dp[(i1, i2)] = first_match and dfs(i1 + 1, i2 + 1)
            
            return dp[(i1, i2)]

        return dfs(0, 0)