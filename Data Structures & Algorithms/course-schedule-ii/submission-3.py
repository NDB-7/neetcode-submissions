class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj = [[] for _ in range(numCourses)]
        visit_state = [0] * numCourses

        for p in prerequisites:
            adj[p[1]].append(p[0])

        path = []
        
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
            path.append(i)
            return True
        
        for i in range(numCourses):
            if not dfs(i):
                return []
        
        return path[::-1]