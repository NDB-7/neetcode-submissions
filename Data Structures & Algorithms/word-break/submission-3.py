class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        words = set(wordDict)
        n = len(s)

        dp = {}

        def helper(i):
            if i in dp:
                return dp[i]
            r = i + 1
            res = False
            while r <= n:
                if s[i:r] in words:
                    if r == n:
                        return True
                    res = res or helper(r)
                    if res:
                        return res
                r += 1
            dp[i] = res
            return res
        
        return helper(0)