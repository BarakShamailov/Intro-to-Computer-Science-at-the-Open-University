
public class Exam_2015_86 {
	public static void main(String[] args) {
		// int[] a = { 1, 1, 3, 7 };
		// printAllSum(a, 8);
		int[] a = { -7, -3, 0, 1, 3, 5, 12, 14, 17, 19, 25, 30 };
         printPairs(a, 2);
	}
//*******************************************Q2*******************************************************

	public static void printPairs(int[] a, int k) {
		int left = a.length - 2;
		int right = a.length - 1;
		while (left > 0) {
			if (Math.abs(a[right] - a[left]) == k) {
				System.out.println("Pair Found: (" + a[left] + "," + a[right] + ")");
			}
			if (a[right] - a[left] < k) {
				left--;
			} else {
				right--;
			}
		}
	}

//*******************************************Q1*******************************************************
	public static void printAllSum(int[] a, int sum) {
		printAllSum(a, sum, 0, "");
	}

	private static void printAllSum(int[] a, int sum, int i, String s) {
		if (i == a.length) {
			if (sum == 0) {
				System.out.println(s);
			}
			return;
		}
		printAllSum(a, sum, i + 1, s + "0");
		printAllSum(a, sum - a[i], i + 1, s + "1");

	}

}
