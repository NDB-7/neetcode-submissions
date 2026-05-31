class Solution {
    char[][] grid;
    int rows;
    int cols;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        int res = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j) {
        if (i >= rows || j >= cols || i < 0 || j < 0 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}
