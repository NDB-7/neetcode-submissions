class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        memo = {}

        def robber(i):
            if i >= n:
                return 0

            if not i in memo:
                memo[i] = max(nums[i] + robber(i + 2), robber(i + 1))
            
            return memo[i]

        return max(robber(0), robber(1))