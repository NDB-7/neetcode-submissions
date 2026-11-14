class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        cur_sum = sum(arr[:k])

        res = 1 if cur_sum / k >= threshold else 0
        
        for r in range(k, len(arr)):
            cur_sum -= arr[r - k]
            cur_sum += arr[r]
            if cur_sum / k >= threshold:
                res += 1

        return res