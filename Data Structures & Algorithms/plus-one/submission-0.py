class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        res_number = 0

        for i in range(len(digits) - 1, -1, -1):
            res_number += (10 ** (len(digits) - i - 1)) * digits[i]
        
        res_number += 1


        res = []

        while res_number > 0:
            rem = res_number % 10
            res.append(rem)
            res_number //= 10

        res.reverse()
        return res