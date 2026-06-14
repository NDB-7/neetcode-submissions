class Solution {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(edge[0] - 1, edge[1] - 1)) return new int[] {edge[0], edge[1]};
        }

        return new int[2];
    }

    private boolean union(int x, int y) {
        int px = find(x), py = find(y);

        if (px == py) return false;

        if (rank[px] > rank[py]) {
            int temp = px;
            px = py;
            py = temp;
        }

        parent[px] = py;
        rank[py] += rank[px];

        return true;
    }
    
    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
}
