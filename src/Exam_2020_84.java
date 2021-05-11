
public class Exam_2020_84 {

	public static void main(String[] args) {

		char[][] mat = { { 'b', 'z', 'x', 'c', 'd' }, 
				{ 's', 'h', 'a', 'z', 'x' },
				{ 'r', 'w', 'l', 'o', 'm' },
				{ 'a', 'r', 'n', 't', 'n' },
				{ 'k', 'b', 'r', 'i', 'n' } };

		findWord(mat, "shalom");
	}
	public static void findWord(char [] [] mat , String word)
	{
		int [] [] arr = new int[mat.length] [mat[0].length];
		if(findWord(mat, word, 0, 0,arr))
		{
			
			print(arr);
		}
		else
		{
			System.out.println("No Such Word");
		}
	}
	private static boolean findWord(char [] [] mat , String word ,int  i, int  j ,int [] [] arr)
	{
		if ( i == mat.length)
		{
			return false;
		}
		if( j == mat[i].length )
		{
			return findWord(mat, word, i+1, 0, arr);
		}
		if ( mat[i][j] == word.charAt(0))
		{
			
			return findWord(mat, word, i, j, arr,0);
		}
		arr[i][j] = 0;
		return findWord(mat, word, i, j+1, arr);
	}
	private static boolean findWord(char [] [] mat , String word ,int  i, int  j ,int [] [] arr , int counter)
	{
		if ( i < 0 || i ==  mat.length || j < 0 || j == mat[i].length  )
		{
			return false;
		}
		if( counter == word.length())
		{
			return true;
		}
		if ( mat[i][j] == word.charAt(counter))
		{
			counter +=1;
			arr[i][j] = counter;
			boolean op1 = findWord(mat, word, i+1, j, arr, counter);
			boolean op2 = findWord(mat, word, i-1, j, arr, counter);
			boolean op3 = findWord(mat, word, i, j-1, arr, counter);
			boolean op4 = findWord(mat, word, i, j+1, arr, counter);
			return op1 || op2 || op3 || op4 ;
		}
		
		return false ;

	}

	

	public static void print(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			if (i == 0) {
				System.out.print("");
			} else {
				System.out.println();
			}
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + "\t");
			}
		}
	}

}
