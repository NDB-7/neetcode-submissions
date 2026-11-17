class Solution:
    def tribonacci(self, n: int) -> int:
        dp = {0: 0,1:1,2:1}
        def helper(val):
            if val in dp:
                return dp[val]
            res = helper(val - 1) + helper(val - 2) + helper(val - 3)
            dp[val] = res
            return res

        return helper(n)