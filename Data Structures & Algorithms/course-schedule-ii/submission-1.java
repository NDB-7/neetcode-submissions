class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] p : prerequisites) adj.get(p[0]).add(p[1]);

        int[] visited = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adj, res, visited)) return new int[0];
        }

        int[] finalRes = new int[numCourses];
        for (int i = 0; i < numCourses; i++) finalRes[i] = res.get(i);

        return finalRes;
    }

    private boolean dfs(int i, List<List<Integer>> adj, List<Integer> res, int[] visited) {
        if (visited[i] == 1) return false;
        if (visited[i] == 2) return true;

        visited[i] = 1;

        List<Integer> children = adj.get(i);
        
        for (int child : children) {
            if (!dfs(child, adj, res, visited)) return false;
        }

        res.add(i);

        visited[i] = 2;

        return true;
    }
}
