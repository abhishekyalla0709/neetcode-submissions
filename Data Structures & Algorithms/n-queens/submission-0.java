class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if(n==1){
            List<String> list = new ArrayList<>();
            list.add("Q");
            ans.add(list);
            return ans;
        }
        if(n==2 || n==3){
            return ans;
        }
        char[][] matrix = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = '.';
            }
        }
        nQueens(matrix,0,ans);
        return ans;
    }

    private void nQueens(char[][] matrix, int index, List<List<String>> ans){

        if(index==matrix.length){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < matrix.length; i++){
                String s = new String();
                for(int j =0; j < matrix[0].length; j++){
                    s+=matrix[i][j];
                }
                list.add(s);
            }
            ans.add(list);
            return;
        }

        for(int i = 0; i < matrix[index].length; i++){
            if(isValid(matrix,index,i)){
                matrix[index][i] = 'Q';
                nQueens(matrix,index+1,ans);
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
