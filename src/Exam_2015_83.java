
public class Exam_2015_83 {
	public static void main(String[] args) {
		int[][] mat = { { 3, 13, 15, 28, 30 }, { 40, 51, 52, 29, 30 }, { 28, 10, 53, 54, 53 }, { 53, 12, 55, 53, 60 },
				{ 70, 62, 56, 20, 80 }, { 80, 81, 90, 95, 100 } };
		System.out.println(shortestPath(mat));
		int[] a = { -2, 3, 5, 7, 12 };
		System.out.println(sum2(a, 8));
		
	}
	//************************************Q2***************************************
	public static boolean sum2(int [] a, int num) {
		int left = 0 ;
		int right = a.length-1;
		while(left < right) {
			if(a[left] + a[right] == num) {
				System.out.println(a[left] + " + " +a[right] + " = " + num);
				return true;
			}
			if(a[left] + a[right] > num )
			{
				right--;
			}
			else {
				left++;
			}
		}
		return false;
	}
	//O(n)

	public static boolean sum3(int[] a, int num) {
		for (int high = a.length - 1; high > 1; high--) {
			int low = 0;
			int mid = high -1;
			int sum = 0;
			while (low < mid) {
				sum = a[high] + a[mid] + a[low];
				if (sum == num) {
					return true;
				}
				if (sum > num) {
					mid--;
				} else {
					low++;
				}
			}
		}
		return false;
		//O(n^2)
	}

	public static int shortestPath(int[][] mat) {
		return shortestPath(mat, 0, 0, 0, 1);
	}

	private static int shortestPath(int[][] mat, int i, int j, int prevCell, int counter) {
		if (i < 0 || i == mat.length || j < 0 || j == mat[i].length || mat[i][j] <= prevCell) {
			return Integer.MAX_VALUE;
		}
		if (i == mat.length - 1 && j == mat[i].length - 1) {
			return counter;
		}

		prevCell = mat[i][j];
		mat[i][j] = -1;
		int op1 = shortestPath(mat, i + 1, j, prevCell, counter + 1);
		int op2 = shortestPath(mat, i - 1, j, prevCell, counter + 1);
		int op3 = shortestPath(mat, i, j - 1, prevCell, counter + 1);
		int op4 = shortestPath(mat, i, j + 1, prevCell, counter + 1);
		mat[i][j] = prevCell;

		return Math.min(Math.min(op1, op2), Math.min(op3, op4));
	}
}
