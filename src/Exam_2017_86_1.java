
public class Exam_2017_86_1 {

	public static void main(String[] args) {
		System.out.println(edit("sunday", "saturday"));
		int[] arr = { 1, 3, 4, 5, 7 };
		System.out.println(countTriplets(arr, 12));
	}

	public static int edit(String str1, String str2) {

		if (str1.length() == 0 || str2.length() == 0) {
			return 0;
		}

		if (str1.charAt(0) == str2.charAt(0)) {
			return edit(str1.substring(1), str2.substring(1));
		}

		int op1 = edit(str1.substring(1), str2);
		int op2 = edit(str1, str2.substring(1));
		return Math.min(op1, op2) + 1;
	}

	// ******************************************Q2***********************************
	public static int countTriplets(int[] arr, int num) {
		int count = 0;
		for (int high = arr.length - 1; high > 1; high--) {

			int low = 0;
			int mid = high - 1;
			while (low < mid) {
				int sum = arr[low] + arr[mid] + arr[high];
				if (sum < num) {
					count += mid - low;
					low = mid;
				} else {
					mid--;
				}
			}
		}
		return count;
	}

}
