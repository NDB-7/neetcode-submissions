class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        dp = {}

        def dfs(i, cur):
            if i == len(nums):
                if cur == target:
                    dp[(i, cur)] = 1
                else:
                    dp[(i, cur)] = 0

            if not (i, cur) in dp:
                dp[(i, cur)] = dfs(i + 1, cur - nums[i]) + dfs(i + 1, cur + nums[i])
            
            return dp[(i, cur)]

        return dfs(0, 0)