
public class Exam_2012_82 {
	public static void main(String[] args)
	{
		int[] a = {4,5};
		int n = 13;
		System.out.println(isSumOf(a, n));
		int [] b = {-5,-5,1,1,1,1,1,1,1,1,2,2,2,2,2,3,3,3,67,67,99};
		System.out.println(count(b, 99));
	}
		public static boolean isSumOf(int [] a , int n)
		{
			return isSumOf(a, n,0,"");
		}
		private static boolean isSumOf(int [] a , int n, int i ,String s)
		{
			if(i == a.length)
			{
				if(n == 0)
				{
					System.out.println(s);
					return true;
				}
				return false;
			}
			if ( n < 0)
			{
				return false;
			}
			boolean op1 = isSumOf(a, n-a[i], i, s + a[i] + " ");
			boolean op2 = isSumOf(a, n, i+1, s);
			return op1 || op2;
			
		}
		
		public static int count(int [] a,int x)
		{
			int low = 0;
			int high = a.length-1;
			int leftIndex = -1;
			while(low <= high && leftIndex == -1)
			{
				int mid =( high+low ) / 2;
				if(a[mid] == x && (mid == low || a[mid-1] < x))
				{
					leftIndex = mid;
				}
				if(a[mid] > x || ( a[mid] == x && mid > low && (a[mid-1] == x)))
				{
					high = mid -1;
				}
				if(a[mid] < x)
				{
					low = mid+1;
				}
			}
			if(leftIndex == -1)
				{
				return 0;
				}
			low = 0;
			high = a.length-1;
			int rightIndex = -1;
			while(low <= high && rightIndex == -1)
			{
				int mid =(high+low) / 2;
				if(a[mid] == x && (mid == high || a[mid+1] > x))
				{
					rightIndex = mid;
				}
				if(a[mid] > x )
				{
					high = mid -1;
				}
				if(a[mid] < x || ( a[mid] == x && mid < high && (a[mid+1] == x)))
				{
					low = mid +1;
				}
			}
			return rightIndex - leftIndex + 1;
		}

}
