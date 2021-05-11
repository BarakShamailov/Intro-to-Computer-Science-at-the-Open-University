
public class Exam_2017_87 {
	public static void main(String[] args) {
		int[] a = { 7, 2, 3 };
		int[][] mat = { { 1, 5, 7 }, { 3, 2, 9 }, { 1, 2, 3 } };
		System.out.println(covers(mat, a, 1));
		int[] arr = { 4, 5, 6, 10, 12 };
		System.out.println(isPythagorean(arr));
	}

	public static boolean covers(int[][] mat, int[] a, int k) {
		return covers(mat, a, k, 0);

	}

	private static boolean covers(int[][] mat, int[] a, int k, int i) {
		if (k < 0) {
			return false;
		}

		if (i == mat.length) {

			return allZero(a);
		}
		int[] temp = new int[a.length];
		copy(temp, a);
		xZero(temp, mat[i]);
		boolean op1 = covers(mat, temp, k - 1, i + 1);
		boolean op2 = covers(mat, a, k, i + 1);
		return op1 || op2;

	}

//check if all the numbers in the array equal to 0.
	private static boolean allZero(int[] x) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] != 0) {
				return false;
			}
		}
		return true;
	}

//copy the all number beetween the array
	private static void copy(int[] dest, int[] src) {
		for (int i = 0; i < src.length; i++) {
			dest[i] = src[i];
		}

	}

//// if there is a number in the other array , the method set him to zero
	private static void xZero(int[] x, int[] y) {
		for (int i = 0; i < y.length; i++) {
			for (int j = 0; j < y.length; j++) {
				if (x[i] == y[j]) {
					x[i] = 0;
				}
			}
		}
	}

//**************************************************Q2****************************
	public static boolean isPythagorean(int[] arr) {
		for (int high = arr.length - 1; high > 1; high--) {
			int low = 0;
			int mid = high - 1;
			while (low < mid) {
				int numCheck = arr[high] * arr[high];
				int twoRow = (arr[low] * arr[low]) + (arr[mid] * arr[mid]);
				if (twoRow == numCheck) {
					return true;
				}
				if (twoRow > numCheck) {
					mid--;
				} else {
					low++;
				}
			}
		}
		return false;

	}
}
