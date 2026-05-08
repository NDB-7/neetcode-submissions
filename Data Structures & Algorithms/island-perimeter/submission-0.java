class Solution {
    private int[][] grid;
    private boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return dfs(i, j);
            }
        }

        return 0;
    }

    private int dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 1;
        if (visited[i][j]) return 0;
        visited[i][j] = true;
        return dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i, j - 1);
    }
}