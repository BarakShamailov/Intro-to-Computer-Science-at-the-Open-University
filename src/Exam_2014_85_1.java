
public class Exam_2014_85_1 {
	public static void main(String[] args) {
		int[][] mat = { { 3, 13, 15, 28, 30 }, { 50, 51, 52, 29, 30 }, { 51, 10, 53, 54, 55 }, { 53, 12, 14, 53, 11 } };
		System.out.println(longestWorm(mat));
	}

	public static int longestWorm(int[][] mat) {
		return longestWorm(mat, 0, 0, mat[0][0]);
	}

	private static int longestWorm(int[][] mat, int i, int j, int prevCell) {
		if (i == mat.length) {
			return 0;
		}
		if (j == mat[i].length) {
			return longestWorm(mat, i + 1, 0, prevCell);
		}
		if (Math.abs(mat[i][j] - prevCell) == 1) {
			return longestWorm(mat, i, j, mat[i][j], 1);
		}
		return longestWorm(mat, i, j + 1, mat[i][j]);
	}

	private static int longestWorm(int[][] mat, int i, int j, int prevCell, int counter) {
		if (i < 0 || i == mat.length || j < 0 || j == mat[i].length || Math.abs(mat[i][j] - prevCell) > 1) {
			return counter;
		}
		if (Math.abs(mat[i][j] - prevCell) <= 1) {
			counter += 1;
			prevCell = mat[i][j];
			mat[i][j] = -1;
			int up = longestWorm(mat, i + 1, j, prevCell, counter);
			int down = longestWorm(mat, -1, j, prevCell, counter);
			int left = longestWorm(mat, i, j - 1, prevCell, counter);
			int right = longestWorm(mat, i, j + 1, prevCell, counter);
			mat[i][j] = prevCell;
			return Math.max(Math.max(up, down), Math.max(left, right));
		}
		return 0;
	}
}