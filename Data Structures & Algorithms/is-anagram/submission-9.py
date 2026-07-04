class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        m1 = {}
        m2 = {}

        for c in s:
            if c in m1:
                m1[c] += 1
            else:
                m1[c] = 1

        for c in t:
            if c in m2:
                m2[c] += 1
            else:
                m2[c] = 1
        
        return m1 == m2
            