
public class Exam_2019_87 {
	public static void main(String[] args) {
		int[] a = { 1, 2,3, 4 };
		System.out.println(minDiff(a));
		String s = "abcbcabcacabcc";
		//System.out.println(subStrC(s, 'c'));
	//	System.out.println(subStrMaxC("abcbc", 'c', 0));
	}

	// ******************************************Q1*******************************************************
	public static int minDiff(int[] a) {
		return minDiff(a, 0, 0, 0);
	}

	private static int minDiff(int[] a, int i, int sum1, int sum2) {
		if (i == a.length) {
			return Math.abs(sum1 - sum2);
		}
		int op1 = minDiff(a, i + 1, sum1 + a[i], sum2);
		int op2 = minDiff(a, i + 1, sum1, sum2 + a[i]);
		return Math.min(op1, op2);

	}

	// ******************************************Q2*******************************************************
	public static int subStrC(String s, char c) {
		int counter = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				counter++;
			}
			
		}
		return Math.max(0, counter -2); //we will count the number of c in the string and reduce from him 2 because evert sun string starting and ending with 'c'.
	}
	
	public static int subStrMaxC(String s ,char c, int k) {
		int countC = 0;
		int countRagil = 0;
		for (int i = 0 ; i < s.length() ; i++) {
			if (s.charAt(i) == c) {
				countRagil += Math.min(k+1, countC);
				countC++;
			}
		}
		return countRagil;
		
	}
}
