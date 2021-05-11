
public class Exam_2016_83 {
	public static void main(String[] args) {
		int[][] a = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		int[] b = { 1, 2, 5, 3, 6, 10, 9 };
		System.out.println(minPoints(a));
		System.out.println(findX(b, 16));
	}

	public static int minPoints(int[][] a) {
		int r = minPoints(a, 0, 0, 0, 0);
		return Math.abs(r) + 1;

	}

	private static int minPoints(int[][] a, int i, int j, int minSum, int sum) {
		if (i == a.length || j == a[i].length) {
			return Integer.MIN_VALUE;
		}
		sum += a[i][j];
		minSum = Math.min(minSum, sum);
		if (i == a.length - 1 && j == a[i].length - 1) {
			return minSum;
		}
		int op1 = minPoints(a, i, j + 1, minSum, sum);
		int op2 = minPoints(a, i + 1, j, minSum, sum);
		if (op1 > 0 || op2 > 0) {
			return 1;
		}
		return Math.max(op1, op2);
	}

	// **********************Q2**********************

	public static boolean findX(int [] b , int x) {
		int low = 0 ;
		int high = b.length -1 ;
        while ( low < high) {
	        int mid = (high+low) / 2;
	        if ( b[mid] + b[mid+1] == x) {
	        	return true;
	        }
	        if(x > b[mid] + b[mid+1]) {
	        	low = mid +1 ;
	        }
	        else {
	        	high = mid;
	        }
        }
		return false;
	}

}
