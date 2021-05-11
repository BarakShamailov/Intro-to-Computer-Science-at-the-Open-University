
public class Exam_2021_85 {
	public static void main(String[] args) {
		int[][] mat = { { 0, 15, 80, 90 }, { -1, 0, 40, 50 }, { -1, -1, 0, 70 }, { -1, -1, -1, 0 } };
		System.out.println(minPrice(mat));
		int[] arr = { 2, 3, 8, 14, 15, 35 };
		System.out.println(findAverage(arr, 10.0));

	}
	//************************************************Q2***********************************

	public static boolean findAverage(int [] a,double x)
	{
		int sum = 0;
		double counter = 0 ;
		for( int i = 0 ; i < a.length; i ++)
		{
			sum+=a[i];
			counter +=1;
		}
		int left = 0;
		int right = a.length-1;
		while( left <= right)
		{
			double avg = sum / counter;
			if ( avg == x)
			{
				System.out.println(left + " --- " +  right);
				return true;
			}
			if(avg > x)
			{
				sum -=a[right];
				right--;
				counter--;
			}
			else
			{
				sum-=a[left];
				left++;
				counter--;
			}
		}
		return false;
		
	}

	// ***************************************Q1*******************************

	public static int minPrice(int[][] mat) {
		return minPrice(mat, 0, 1);
	}

	private static int minPrice(int[][] mat, int i, int j)
	{
		if(i == mat.length-1)
		{
			return 0;
		}
		if(j == mat[i].length)
		{
			return Integer.MAX_VALUE;
		}
		
		int op1 = minPrice(mat, i, j+1);
		int op2 = minPrice(mat, j, j+1)+mat[i][j];
		return Math.min(op1, op2);
	}
}
