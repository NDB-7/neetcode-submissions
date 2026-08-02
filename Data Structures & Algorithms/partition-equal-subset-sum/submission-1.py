class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        totalSum = sum(nums)

        if totalSum % 2 != 0:
            return False

        dp = {}

        def dfs(i, target):
            if (i, target) in dp:
                return dp[(i, target)]
            if target == 0:
                return True
            if i == len(nums) or target < 0:
                return False
            dp[(i, target)] = dfs(i + 1, target) or dfs(i + 1, target - nums[i])
            return dp[(i, target)]
        
        return dfs(0, totalSum // 2)