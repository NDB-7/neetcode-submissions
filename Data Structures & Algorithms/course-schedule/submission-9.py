class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = [[] for _ in range(numCourses)]
        visit_state = [0] * numCourses

        for p in prerequisites:
            adj[p[1]].append(p[0])

        def dfs(i):
            if visit_state[i] == 2:
                return True
            if visit_state[i] == 1:
                return False
            visit_state[i] = 1
            for j in adj[i]:
                if not dfs(j):
                    return False
            visit_state[i] = 2
            return True
        
        for i in range(numCourses):
            if not dfs(i):
                return False
        
        return True
