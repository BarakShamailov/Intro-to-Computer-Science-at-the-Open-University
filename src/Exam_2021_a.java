
public class Exam_2021_a {

	public static void main(String[] args) {
		//int[] a = { 0, 1, 3, 10, 9, 10, 17, 17, 20 };
		//System.out.println(findMaxPrice(a, 8));

int [] a1 = {1,12,15,26,38};
int [] a2 = {12,13,18,30,45};
System.out.println(getMedian(a1, a2));
		
	}
//******************************************Q2**********************************

	private static int getMid(int[] a, int mid) {
		if (mid % 2 == 0) {
			return (a[mid] + a[mid + 1]) / 2;
		} else
			return a[mid];
	}

	public static int getMedian(int[] a, int[] b) {
		int lowa = 0;
		int higha = a.length - 1;
		int lowb = 0;
		int highb = b.length - 1;
		while ((higha - lowa) > 1) {
			int mida = (lowa + higha) / 2;
			int midb = (lowb + highb) / 2;

			if (getMid(a, mida) == getMid(b, midb))
				return getMid(a, mida);

			else if (a[mida] < b[midb]) {
				lowa = mida;
				highb = midb;
			} else {
				lowb = midb;
				higha = mida;
			}

		}
		return ((Math.max(a[lowa], b[lowb]) + Math.min(a[higha], b[highb])) / 2);
	}

//******************************************Q1**********************************
	public static int findMaxPrice(int[] prices, int n) {
		return findMaxPrice(prices, n, 0, 1);

	}

	private static int findMaxPrice(int[] prices, int n, int sum, int i) {
		if (i == prices.length || n < 0) {
			return 0;
		}
		if (n == 0) {
			return sum;
		}
		int option1 = findMaxPrice(prices, n - i, sum + prices[i], i);
		int option2 = findMaxPrice(prices, n, sum, i + 1);
		return Math.max(option1, option2);

	}

}
