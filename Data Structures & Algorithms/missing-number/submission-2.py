class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)

        for i in range(n + 1):
            if i == n:
                return n
            if i != nums[i]:
                return i