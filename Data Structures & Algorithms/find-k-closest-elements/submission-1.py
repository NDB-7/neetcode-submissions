class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        res = arr[:k]

        for r in range(k, len(arr)):
            l = r - k
            a, b = arr[r], arr[l]
            if abs(a - x) < abs(b - x) or (abs(a - x) == abs(b - x) and a < b):
                res = arr[l + 1 : r + 1]

        return res