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

    private int find(int x) {
        if (parent[x] != x) return find(parent[x]);
        return parent[x];
    }

    private boolean union(int x, int y) {
        int big = find(x), small = find(y);

        if (big == small) return false;

        if (small > big) {
            int temp = big;
            big = small;
            small = temp;
        }

        parent[small] = big;
        rank[big] += rank[small];

        return true;
    }
}
