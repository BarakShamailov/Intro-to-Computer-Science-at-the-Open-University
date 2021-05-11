
public class Exam_2020_85 {
	public static void main(String[] args) {
		int[][] mat = { { 1, 1, -1, 1, 1 }, { 1, 0, 0, -1, 1 }, { 1, 1, 1, 1, -1 }, { -1, -1, 1, 1, 1 },
				{ 1, 1, -1, -1, 1 } };
		
		System.out.println(findMaximum(mat));
		int[] a = {1,2,4,4,5,6};
		System.out.println(strictlyIncreasing(a));
	}
	
	//***********************************************************Q2*********************************
	
	public static int strictlyIncreasing ( int [] a) {
		int left = 0;
		int right = 1;
		int total = 0 ;
		int counter = 0;
		while(right < a.length) {
			if(a[right] > a[left]) {
				counter++;
				right++;
				left++;
				total+= counter;
				
			}
			else {
				counter=0;
				left++;
				right++;
			}
		}
		return total;
	}
	
	//***********************************************************Q1*********************************
	public static int findMaximum(int[][] mat) {
		if (mat[0][0] == -1) {
			return -1;
		}
		return findMaximum(mat, 0, 0, 0);
	}

	private static int findMaximum(int[][] mat, int i, int j, int sum) {
		if (i < 0 || i == mat.length || j < 0 || j == mat[i].length || mat[i][j] == -1 ) {
			return sum;
		}

		sum += mat[i][j];
		if (i % 2 == 0) {

			int op1 = findMaximum(mat, i, j + 1, sum);
			int op2 = findMaximum(mat, i + 1, j, sum);

			return Math.max(op1, op2);
		}

		int op3 = findMaximum(mat, i, j - 1, sum);
		int op4 = findMaximum(mat, i + 1, j, sum);

		return Math.max(op3, op4);

	}

	


}
