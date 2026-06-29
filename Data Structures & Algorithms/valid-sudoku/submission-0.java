class Solution {
    private int ROW_SIZE = 9;
    private int COL_SIZE = 9;
    
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < ROW_SIZE; r++) {
            for (int c = 0; c < COL_SIZE; c++) {
                if (board[r][c] == '.')
                    continue;

                String squareKey = (r / 3) + "," + (c / 3);

                // check if already in maps, if not, create the set
                // otherwise get the hashset and check if the value is already contained
                // if it is, board cannot be a valid soduku board.
                if (cols.computeIfAbsent(c, k -> new HashSet<Character>()).contains(board[r][c])
                    || rows.computeIfAbsent(r, k -> new HashSet<Character>()).contains(board[r][c])
                    || squares.computeIfAbsent(squareKey, k -> new HashSet<Character>()).contains(board[r][c])) 
                {
                    return false;
                }

                // if not, add it
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }

        return true;
    }
}
