
public class Exam_2015_89 {
	public static void main(String[] args) {
		//int []a = {2,15,3,4,2,5};
	//	System.out.println(splitEqualMult(a));
		int [] a = { 1,2,5,3,6,10,9};
		System.out.println(findX(a, 5));
	}
	// **********************Q2**********************
	public static boolean findX(int [] b , int x) {
		int low = 0 ;
		int high = b.length -1 ;
        while ( low < high) {
	        int mid = (high+low) / 2;
	        if ( b[mid] + b[mid+1] == x) {
	        	return true;
	        }
	        if(x > b[mid] + b[mid+1]) {
	        	low = mid +1 ;
	        }
	        else {
	        	high = mid;
	        }
        }
		return false;
	}
	// **********************Q1**********************
	
	public static boolean splitEqualMult(int [] a) {
		return splitEqualMult(a,0,1,1);
	}
	private static boolean splitEqualMult(int [] a,int i, int sum1 ,int sum2) {
	if ( i == a.length) {
		if(sum1 == sum2) {
			return true;
		}
		else {
			return false;
		}
	}
	boolean option1 = splitEqualMult(a, i+1, sum1*a[i], sum2);
	boolean option2 = splitEqualMult(a, i+1, sum1, sum2*a[i]);
	return option1 || option2;
	}

}
