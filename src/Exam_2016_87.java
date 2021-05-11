
public class Exam_2016_87 {

	
	public static void main(String[] args) {
		System.out.println(count(4));
	}
	public static int count(int sum) {
		return count(sum,1);
		
	}
	
	private static int count(int sum , int num) {
		if (sum == num ) {
			return 1;
		}
		if(num > sum) {
			return 0;
		}
		return count(sum, num+1 ) + count(sum - num , num +1);
	}
}
