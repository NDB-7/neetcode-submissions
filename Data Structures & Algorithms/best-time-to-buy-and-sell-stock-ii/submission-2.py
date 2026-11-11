class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = {}
        def dfs(i, held):
            if i == len(prices):
                return 0
            if not (i, held) in dp:
                if held:
                    dp[(i, held)] = max(dfs(i + 1, True), prices[i] + dfs(i + 1, False))
                else:
                    dp[(i, held)] = max(dfs(i + 1, False), -prices[i] + dfs(i + 1, True))
            return dp[(i, held)]

        return dfs(0, False)