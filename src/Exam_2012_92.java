
public class Exam_2012_92 {
	
	public static void main(String[] args)
	{
		int[] a = {2,4,1,6,4,2,4,3,5};
		int []arr = {1,4,3,1,2,4,3};
		System.out.println(isWay(arr));
	}
	
	public static boolean isWay(int [] a)
	{
		return isWay(a,0,a[0],"");
	}
	
	private static boolean isWay(int [] a , int i,int prevCell ,String s)
	{
		if ( i < 0 || i >= a.length || a[i] == -1)
		{
			return false;
		}
	
		
		if ( i == a.length-1)
		{
			System.out.println(s);
			return true;
		}
		
		prevCell = a[i];
	    a[i] = -1;
		boolean op1 = isWay(a, i+prevCell,prevCell,s + " right: " + prevCell);
		boolean op2 = isWay(a, i-prevCell,prevCell,s + " left: " + prevCell);
		a[i] = prevCell;
		return op1 || op2;
	}

	
	

}
