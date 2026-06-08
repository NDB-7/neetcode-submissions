class Solution {
    public boolean validTree(int n, int[][] edges) {
         if (edges.length > n - 1) return false;

         List<List<Integer>> adj = new ArrayList<>();

         for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

         for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
         }

         Set<Integer> vis = new HashSet<>();

         if (!dfs(0, -1, adj, vis)) return false;

         return vis.size() == n;
    }

    private boolean dfs(int i, int prev, List<List<Integer>> adj, Set<Integer> vis) {
        if (vis.contains(i)) return false;

        vis.add(i);

        for (int num : adj.get(i)) {
            if (num == prev) continue;
            if (!dfs(num, i, adj, vis)) return false;
        }

        return true;
    }
}
