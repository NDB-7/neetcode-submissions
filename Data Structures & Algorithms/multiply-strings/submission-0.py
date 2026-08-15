class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        digits = {
            "1": 1,
            "2": 2,
            "3": 3,
            "4": 4,
            "5": 5,
            "6": 6,
            "7": 7,
            "8": 8,
            "9": 9,
            "0": 0,
        }

        def toNum(n):
            res = 0
            for i in range(len(n) - 1, -1, -1):
                res += pow(10, (len(n) - i - 1)) * digits[n[i]]
            return res
        
        n1 = toNum(num1)
        n2 = toNum(num2)
        
        return str(n1 * n2)