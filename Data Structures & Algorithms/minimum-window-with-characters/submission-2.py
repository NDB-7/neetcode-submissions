class Solution:
    def minWindow(self, s: str, t: str) -> str:
        t_counts = {}
        for char in t:
            t_counts[char] = 1 + t_counts.get(char, 0)

        s_counts = {}
        l = 0
        length = float('inf')
        res = ""
        have = 0
        need = len(t_counts)

        for r in range(len(s)):
            s_counts[s[r]] = 1 + s_counts.get(s[r], 0)
            if s_counts[s[r]] == t_counts.get(s[r], 0):
                have += 1
            
            while have == need:
                if r - l + 1 < length:
                    res = s[l:r+1]
                    length = r - l + 1

                s_counts[s[l]] -= 1

                if s_counts[s[l]] < t_counts.get(s[l], 0):
                    have -= 1

                l += 1
        
        return res