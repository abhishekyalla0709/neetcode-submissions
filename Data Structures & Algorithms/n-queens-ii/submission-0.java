class Solution {
    private int ans;
    public int totalNQueens(int n) {
        char[][] matrix = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = '.';
            }
        }
        nQueens(matrix,0);
        return ans;
    }

    private void nQueens(char[][] matrix, int index){

        if(index==matrix.length){
            ans++;
            return;
        }

        for(int i = 0; i < matrix[index].length; i++){
            if(isValid(matrix,index,i)){
                matrix[index][i] = 'Q';
                nQueens(matrix,index+1);
                matrix[index][i] = '.';
            }
        }
        return;
    }

    private boolean isValid(char[][] matrix, int row, int col){
        for(int i = 0; i < row; i++){
            if(matrix[i][col]=='Q'){
                return false;
            }
        }
        int r = row-1;
        int c = col-1;
        while(r>=0 && c>=0){
            if(matrix[r][c]=='Q'){
                return false;
            }
            r--;
            c--;
        }

        r = row-1;
        c = col+1;
        while(r>=0 && c<matrix[row].length){
            if(matrix[r][c]=='Q'){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}
