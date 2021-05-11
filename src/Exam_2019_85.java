
public class Exam_2019_85 {
	public static void main(String[] args) {
		int[][] mat = { { 1, 3, 1, 6 }, { 2, 8, 1, 2 }, { 6, 2, 7, 5 }, { 2, 4, 1, 3 } };
		System.out.println(howManyPaths(mat));
		int [] a = {7,10,13,16,22,25};
		System.out.println(missingValue(a));
		int [] arr = {1,3,2,3,10,10,3,2,4};
		System.out.println(longestPalindrome(arr));
	}
	//******************************************Q1V2*********************************************
	public static int longestPalindrome(int[] arr) {
		return longestPalindrome(arr, 0, arr.length - 1);
	}
	
	private static int longestPalindrome(int[] arr, int i, int j) {
		if(j < 0 || i == arr.length) {
			return 0;
		}
		
		if(isPalindrome(arr, i, j)) {
			return Math.abs(j - i) + 1;
		}
		
		int opt1 = longestPalindrome(arr, i + 1, j);
		int opt2 = longestPalindrome(arr, i, j - 1);
		
		return Math.max(opt1, opt2);
		
	}
	
	public static boolean isPalindrome(int[] arr, int start, int end) {
		if(start == end || start > end) {
			return true;
		}
		
		if(arr[start] != arr[end]) {
			return false;
		}
		
		return isPalindrome(arr, start + 1, end - 1);
	}
//******************************************Q1*********************************************
	
	public static int howManyPaths(int [] [] mat)
	{
		return howManyPaths(mat,0,0,mat[0][0]);
	}
	
	private static int howManyPaths(int [] [] mat,int i ,int j, int prevCell)
	{
		if(i < 0 || i >= mat.length || j < 0 || j >= mat[i].length || prevCell == 0)
		{
			return 0;
		}
		if(i == mat.length -1 && j == mat[i].length-1)
		{
			return 1;
		}
		prevCell = mat[i][j];
		mat[i][j] = 0;
		int op1 = howManyPaths(mat, i + prevCell, j, prevCell);
		int op2 = howManyPaths(mat, i - prevCell, j, prevCell);
		int op3 = howManyPaths(mat, i, j + prevCell, prevCell);
		int op4 = howManyPaths(mat, i, j - prevCell, prevCell);
		mat[i][j] = prevCell;
		return op1+op2+op3+op4;


		
	}
    
    //************************************************Q2********************************
    public static int missingValue(int[] a) {

		int num = 0;
		int d = (a[a.length - 1] - a[0]) / a.length;
		int end = a.length - 1;
		int start = 0;
		while (start <= end) {

			int mid = (end + start) / 2;
			if (a[mid] - d != a[mid - 1]) {
				num = a[mid] - d;
				break;
			}
			if (a[0] + d * mid == a[mid]) {
				start = mid;
			}
			
			else {
			end = mid - 1;
			}
			}
		return num;

	}

}
