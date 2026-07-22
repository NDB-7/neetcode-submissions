class Solution:
    def climbStairs(self, n: int) -> int:
        table = {}
        table[1] = 1
        table[2] = 2

        for i in range(3, n + 1):
            table[i] = table[i - 1] + table[i - 2]
        
        return table[n]