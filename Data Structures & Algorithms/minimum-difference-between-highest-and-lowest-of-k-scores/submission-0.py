class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        nums.sort()

        l, r = 0, k - 1

        res = nums[r] - nums[l]

        while r < len(nums) - 1:
            r += 1
            l += 1
            res = min(res, nums[r] - nums[l])
        
        return res