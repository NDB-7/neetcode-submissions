class Solution:
    def climbStairs(self, n: int) -> int:
        memo = {}
        memo[n] = 1
        memo[n + 1] = 0

        def backtrack(i):
            if not i in memo:
                memo[i] = backtrack(i + 1) + backtrack(i + 2)

            return memo[i]

        return backtrack(0)