class Solution:
    def countSubstrings(self, s: str) -> int:
        memo = []
        n = len(s)

        for i in range(n):
            memo.append([0] * n)

        for i in range(n):
            l, r = i, i
            while l >= 0 and r < n and s[l] == s[r]:
                memo[l][r] = 1
                l -= 1
                r += 1

            l, r = i, i + 1
            while l >= 0 and r < n and s[l] == s[r]:
                memo[l][r] = 1
                l -= 1
                r += 1
        
        res = 0

        for i in memo:
            for j in i:
                res += j
        
        return res
