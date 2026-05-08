class Solution {
    boolean[][] visited;
    char[][] grid;
    int rows;
    int cols;
    int counter = 0;

    public int numIslands(char[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[rows][cols];
        this.grid = grid;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    counter++;
                    dfs(i, j);
                }
            }
        }

        return counter;
    }

    private void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0' || visited[i][j]) return;
        visited[i][j] = true;
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}
