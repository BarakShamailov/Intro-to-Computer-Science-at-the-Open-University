
public class Exam_2014_85 {
	public static void main(String[] args) {
		int [] [] mat = {
				{3,8,7,1},
				{5,15,2,4},
				{12,14,-13,22},
				{13,16,17,52}};
		printPath(mat);
		System.out.println();
		
		int[] a = {3,48,49,52,65,70,-5};
		System.out.println(findMax(a));
	}
	public static void printPath (int[][] mat) {
		printPath(mat,0,0,Integer.MIN_VALUE);
	}
	private static void printPath (int[][] mat , int i ,int j, int prevCell ) {
		if (i < 0 || i == mat.length || j < 0 || j == mat[i].length || mat[i][j] == Integer.MAX_VALUE ) {
			
			return;
		}
		if (prevCell > mat[i][j]) {
			mat[i][j] = Integer.MAX_VALUE;
			return;
		}
		System.out.print("("+ i + ","  + j+")");
		//prevCell = mat[i][j];
		
		printPath(mat, i - 1, j, mat[i][j]);
		printPath(mat, i, j + 1, mat[i][j]);
		printPath(mat, i + 1, j, mat[i][j]);
		printPath(mat, i, j - 1, mat[i][j]);
	}
	
	public static int findMax(int[] a) {
		if (a[a.length -1] < a[0] ) {
			int high = a.length-1;
			int low = 0;
			while(low <= high)
			{
				int mid = (low+high) / 2;
				if(a[mid] > a[mid+1] )
				{
					return mid;
				}
				if(a[mid] < a[0])
				{
					high = mid - 1;
				}
				else
				{
					low = mid +1;
				}
			}
		}
		return a.length-1;
	}

}
