class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        l = 0
        r = k - 1

        ops = 0
        
        for i in range(k):
            if blocks[i] == 'W':
                ops += 1
        
        res = ops

        while r < len(blocks) - 1:
            r += 1
            if blocks[r] == 'W':
                ops += 1
            if blocks[l] == 'W':
                ops -= 1
            l += 1
            res = min(res, ops)

        return res