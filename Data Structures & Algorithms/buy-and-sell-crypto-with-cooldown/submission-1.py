class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = {}

        def dfs(i, buying):
            if not (i, buying) in dp:
                if i >= len(prices):
                    return 0
                
                cooldown = dfs(i + 1, buying)
                if buying:
                    buy = -prices[i] + dfs(i + 1, not buying)
                    dp[(i, buying)] = max(cooldown, buy)
                else:
                    sell = prices[i] + dfs(i + 2, not buying)
                    dp[(i, buying)] = max(cooldown, sell)
                    
            return dp[(i, buying)]

        return dfs(0, True)