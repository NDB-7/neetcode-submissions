class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        cur = 0

        for i in range(k):
            if blocks[i] == 'W':
                cur += 1
            
        res = cur
        
        for r in range(k, len(blocks)):
            if blocks[r] == 'W':
                cur += 1
            if blocks[r - k] == 'W':
                cur -= 1
            res = min(res, cur)

        return res