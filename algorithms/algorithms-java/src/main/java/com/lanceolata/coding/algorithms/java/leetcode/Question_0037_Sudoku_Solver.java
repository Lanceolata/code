package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0037_Sudoku_Solver {
	public void solveSudoku(char[][] board) {
		if (board == null)
			return;
		help(board, 0, 0);
	}

	private boolean help(char[][] board, int r, int c) {
		if (r >= 9) {
			return true;
		}
		if (c >= 9) {
			return help(board, r + 1, 0);
		}
		if (board[r][c] != '.') {
			return help(board, r, c + 1);
		}
		for (char i = '1'; i <= '9'; i++) {
			board[r][c] = i;
			if (isValid(board, r, c) && help(board, r, c + 1)) {
				return true;
			}
		}
		board[r][c] = '.';
		return false;
	}

	private boolean isValid(char[][] board, int r, int c) {
		for (int i = 0; i < 9; i++) {
			if (i != c && board[r][c] == board[r][i]) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (i != r && board[r][c] == board[i][c]) {
				return false;
			}
		}
		int m = r / 3 * 3, n = c / 3 * 3;
		for (int i = m; i < m + 3; i++) {
			for (int j = n; j < n + 3; j++) {
				if ((i != r || j != c) && board[r][c] == board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
