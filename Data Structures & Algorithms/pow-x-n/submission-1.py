class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(x, n):
            if n == 0:
                return 1
            if x == 0:
                return 0

            res = helper(x, n // 2)
            if n % 2 == 0:
                return res * res
            else:
                return res * res * x

        res = helper(x, abs(n))
        return res if n >= 0 else 1 / res