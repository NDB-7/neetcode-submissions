class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []

        path = []
        def helper(i):
            if i > n:
                if len(path) == k:
                    res.append(path.copy())
                return
            helper(i + 1)
            path.append(i)
            helper(i + 1)
            path.pop()
        
        helper(1)

        return res