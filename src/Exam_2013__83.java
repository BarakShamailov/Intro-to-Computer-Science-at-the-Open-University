
public class Exam_2013__83 {
	public static void main(String[] args) {
		int[] a = { -3, 5, 12, -14, -9, 13 };
		System.out.println(balancedPartition(a));
	}

	public static boolean balancedPartition(int[] a) {
		return balancedPartition(a, 0, 0, 0, 0, 0);
	}

	private static boolean balancedPartition(int[] a, int i, int sum1, int sum2, int counter1, int counter2) {
		if (i == a.length) {
			if (sum1 == sum2 && counter1 == counter2) {
				return true;
			}
			return false;
		}
		boolean op1 = balancedPartition(a, i + 1, sum1 + a[i], sum2, counter1 + 1, counter2);
		boolean op2 = balancedPartition(a, i + 1, sum1, sum2 + a[i], counter1, counter2 + 1);
		return op1 || op2;
	}
}
