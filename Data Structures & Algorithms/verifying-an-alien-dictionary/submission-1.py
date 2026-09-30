class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        m = {}
        for i in range(len(order)):
            m[order[i]] = i
        for i in range(len(words) - 1):
            w = words[i]
            w2 = words[i + 1]
            match = True
            for j in range(len(w)):
                if j < len(w2):
                    if m[w[j]] > m[w2[j]]:
                        return False
                    elif m[w[j]] < m[w2[j]]:
                        match = False
                        break
            if match and len(w2) < len(w):
                return False
        return True
                
                
                