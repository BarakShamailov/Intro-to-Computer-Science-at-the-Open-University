
public class Exam_exmpale {
	public static void main(String[] args) {
		int[] a = { 5, 4, 2, 1,3 };
		System.out.println(isSum(a, 9));
		int[] b = { 0, 1, 3, 10, 9, 10, 17, 17, 20 };
		System.out.println(findMaxPrice(b, 17));
	}

	public static int findMaxPrice(int[] prices, int n) {
		return findMaxPrice(prices, n, 1, 0);
	}

	public static int findMaxPrice(int[] prices, int n, int i, int sum) {
		if (i == prices.length || n < 0) {
			return 0;
		}
		if (n == 0) {
			return sum;
		}
		int op1 = findMaxPrice(prices, n - i, i, sum + prices[i]);
		int op2 = findMaxPrice(prices, n, i + 1, sum);
		return Math.max(op1, op2);
	}

	public static boolean isSum(int[] a, int num) {
		return isSum(a, num, 0, 0);
	}

	private static boolean isSum(int[] a, int num, int i, int count) {
		if (i >= a.length) {
			if (num == 0) {
				return true;
			}
			else
			{
				return false;
			}
		}
		
		if (count == 2) {
			return isSum(a, num , i + 1, 0);
		}
		boolean op1 = isSum(a, num - a[i], i + 1, count + 1);
		boolean op2 = isSum(a, num , i + 1, count);
		return op1 || op2;
	}
}
