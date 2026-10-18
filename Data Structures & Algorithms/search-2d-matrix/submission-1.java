class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int col = matrix[0].length;

        while (top <= bottom)
        {
            int row = top + (bottom - top)/2;

            if (target < matrix[row][0]) {
                bottom  = row - 1;
            } else if ( target > matrix[row][col - 1]) {
                top = row + 1;
            } else {
                int left = 0;
                int right = col - 1;

                while (left <= right)
                {
                    int mid = left + (right-left)/2;
                    if (matrix[row][mid] == target){
                        return true;
                    }
                    else if (target > matrix[row][mid]){
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                return false;
            }
        }
        return false; 
    }
}
