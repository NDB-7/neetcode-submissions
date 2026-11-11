class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = {}

        def dfs(i, bought):
            if i == len(prices):
                return 0
            if not (i, bought) in dp:
                res = 0
                if bought:
                    res = max(dfs(i + 1, True), prices[i] + dfs(i + 1, False))
                else:
                    res = max(dfs(i + 1, False), -prices[i] + dfs(i + 1, True))
                dp[(i, bought)] = res
            return dp[(i, bought)]

        return dfs(0, False)