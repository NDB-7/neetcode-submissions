class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        l, r = max(weights), sum(weights)
        ans = 0

        while (l <= r):
            m = (l + r) // 2 # capacity

            curr_days = 1
            loaded = 0 # currently loaded
            for w in weights:
                loaded += w
                if loaded > m:
                    loaded = w
                    curr_days += 1
            if curr_days <= days:
                ans = m
                r = m - 1
            else:
                l = m + 1
            
        return ans