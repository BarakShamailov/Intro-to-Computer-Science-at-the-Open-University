
public class Exam_2020_83 {
	public static void main(String[] args) {
		int[][] mat = { { 4, 5, 6, 7, 1 }, { 3, 5, 1, 7, 4 }, { 4, 5, 6, 7, 8 }, { 3, 4, 5, 7, 9 }, { 3, 2, 2, 7, 6 } };
		System.out.println(minDiagSnake(mat));

	}

	public static int minDiagSnake(int[][] mat) {
		int r = minDiagSnake(mat, 0, 0, mat[0][0], 0);
		return r;
	}

	private static int minDiagSnake(int[][] mat, int i, int j, int prevCell, int counter) {
		if (i < 0 || i == mat.length || j < 0 || j == mat[i].length || Math.abs(mat[i][j] - prevCell) > 1) {
			return Integer.MAX_VALUE;
		}
		counter += 1;
		if (i == mat.length - 1 && j == mat[i].length - 1) {
			return counter;
		}
		prevCell = mat[i][j];
		mat[i][j] = -1;
		int op1 = minDiagSnake(mat, i + 1, j + 1, prevCell, counter);
		int op2 = minDiagSnake(mat, i + 1, j - 1, prevCell, counter);
		int op3 = minDiagSnake(mat, i - 1, j - 1, prevCell, counter);
		int op4 = minDiagSnake(mat, i - 1, j + 1, prevCell, counter);
		mat[i][j] = prevCell;
		int total = Math.min(Math.min(op1, op2), Math.min(op3, op4));

		return total;
	}

}
