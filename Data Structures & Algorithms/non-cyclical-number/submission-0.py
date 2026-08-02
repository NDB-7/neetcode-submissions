class Solution:
    def isHappy(self, n: int) -> bool:
        slow, fast = n, n

        def calculate(num):
            res = 0

            while num > 0:
                rem = num % 10
                res += rem ** 2
                num //= 10

            return res
        
        while fast != 1:
            slow = calculate(slow)
            fast = calculate(fast)
            fast = calculate(fast)

            if slow == fast and fast != 1:
                return False

        return True