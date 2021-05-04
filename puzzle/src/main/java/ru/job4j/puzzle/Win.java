package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1 && (checkLine(board, i) || checkRow(board, i))) {
                rsl = true;
                break;
            }
        }

        return rsl;
    }

    public static  boolean checkLine(int[][] board, int i) {
        boolean result = true;
        for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 1) {
                    result = false;
                    break;
                }
        }
        return result;
    }

    public static boolean checkRow(int[][] board, int i) {
        boolean result = true;
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != 1) {
                    result = false;
                    break;
                }
            }
        return result;
    }
}
