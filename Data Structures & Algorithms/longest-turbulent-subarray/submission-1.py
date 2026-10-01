class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        res = 1
        curr = 1
        mode = 0 # 0 for <, 1 for >

        for i in range(len(arr) - 1):
            if mode == 0:
                if arr[i] < arr[i + 1]:
                    curr += 1
                    res = max(res, curr)
                else:
                    curr = 1
                mode = 1
            else:
                if arr[i] > arr[i + 1]:
                    curr += 1
                    res = max(res, curr)
                else:
                    curr = 1
                mode = 0

        mode = 1
        curr = 1

        for i in range(len(arr) - 1):
            if mode == 0:
                if arr[i] < arr[i + 1]:
                    curr += 1
                    res = max(res, curr)
                else:
                    curr = 1
                mode = 1
            else:
                if arr[i] > arr[i + 1]:
                    curr += 1
                    res = max(res, curr)
                else:
                    curr = 1
                mode = 0

        return res