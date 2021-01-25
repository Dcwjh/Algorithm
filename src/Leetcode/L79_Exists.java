package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L79_Exists
 * @Date 1/11/2021 5:14 PM
 * @Version 1.0
 */


public class L79_Exists {

    public boolean exist(char[][] board, String word) {
       if(word.length() == 0) return true;

       return dfs(board, 0, 0, word, 0);
    }

    private boolean dfs(char[][] board, int i, int j,String word, int index){
        if(index == word.length()) return true;
        if(i < 0 || i == board.length) return false;
        if(j < 0 || j == board[0].length) return false;
        if(board[i][j]!=word.charAt(index)) return false;
        char t = board[i][j];
        board[i][j] = '0';
        dfs(board,i, j + 1, word, index + 1);
        dfs(board, i + 1, j, word, index + 1);
        dfs(board, i, j - 1, word,index + 1);
        dfs(board, i - 1, j, word, index + 1 );
        board[i][j] = t;
        return false;
    }
}
