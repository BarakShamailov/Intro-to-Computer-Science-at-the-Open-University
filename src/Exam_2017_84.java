
public class Exam_2017_84 {
	public static void main(String[] args) {
		System.out.println(ways(4, 2));
		int[] a = { 65, 70, -5, 3, 48, 49, 52 };
		System.out.println(findSum(a, 122));
	}

	public static int ways(int k, int n) {
		if (k == 0 && n == 0) {
			return 1;
		}
		if (k < 0) {
			return 0;
		}

		int left = ways(k - 1, n + 1);
		int right = ways(k - 1, n - 1);
		return left + right;

	}

	// **************************Q2*************************
	//gadi solution
	/*public static boolean findSum(int[] a, int sum) {
		int low = 0;
		int high = a.length - 1;
		int maxIndex = -1;
		while (low < high && maxIndex == -1) {
			int mid = (high + low) / 2;
			if (a[mid] > a[(mid + 1) % a.length]) {
				maxIndex = mid;
			}
			if (a[mid] < a[low]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		int lowIndex = (maxIndex + 1) % a.length;
		while (lowIndex != maxIndex) {
			int mySum = a[lowIndex] + a[maxIndex];
			if (sum == mySum) {
				return true;
			}
			if (mySum < sum) {
				lowIndex = (lowIndex + 1) % a.length;
			} else {
				maxIndex = (maxIndex - 1 + a.length) % a.length;
			}
		}
		return false;
	}*/
//my solution
	public static boolean findSum(int[] a, int num) {
		int indexMin = 0;
		int indexMax = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
				indexMax = i;
			}
		}
		if (indexMax != a.length - 1) {
			indexMin = indexMax + 1;
		}
		while (indexMin < a.length || indexMax > 0) {

			int sum = a[indexMin] + a[indexMax];
			if (sum == num) {
				System.out.println(a[indexMin] + " + " + a[indexMax] + " = " + num);
				return true;
			}
			if (sum < num) {
				indexMin++;
				if (indexMin == a.length) {
					indexMin = 0;
				}
			} else {
				indexMax--;
				if (indexMax == 0) {
					indexMax = a.length - 1;
				}

			}
		}
		return false;
	}

}
