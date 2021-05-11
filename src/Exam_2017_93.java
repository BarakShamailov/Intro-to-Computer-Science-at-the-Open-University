
public class Exam_2017_93 {
	public static void main(String[] args) {
	   boolean[][] mat = { { false, false, false, false, true }, { false, true, true, true, false },
				{ false, false, true, true, false }, { true, false, false, false, false },
				{ true, true, false, false, false }, };
System.out.println(cntTrueReg(mat));
		
	}
	public static int cntTrueReg( boolean [] [] mat) {
		return cntTrueReg(mat,0,0,0);
	}
	private static int cntTrueReg( boolean [] [] mat,int i , int j,int counter) {
	if ( i == mat.length) {
		return counter;
	}
	if ( j == mat[i].length) {
		return cntTrueReg(mat,i+1,0,counter);
	}
	if(mat[i][j] == true) {
		counter+=1;
		toFalse(mat, i, j);
		
		
	}
	return cntTrueReg(mat,i,j+1,counter);
	}
	private static void toFalse( boolean [] [] mat,int i , int j) {
		if (i >= 0 && i < mat.length && j >= 0 && j < mat[i].length && mat[i][j]) {
			mat[i][j] = false;
			toFalse(mat, i + 1, j);//up
			toFalse(mat, i - 1, j);//down
			toFalse(mat, i, j + 1);//right
			toFalse(mat, i, j - 1);//left
		}
	}

}
