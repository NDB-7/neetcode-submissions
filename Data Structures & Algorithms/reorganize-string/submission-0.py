class Solution:
    def reorganizeString(self, s: str) -> str:
        counts = Counter(s)
        h = [(-c, char) for char, c in counts.items()]
        heapq.heapify(h)

        res = ""
        prev = None

        while h or prev:
            curPrev = prev
            if curPrev and h and curPrev[1] == h[0][1]:
                return ""
            if h:
                count, char = heapq.heappop(h)
                count += 1
                res += char
                if count < 0:
                    prev = (count, char)
                else:
                    prev = None
            if curPrev:
                heapq.heappush(h, curPrev)

        return res