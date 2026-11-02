class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res = 0
        curSum = 0
        m = {0: 1}

        for n in nums:
            curSum += n
            if curSum - k in m:
                res += m[curSum - k]
            m[curSum] = m.get(curSum, 0) + 1

        return res