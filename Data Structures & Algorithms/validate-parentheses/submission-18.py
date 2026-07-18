class Solution:
    def isValid(self, s: str) -> bool:
        m = {}
        m['('] = ')'
        m['['] = ']'
        m['{'] = '}'

        stack = []

        for c in s:
            if c in m:
                stack.append(c)
            else:
                if not stack:
                    return False
                
                ch = stack.pop()
                if m[ch] != c:
                    return False
        
        return not stack