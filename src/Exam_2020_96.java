
public class Exam_2020_96 {
	public static void main(String[] args) {
		int [] [] mat = {{4,5,6,7,1},
				{3,5,1,7,4},
				{4,5,6,5,8},
		        {3,4,7,7,9},
		        {6,2,2,7,6}};
		System.out.println(maxSumKnight(mat));
		
		
	}
	public static int maxSumKnight(int [] [] mat) {
		return maxSumKnight(mat,0,0,0,mat[0][0]) ;
			
		
	}
	private static int maxSumKnight(int [] [] mat, int i,int j,int sum,int prev) {
		if (i < 0 || i >= mat.length || j < 0 || j >= mat[i].length || Math.abs(mat[i][j] - prev) > 1) {
			return -1;//if we outside of the matrix or we move to cell have been visited.
		}
		sum += mat[i][j];//we add the value of the cell .
		//we adding before we check if we are in the end of the location
		
		if ( i == mat.length-1 && j == mat[i].length-1) {
			return sum;//if we end return the sum
		}
		prev = mat[i][j];
		mat[i][j] = -1;//every cell when we visit change him to -1.
		//the all option to move with the knight
		int op1 = maxSumKnight(mat, i-1, j+2, sum , prev);
		int op2 = maxSumKnight(mat, i-1, j-2, sum , prev);
		int op3 = maxSumKnight(mat, i-2, j-1, sum , prev);
		int op4 = maxSumKnight(mat, i-2, j+1, sum , prev);
		int op5 = maxSumKnight(mat, i+2, j+1, sum , prev);
		int op6 = maxSumKnight(mat, i+2, j-1, sum , prev);
		int op7 = maxSumKnight(mat, i+1, j+2, sum , prev);
		int op8 = maxSumKnight(mat, i+1, j-2, sum , prev);
		mat[i][j] = prev;//remark to the original value.
		return Math.max(Math.max(Math.max(op1, op2), Math.max(op3, op4)), Math.max(Math.max(op5, op6), Math.max(op7, op8)));
	}
	public static void print(int [] [] mat) {
		for (int i = 0 ; i < mat.length; i++) {
			if ( i == 0 ) {
				System.out.print("");
			}
			System.out.println();
			for (int j =0 ; j < mat[i].length; j++) {
				System.out.print(mat[i][j]);
			}
		}
	}
}
