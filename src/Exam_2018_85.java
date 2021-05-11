
public class Exam_2018_85 {
	public static void main(String[] args) {
		int [][]mat = {{3,13,15,28,30},{55,54,53,27,26},{54,12,52,51,50},{50,10,8,53,11}};
		System.out.println(longestSlope(mat, 2));
	}
	
	public static int longestSlope(int [] [] mat, int num) {
		return longestSlope(mat, num,0,0); 
		
	}
	private static int longestSlope(int [] [] mat, int num, int i , int j) {
		if (i == mat.length) {
			return 0;
		}
		if ( j == mat[i].length) {
			return longestSlope(mat, num, i+1, 0);
		}
		int op1 = longestSlope(mat, num,i+1,j,mat[i][j]);
		int op2 = longestSlope(mat, num,i-1,j,mat[i][j]);
		int op3 = longestSlope(mat, num,i,j+1,mat[i][j]);
		int op4 = longestSlope(mat, num,i,j-1,mat[i][j]);
		int result = op1 + op2 + op3 + op4 + 1;
		return Math.max(result, longestSlope(mat, num,i,j+1));
	}
	private static int longestSlope(int [] [] mat, int num, int i , int j,int prev) {
		if(i < 0 || i >= mat.length || j < 0 || j >= mat[i].length) {
			return 0;
		}
		if (prev + num == mat[i][j] ) {
			int op1 = longestSlope(mat, num,i+1,j,mat[i][j]);
			int op2 = longestSlope(mat, num,i-1,j,mat[i][j]);
			int op3 = longestSlope(mat, num,i,j+1,mat[i][j]);
			int op4 = longestSlope(mat, num,i,j-1,mat[i][j]);
			return 1+ Math.max(Math.max(op1, op2),Math.max(op3,op4));
		}
		return 0;
	}
}