class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        cur = sum(arr[:k])
        res = 1 if cur >= threshold * k else 0

        for r in range(k, len(arr)):
            cur += arr[r] - arr[r - k]
            if cur >= threshold * k:
                res += 1

        return res