class Solution:
    def reorganizeString(self, s: str) -> str:
        counts = Counter(s)
        h = [(-c, ch) for ch, c in counts.items()]
        heapq.heapify(h)
        prev = None
        res = ""

        while h or prev:
            curPrev = prev
            if curPrev and h and curPrev[1] == h[0][1]:
                return ""
            if h:
                c, ch = heapq.heappop(h)
                c += 1
                res += ch
                if c < 0:
                    prev = (c, ch)
                else:
                    prev = None
            if curPrev:
                heapq.heappush(h, curPrev)

        return res