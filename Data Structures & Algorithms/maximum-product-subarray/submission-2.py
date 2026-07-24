class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = max(nums)
        cur_min, cur_max = 1, 1

        for n in nums:
            tmp = cur_max * n
            cur_max = max(cur_max * n, cur_min * n, n)
            cur_min = min(cur_min * n, tmp, n)
            res = max(cur_max, res)

        return res