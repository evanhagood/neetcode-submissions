class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int top = 0;
        int bottom = ROWS - 1;

        // binary search to find row ...
        int row = 0;
        while(top <= bottom) {
            row = bottom + (top - bottom) / 2;
            if(target > matrix[row][COLS - 1]) {
                top = row + 1;
            } else if(target < matrix[row][0]) {
                bottom = row - 1;
            } else {
                break;
            }
        }

        // .. if it exists
        if(!(top <= bottom)) {
            return false;
        }
        
        // binary search to find target in row (if it exists)
        int left = 0;
        int right = COLS - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(target > matrix[row][mid]) {
                left = mid + 1;
            } else if(target < matrix[row][mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;

    }
}
