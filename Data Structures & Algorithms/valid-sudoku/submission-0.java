class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (char[] row : board) {
            Set<Character> set = new HashSet<>();

            for (char c : row) {
                if (checkValid(set, c) == false) return false;
            }
        }

        for (int col = 0; col < 9; col++) {
            Set<Character> set = new HashSet<>();

            for (int row = 0; row < 9; row++) {
                char c = board[row][col];
                if (checkValid(set, c) == false) return false;
            }
        }

        for (int c = 0; c < 9; c += 3) {
            for (int r = 0; r < 9; r += 3) {
                Set<Character> set = new HashSet<>();

                for (int col = c; col < c + 3; col++) {
                    for (int row = r; row < r + 3; row++) {
                        char ch = board[row][col];
                        if (checkValid(set, ch) == false) return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean checkValid(Set<Character> set, char c) {
        if (c != '.') {
            if (set.contains(c)) return false;
            set.add(c);
        }

        return true;
    }
}
