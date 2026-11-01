class Solution:
    def isPalindrome(self, s: str) -> bool:
        l, r = 0, len(s) - 1
        while (l < r):
            if not s[r].isalnum():
                r -= 1
            elif not s[l].isalnum():
                l += 1
            elif s[l].upper() != s[r].upper():
                return False
            else:
                r -= 1
                l += 1

        return True