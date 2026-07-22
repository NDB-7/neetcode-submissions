class Solution:
    def climbStairs(self, n: int) -> int:
        memo = {}

        def backtrack(i):
            if i in memo:
                return memo[i]

            if i > n:
                return 0
            
            if i == n:
                return 1

            res = backtrack(i + 1) + backtrack(i + 2)
            memo[i] = res
            return res

        return backtrack(0)