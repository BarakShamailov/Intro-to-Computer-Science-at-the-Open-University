
public class Exam_2019_83 {

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 1, 1, 1, 1, 1 },
				        { 1, 1, 0, 1, 0, 0, 1 }, 
				        { 1, 1, 1, 1, 0, 1, 1 } };
		//System.out.println(longestPath(mat, 2, 6));
		int [] [] arr = { { -99, -72, -64, -55, -10, -5, -28 },
		               { -6, -5, -2, -1, 11, 13, 22 }, 
		               { -90, -87, -65, -12, 14, 16, 23 },
		               {-8, -70, -44, 0, 18, 20, 28 },
		               { 0, 12, 14, 20, 28, 30, 35 }};
		System.out.println(howManyNegativeNumbers(arr));
		
	}
	//***********************************************Q2************************************

	
	public static int howManyNegativeNumbers(int [] [] arr) {
		int totalRow = arr.length;
		int totalCol = arr[0].length;
		int row = 0;
		int col = totalCol-1;
		int counter = 0;
		while(row <= totalRow -1 && col>=0) {
			if(arr[row][col] < 0) {
				counter += col+1;
				row++;
			}
			else{
				col--;
			}
		}
		return counter;
	}
	
	
	//***********************************************Q1************************************

	
	
	
	public static int longestPath(int mat[][], int x, int y) {

       
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[x].length) {
            return 0;
        }

        
        return longestPath(mat, x, y, 0, 0, 0);
    }

  
    public static int longestPath(int[][] mat, int x, int y, int i, int j, int counter) {

        if (i < 0 || i >= mat.length || j < 0 || j >= mat[i].length) {
            return 0;
        }

       
        if (mat[i][j] == 0) {
            return 0;
        }
    
        mat[i][j] = 0;
        counter++;

     
        if (i == x && j == y) {
        	mat[i][j] = 1;
            return counter;
        }
  
        int a = longestPath(mat, x, y, i + 1, j, counter); //go down
        int b = longestPath(mat, x, y, i, j + 1, counter); //go right
        int c = longestPath(mat, x, y, i - 1, j, counter); //go up
        int d = longestPath(mat, x, y, i, j - 1, counter); //go left
        
        mat[i][j] = 1;
        
        return Math.max(Math.max(a, b), Math.max(c, d));
     
    }
	
}
