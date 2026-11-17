class Solution:
    def reorganizeString(self, s: str) -> str:
        counts = Counter(s)
        h = [(-c, ch) for ch, c in counts.items()]
        heapq.heapify(h)
        prev = None
        res = ""

        while h or prev:
            if prev and not h:
                return ""
            c, ch = heapq.heappop(h)
            c += 1
            res += ch
            if prev:
                heapq.heappush(h, prev)
            
            if c < 0:
                prev = (c, ch)
            else:
                prev = None

        return res