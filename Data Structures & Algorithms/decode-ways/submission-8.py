class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        memo = {}

        def dfs(i):
            if i in memo: return memo[i]
            if i >= n: return 1
            if s[i] == "0": return 0
            if i == n - 1: return 1

            res = dfs(i + 1)

            if s[i] == "1" or (s[i] == "2" and int(s[i + 1]) < 7):
                res = dfs(i + 1) + dfs(i + 2)
            
            memo[i] = res
            return res

        return dfs(0)