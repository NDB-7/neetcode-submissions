class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        int rows = heights.length, cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(-1, i, 0, pacific, heights);
            dfs(-1, i, cols - 1, atlantic, heights);
        }

        for (int j = 0; j < cols; j++) {
            dfs(-1, 0, j, pacific, heights);
            dfs(-1, rows - 1, j, atlantic, heights);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) res.add(new ArrayList<>(List.of(i, j)));
            }
        }

        return res;
    }

    private void dfs(int h, int i, int j, boolean[][] visited, int[][] heights) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || visited[i][j] || heights[i][j] < h) return;
        visited[i][j] = true;

        dfs(heights[i][j], i + 1, j, visited, heights);
        dfs(heights[i][j], i - 1, j, visited, heights);
        dfs(heights[i][j], i, j + 1, visited, heights);
        dfs(heights[i][j], i, j - 1, visited, heights);
    }
}
