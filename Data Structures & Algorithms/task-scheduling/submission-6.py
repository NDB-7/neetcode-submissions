class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        counts = Counter(tasks)
        h = [-c for c in counts.values()] # max heap
        heapq.heapify(h)
        q = deque() # (time, count)

        time = 0

        while h or q:
            time += 1

            if h:
                c = heapq.heappop(h) + 1
                if c < 0:
                    q.append((time + n, c))
            if q and q[0][0] == time:
                heapq.heappush(h, q.popleft()[1])

        return time