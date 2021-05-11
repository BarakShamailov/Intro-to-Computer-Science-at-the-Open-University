
public class Exam_2020_81 {
	public static void main(String[] args) {
		int[] lengths = { 2, 5, 10, 20, 50 };
		System.out.println(makeSum(lengths, 4, 40));
		int [] a = {10,4,2,5,6,3,8,1,5,9};
		minimumSubK(a, 3);
	}
//*****************************************Q1***************************************************
	public static int makeSum(int[] lengths, int k, int num) {
		return makeSum(lengths, k, num, 0);
	}

	private static int makeSum(int[] lengths, int k, int num, int i) {
		if (i == lengths.length || k < 0) {
			return 0;
		}
		if (k >= 0 && num == 0) {
			return 1;
		}
		int option1 = makeSum(lengths, k, num, i + 1);
		int option2 = makeSum(lengths, k - 1, num - lengths[i], i);
		return option1 + option2;
	}
	
	//***********************************Q2*****************************************************
	public static void minimumSubK(int [] a , int k) {
		int minSum = 0;
		for(int i = 0 ; i < k ; i++) {
			minSum += a[i];
		}
		int sum = minSum;
		int index = 0 ;
		
		for(int i = 0 ; i < a.length -k ; i++) {
			sum -= a[i];
			sum += a[i+k];
			if(sum < minSum) {
				minSum= sum;
				index = i+1;
			}
	
			
		}
		System.out.println("Minimum sum sub-array is (" + index + "," + (index +k-1) + ")");
	}
	

}
