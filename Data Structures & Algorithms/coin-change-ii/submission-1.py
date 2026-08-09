class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = {}

        def dfs(i, cur):
            if not (i, cur) in dp:
                if cur == amount:
                    dp[(i, cur)] = 1
                elif i == len(coins) or cur > amount:
                    dp[(i, cur)] = 0
                else:
                    dp[(i, cur)] = dfs(i, cur + coins[i]) + dfs(i + 1, cur)
            
            return dp[(i, cur)]
        
        return dfs(0, 0)