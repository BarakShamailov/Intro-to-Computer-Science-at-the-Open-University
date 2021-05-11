
public class Exam_2019_93 {
	
	public static void main(String[] args) {
		int []a = {5, 4, 2, 1, 3};
		int num = 1;
		System.out.println(isSum(a, 12));
		int [] road1= { 5,4,5,8,12,9,9,3};
		int [] road2= { 7,3,3,12,10,2,10,7};
		System.out.println(shortestRoad(road1, road2));
	}
	//************************************************Q2**************************************
	public static int shortestRoad(int [] road1 , int road2 []) {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0 ; i< road1.length; i++) {
			sum1 += road1[i];
			sum2 += road2[i];
		}
		int shortest = Math.min(sum1, sum2);
		for( int i = 0 ; i < road2.length; i++ ) {
			sum1 = sum1 - road1[i]+ road2[i];
			sum2 = sum2- road2[i]+ road1[i];
			shortest = Math.min(shortest, Math.min(sum2, sum1));
			
			
		}
		return shortest;
	}
	//************************************************Q1**************************************
	//another solution in Exam_exmpale
	public static boolean isSum(int[] a, int num) {
		return isSum(a, num, 0, 0);
	}

	private static boolean isSum(int[] a, int num, int pre, int i) {
		if ( i == a.length) {
			return false;
		}
		if(num < 0) {
			return false;
		}
		if(num == 0) {
			return true;
		}
		
		boolean op1 = false ,op2= false,op3 = false;
		if ( pre + 1 +1 == i) {
			op1 = isSum(a, num - a[i], i, i + 2);
		}
		else {
			op2 = isSum(a, num -a[i], i , i+1);
			op3 = isSum(a, num, i , i+1);
		}
		return op1 || op2 || op3;

	}
	
	
	
}
