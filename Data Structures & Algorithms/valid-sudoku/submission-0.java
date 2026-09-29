class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        
        for (int i = 0; i < board.length; i++){
            //check row
            Set<Character> setRow = new HashSet<>();
            for (int j = 0; j< board.length; j++)
            {   
                if (board[i][j] == '.')
                    continue;
                if (!setRow.add(board[i][j]))
                    return false;
            }

            //check column
            Set<Character> setCol = new HashSet<>();
            for (int k = 0; k < board.length; k++)
            {
                if (board[k][i] == '.')
                    continue;
                if (!setCol.add(board[k][i]))
                    return false;
            }

        }

        //check 3x3 sub-box
        for (int rowStart = 0; rowStart < board.length; rowStart += 3) {
            for (int colStart = 0; colStart < board.length; colStart += 3) {
                Set<Character> setSub = new HashSet<>();
                for (int i = rowStart; i < rowStart + 3; i++){
                    for (int j = colStart; j < colStart + 3; j++){
                        if (board[i][j] == '.')
                            continue;
                        if (!setSub.add(board[i][j]))
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
