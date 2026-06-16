class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j]==word.charAt(0)){
                    if(check(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(char[][] mat, String word, int row, int col, int index){
        if(index==word.length()){
            return true;
        }
        if(row<0 || row>=mat.length || col < 0 || col >= mat[0].length){
            return false;
        }
        if(mat[row][col]==word.charAt(index)){
            char temp = mat[row][col];
            mat[row][col] = '0';
            boolean right = check(mat,word,row+1,col,index+1);
            boolean left = check(mat,word,row-1,col,index+1);
            boolean top = check(mat,word,row,col+1,index+1);
            boolean bottom = check(mat,word,row,col-1,index+1);
            mat[row][col] = temp;
            return left || right || top || bottom;
        }
        return false;
    }
}
