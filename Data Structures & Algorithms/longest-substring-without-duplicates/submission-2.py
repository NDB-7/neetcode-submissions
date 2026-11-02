class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        duplicates = set()
        res = 0
        l = 0
        for r in range(len(s)):
            while s[r] in duplicates:
                duplicates.remove(s[l])
                l += 1
            duplicates.add(s[r])
            res = max(res, r - l + 1)
        return res