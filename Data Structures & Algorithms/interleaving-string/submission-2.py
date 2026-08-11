class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        n1, n2 = len(s1), len(s2)
        if n1 + n2 != len(s3):
            return False
        
        if len(s3) == 0:
            return True
        
        dp = {}

        def dfs(i1, i2):
            if i1 == n1 and i2 == n2:
                return True

            if (i1, i2) in dp:
                return dp[(i1, i2)]
            
            i3 = i1 + i2
            match = False

            if i1 < n1 and s1[i1] == s3[i3]:
                match = match or dfs(i1 + 1, i2)
            
            if i2 < n2 and s2[i2] == s3[i3]:
                match = match or dfs(i1, i2 + 1)
            
            dp[(i1, i2)] = match
            return match
            
        return dfs(0, 0)