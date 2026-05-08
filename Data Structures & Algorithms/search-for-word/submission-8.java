class Solution {
    Set<Integer> visited;
    String word;
    char[][] board;
    int rows;
    int cols;
    
    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        visited = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) return true;
            }
        }

        return false;
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private boolean dfs(int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited.contains(i * cols + j) || word.charAt(index) != board[i][j]) return false;
        visited.add(i * cols + j);

        boolean success = false;

        for (int[] dir : dirs) {
            success = success || dfs(i + dir[0], j + dir[1], index + 1);
        }

        visited.remove(i * cols + j);

        return success;
    }
}
