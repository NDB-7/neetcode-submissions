class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        l, r = 1, max(candies)
        ans = 0

        def check(m):
            children_fed = 0
            for c in candies:
                children_fed += c // m
                if children_fed >= k:
                    return True
            return False

        while l <= r:
            m = (l + r) // 2
            if check(m):
                ans = m
                l = m + 1
            else:
                r = m - 1

        return ans