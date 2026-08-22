class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0

        wordList.append(beginWord)
        nei = {}

        for w in wordList:
            for i in range(len(w)):
                pattern = w[:i] + "*" + w[i + 1:]
                if not pattern in nei:
                    nei[pattern] = []
                nei[pattern].append(w)
        
        visited = set([beginWord])
        q = deque([beginWord])
        res = 1

        while q:
            for _ in range(len(q)):
                w = q.popleft()
                if w == endWord:
                    return res
                for i in range(len(w)):
                    pattern = w[:i] + "*" + w[i + 1:]
                    for neiWord in nei[pattern]:
                        if neiWord not in visited:
                            visited.add(neiWord)
                            q.append(neiWord)
            
            res += 1

        return 0