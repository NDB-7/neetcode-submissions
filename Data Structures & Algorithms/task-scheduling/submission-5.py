class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        counts = Counter(tasks)
        mh = [-t for t in counts.values()] # max heap: count

        heapq.heapify(mh)

        time = 0
        q = deque() # time, count

        while mh or q:
            time += 1
            
            if mh:
                c = heapq.heappop(mh) + 1
                if c < 0:
                    q.append((time + n, c))
            if q and q[0][0] == time:
                _, c = q.popleft()
                heapq.heappush(mh, c)
            

        return time