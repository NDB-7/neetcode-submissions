class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1: return nums[0]

        def rob_help(houses):
            n = len(houses)
            memo = [-1] * n

            def dfs(i):
                if i >= n:
                    return 0

                if memo[i] == -1:
                    memo[i] = max(houses[i] + dfs(i + 2), dfs(i + 1))
                
                return memo[i]
            
            return dfs(0)

        return max(rob_help(nums[1:]), rob_help(nums[:-1]))