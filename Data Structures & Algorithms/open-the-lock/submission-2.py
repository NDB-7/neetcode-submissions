class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        visited = set(deadends)
        q = deque([("0000", 0)])

        if "0000" in visited:
            return -1

        while q:
            lock, turns = q.popleft()
            if lock == target:
                return turns
            combos = []
            for i in range(4):
                digit = str((int(lock[i]) + 1) % 10)
                combos.append(lock[:i] + digit + lock[i+1:])
                digit = str((int(lock[i]) + 9) % 10)
                combos.append(lock[:i] + digit + lock[i+1:])
            for c in combos:
                if c not in visited:
                    visited.add(c)
                    q.append((c, turns + 1))

        return -1