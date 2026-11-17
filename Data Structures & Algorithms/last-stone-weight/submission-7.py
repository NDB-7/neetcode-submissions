class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        for i, v in enumerate(stones):
            stones[i] = -v
        heapq.heapify(stones)

        while len(stones) > 1:
            x = heapq.heappop(stones)
            y = heapq.heappop(stones)
            if x != y:
                x -= y
                heapq.heappush(stones, x)
        
        return -stones[0] if stones else 0