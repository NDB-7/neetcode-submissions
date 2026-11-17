class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        cnt = Counter(tasks)
        h = [-c for c in cnt.values()] # max heap for counts
        heapq.heapify(h)
        q = deque() # (time, count)
        time = 0

        while q or h:
            time += 1

            if h:
                c = heapq.heappop(h) + 1
                if c < 0:
                    q.append((time + n, c))

            if q and q[0][0] == time:
                heapq.heappush(h, q.popleft()[1])

        return time