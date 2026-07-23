class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = {}

        def backtrack(i):
            if i == 0: return 0
            if i < 0: return float('inf')

            if not i in memo:
                memo[i] = 1 + min((backtrack(i - coin) for coin in coins))

            return memo[i]
        
        res = backtrack(amount)
        return res if res != float('inf') else -1
