
public class Exam_2012_85 {
	public static void main(String[] args) {
		int[][] m = { { 8, 4, 2, 4, 3 }, { 6, 3, 8, 4, 5 }, { 1, 4, 9, 9, 7 }, { 2, 1, 7, 6, 5 } };
		printPathWeights(m);
	}

	public static void printPathWeights(int[][] m) {
		printPathWeights(m, 0, 0, 0);
	}

	private static void printPathWeights(int[][] m, int i, int j, int sum) {
		if (i < 0 || i == m.length || j < 0 || j == m[i].length || m[i][j] == -1) {
			return;
		}
		int temp = m[i][j];
		 sum +=  m[i][j];
		if (i == m.length - 1 && j == m[i].length - 1) {
			System.out.println(sum);
		}
		
		m[i][j] = -1;
		printPathWeights(m, i + 1, j, sum );
		printPathWeights(m, i - 1, j, sum );
		printPathWeights(m, i, j + 1, sum);
		printPathWeights(m, i, j - 1, sum);
		m[i][j] = temp;
		return;
		
	}

}
