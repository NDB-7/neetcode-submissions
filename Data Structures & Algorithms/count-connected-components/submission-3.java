class Solution {
    int[] parent;
    int[] rank;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        int res = n;

        for (int[] edge : edges) if (union(edge[0], edge[1])) res--;

        return res;
    }

    private boolean union(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if (p1 == p2) return false;
        if (rank[p2] > rank[p1]) {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }
        parent[p2] = p1;
        rank[p1] += rank[p2];
        return true;
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
}
