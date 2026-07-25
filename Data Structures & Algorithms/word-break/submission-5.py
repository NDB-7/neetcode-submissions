class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        words = set(wordDict)
        n = len(s)

        dp = {}

        def helper(i):
            if i in dp:
                return dp[i]

            for r in range(i + 1, n + 1):
                if s[i:r] in words:
                    if r == n:
                        return True
                    if helper(r):
                        dp[i] = True
                        return True

            dp[i] = False
            return False
        
        return helper(0)