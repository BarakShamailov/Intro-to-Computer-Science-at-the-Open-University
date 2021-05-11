
public class Exam_2011_87 {
	
	public static void main(String[] args)
	{
		int[] [] mat = {{8,9,5,1,7,8},{9,5,5,16,17,18},{10,11,6,15,2,19},{7,12,13,14,4,20},{9,13,4,15,22,21},{10,11,12,12,23,22}};
		System.out.println(isPath(mat));
	}
	
	public static boolean isPath(int [] [] mat)
	{
		return isPath(mat, 0,0,mat[0][0],"" );
	}
	private static boolean isPath(int [] [] mat , int i,int j , int prevCell,String s)
	{
		if ( i < 0 || i == mat.length || j < 0 || j == mat[i].length || mat[i][j] - prevCell > 1 ||  mat[i][j] - prevCell < 0 )
		{
			return false;
		}
		if( i == mat.length -1 && j == mat[i].length-1)
		{
			s+= mat[i][j];
			System.out.println(s);
			return true;
		}
		
		
		boolean op1 = isPath(mat, i+1, j, mat[i][j],s  + mat[i][j]+ "->");
		boolean op2 = isPath(mat, i-1, j, mat[i][j],s+ mat[i][j]+ "->");
		boolean op3 = isPath(mat, i, j+1, mat[i][j],s  + mat[i][j]+ "->");
		boolean op4 = isPath(mat, i, j-1, mat[i][j],s  + mat[i][j]+ "->");
		
		return op1 || op2 || op3 || op4;
	}

}
