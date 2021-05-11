
public class Exam_2018_83 {
	public static void main(String[] args) {
		
	
	int [] [] drm = {{2,0,1,2,3},
	                 {2,3,5,5,4},
	                 {8,-1,6,8,7},
	                 {3,4,7,2,4},
	                 {2,4,3,1,2}};
	System.out.println(prince(drm, 0, 0));
	}
	public static int prince(int [] [] drm,int i, int j) {
		int op1 = prince(drm, i+1, j,drm[i][j]);
		int op2 = prince(drm, i-1, j,drm[i][j]);
		int op3 = prince(drm, i, j+1,drm[i][j]);
		int op4 = prince(drm, i, j-1,drm[i][j]);
		int result = Math.min(Math.min(op2, op1), Math.min(op3, op4));
		if (result == Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		return 1+result ;
	}
	public static int prince(int [] [] drm,int i, int j, int prevCell) {
		if ( i < 0 || i == drm.length || j < 0 || j == drm[i].length ) {
			return Integer.MAX_VALUE; 
		}
		if( drm[i][j] == -2) {
			return Integer.MAX_VALUE;
		}
		if(drm[i][j] == -1) {
			return 1;
		}
		if (prevCell - 2 > drm[i][j] || prevCell +1 < drm[i][j]) {
			return Integer.MAX_VALUE;
		}
		int temp = drm[i][j];
		drm[i][j] = -2;
		int op1 = prince(drm, i+1, j,temp);
		int op2 = prince(drm, i-1, j,temp);
		int op3 = prince(drm, i, j+1,temp);
		int op4 = prince(drm, i, j-1,temp);
		drm[i][j] = temp;
		int result = Math.min(Math.min(op2, op1), Math.min(op3, op4));
		if (result == Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		return 1+result ;
	}

}
