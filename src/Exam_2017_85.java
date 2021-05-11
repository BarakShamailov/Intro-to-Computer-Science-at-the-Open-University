

public class Exam_2017_85 {
	public static void main(String[] args) {
		int [] b = {10,2,30,40};
		int [] a = {0,4,6,11,11};
		System.out.println(oneFiveSeven(10));
		printClosest(a, b, 70);
	}
	
	public static int oneFiveSeven(int n) {
		return oneFiveSeven(n, 0);
	}
	private static int oneFiveSeven(int n, int counter) {
		if (n == 0) {
			return counter;
		}
		if ( n < 0) {
			return Integer.MAX_VALUE;
		}
	
		int op1 = oneFiveSeven(n-1,counter+1);
		int op2 = oneFiveSeven(n-5,counter+1);
		int op3 = oneFiveSeven(n-7,counter+1);
		return Math.min(op2, Math.min(op1, op3));

	}
	//********************************Q2**********************************
	public static void printClosest(int[]a,int [] b,int x) {
		int indexA = a.length - 1;
		int indexB = 0;
		int diff = Integer.MAX_VALUE;
		int num1 = 0;
		int num2 = 0;
		while (indexA > 0 && indexB < b.length) {
			int sum = a[indexA] + b[indexB];

			if (Math.abs(x - sum) < diff) {
				diff = Math.abs(x - sum);
				num1 = a[indexA];
				num2 = b[indexB];
			}

			if (x > sum) {
				indexB++;
			} else {
				if (x < sum) {
					indexA--;
				} else {
					indexA = 0;
				}
			}
		}

		System.out.println(num1 + " and " + num2);
	}
}
