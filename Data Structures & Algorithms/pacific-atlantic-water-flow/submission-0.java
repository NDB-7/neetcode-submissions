class Solution {
    int[][] heights;
    int rows;
    int cols;
    List<List<Integer>> res;

    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;
        this.res = new ArrayList<List<Integer>>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] visited = new boolean[rows][cols]; // 1: P, 2: A
                boolean[] tracker = new boolean[2];
                dfs(heights[i][j], i, j, visited, tracker);
                if (tracker[0] && tracker[1]) res.add(new ArrayList<>(List.of(i, j)));
            }
        }

        return res;
    }

    private void dfs(int h, int i, int j, boolean[][] visited, boolean[] tracker) {
        if ((i < 0 && j < cols) || (j < 0 && i < rows)) {
            tracker[0] = true;
            return;
        }
        if (i >= rows || j >= cols) {
            tracker[1] = true;
            return;
        }
        if (visited[i][j] || heights[i][j] > h) return;
        visited[i][j] = true;
        for (int[] dir : DIRS) {
            dfs(heights[i][j], i + dir[0], j + dir[1], visited, tracker);
        }
    }
}
// Atlantic: i > rows || j > cols
// Pacific: (i < 0 && j <= cols) || (j < 0 && i <= rows)
// DFS
// Memoize later?