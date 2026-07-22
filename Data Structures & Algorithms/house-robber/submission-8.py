class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        memo = [-1] * n

        def robber(i):
            if i >= n:
                return 0

            if memo[i] == -1:
                memo[i] = max(nums[i] + robber(i + 2), robber(i + 1))
            
            return memo[i]

        return robber(0)