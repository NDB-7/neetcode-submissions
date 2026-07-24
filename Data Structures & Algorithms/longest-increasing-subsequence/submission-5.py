class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = {}

        def dfs(i, prev_i):
            if i == n:
                return 0
            
            state = (i, prev_i)
            if state in dp:
                return dp[state]

            res = dfs(i + 1, prev_i)

            if prev_i == -1 or nums[i] > nums[prev_i]:
                res = max(res, 1 + dfs(i + 1, i))

            dp[state] = res
            return res

        
        return dfs(0, -1)