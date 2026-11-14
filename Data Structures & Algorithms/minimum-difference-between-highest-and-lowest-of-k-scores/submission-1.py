class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        nums.sort()
        res = float('inf')
        for r in range(k - 1, len(nums)):
            res = min(res, nums[r] - nums[r - k + 1])
        
        return res