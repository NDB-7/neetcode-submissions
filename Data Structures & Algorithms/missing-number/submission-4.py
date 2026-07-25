class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        res = 0

        for i in range(n + 1):
            if i != n:
                res ^= nums[i]
            res ^= i

        return res