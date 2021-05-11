
public class Exam_2018_87 {
	public static void main(String[] args) {
		System.out.println(howManySorted(3, 3));
		int[] a = { 1, 5, 8, 4, 3, 5, 65, 45, 20, 1, 2 };
		System.out.println(what(a, 23));
	}

	public static int howManySorted(int n, int max) {
		return howManySorted(n, max, 0, 1);
	}

	private static int howManySorted(int n, int max, int nums, int curr) {
		if (nums == n) {
			return 1;
		}
		if (max < curr) {
			return 0;
		}
		return howManySorted(n, max, nums + 1, curr) + howManySorted(n, max, nums, curr + 1);
	}

//************************************************Q2*************************************
	public static boolean what(int[] a, int num) {
		int left = 0;
		int right = 0;
		int sum = a[0];
		while (right < a.length) {

			if (sum == num) {
				return true;
			}
			if (sum < num) {
				right++;
				if (right == a.length) {
					return false;
				}
				sum += a[right];

			} else {

				sum -= a[left++];
				if (left > right) {
					if (left == a.length) {
						return false;
					}

					right++;
					sum = a[left];
				}
			}
		}
		return false;

	}
}
