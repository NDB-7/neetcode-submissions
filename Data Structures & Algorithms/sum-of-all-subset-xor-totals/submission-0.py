class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        def dfs(i, num):
            if i == len(nums):
                return 0
            return (num ^ nums[i]) + dfs(i + 1, (num ^ nums[i])) + dfs(i + 1, num)
        
        return dfs(0, 0)