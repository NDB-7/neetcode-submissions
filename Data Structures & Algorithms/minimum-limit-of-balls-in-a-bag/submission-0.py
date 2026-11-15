class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        l, r = 1, max(nums)
        ans = 0

        while l <= r:
            m = (l + r) // 2
            needed = sum((x - 1) // m for x in nums)
            if needed <= maxOperations:
                ans = m
                r = m - 1
            else:
                l = m + 1
                
        return ans