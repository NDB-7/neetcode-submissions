class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        m = {}
        s = set(nums)
        l = len(nums)
        visited = set()

        res = []

        for num in nums:
            m[num] = m.get(num, 0) + 1

        for n in s:
            if n not in visited and m[n] > l // 3:
                visited.add(n)
                res.append(n)
        return res