class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res, path = set(), []
        used = [False] * n

        def dfs():
            if len(path) == n:
                res.add(tuple(path))
                return
            
            for i in range(n):
                if not used[i]:
                    used[i] = True
                    path.append(nums[i])
                    dfs()
                    path.pop()
                    used[i] = False
        
        dfs()

        return list(res)