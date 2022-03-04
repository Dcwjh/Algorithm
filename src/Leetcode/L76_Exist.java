package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L76_Exist
 * @Date 2021/6/10 21:49
 * @Version 1.0
 */


public class L76_Exist {
    public static boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;

        return dfs(board, 0, 0, word, 0);
    }

    private static boolean dfs(char[][] board, int i, int j,String word, int index){
        if(index == word.length()) return true;
        if(i < 0 || i == board.length) return false;
        if(j < 0 || j == board[0].length) return false;
        char t = board[i][j];
        if(board[i][j] == word.charAt(index)){
            board[i][j] = ' ';
        }
        boolean flag = dfs(board,i, j + 1, word, index + 1)||dfs(board, i + 1, j, word, index + 1) || dfs(board, i, j - 1, word,index + 1) || dfs(board, i - 1, j, word, index + 1 );
        board[i][j] = t;
        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,"SEE"));
    }
}
