class Solution {
    private boolean[][] visited;
    private int[][] grid;
    private int rows;
    private int cols;

    private int maxArea;

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        maxArea = 0;
        this.grid = grid;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j])
                    maxArea = Math.max(maxArea, dfs(i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j] || grid[i][j] == 0) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i, j - 1);
    }
}
