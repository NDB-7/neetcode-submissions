class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        words = set(wordDict)
        n = len(s)

        dp = {}

        def helper(i):
            if i in dp:
                return dp[i]
            r = i + 1

            while r <= n:
                if s[i:r] in words:
                    if r == n:
                        return True
                    if helper(r):
                        dp[i] = True
                        return True
                r += 1

            dp[i] = False
            return False
        
        return helper(0)