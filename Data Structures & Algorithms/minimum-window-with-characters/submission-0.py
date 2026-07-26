class Solution:
    def minWindow(self, s: str, t: str) -> str:
        t_counts = {}
        for char in t:
            t_counts[char] = 1 + t_counts.get(char, 0)

        s_counts = {}
        l = 0
        length = float('inf')
        res = ""

        for r in range(len(s)):
            s_counts[s[r]] = 1 + s_counts.get(s[r], 0)
            passes = True
            for key, value in t_counts.items():
                if s_counts.get(key, 0) < value:
                    passes = False
            
            while passes:
                if r - l + 1 < length:
                    res = s[l:r+1]
                    length = r - l + 1

                s_counts[s[l]] -= 1
                l += 1

                passes = True
                for key, value in t_counts.items():
                    if s_counts.get(key, 0) < value:
                        passes = False
        
        return res