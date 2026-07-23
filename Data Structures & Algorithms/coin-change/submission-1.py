class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = {}

        def backtrack(i):
            if i == 0: return 0
            if i < 0: return None

            if not i in memo:
                minimum = 10001
                
                for coin in coins:
                    res = backtrack(i - coin)
                    if not res is None:
                        minimum = min(minimum, res)
                
                memo[i] = 1 + minimum
            
            return memo[i]
        
        res = backtrack(amount)
        if res > 10000:
            return -1
        
        return res
