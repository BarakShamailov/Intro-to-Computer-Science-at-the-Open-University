
public class Exam_2016_91 {
	public static void main(String[] args) {
		char[][] a = { { '0', '0', '0', '0' },
				       { '0', '0', 'K', '0' },
				       { '0', '0', '0', '0' },
				       { 'H', '0', '0', '0' } };
     System.out.println(locateHorse(a));
	}
	
	private static int locateHorse(char [] [] a) {
		return locateHorse(a,0,0);
		
	}
	private static int locateHorse(char [] [] a,int i ,int j) {
		if ( i == a.length) {
			return 0;
		}
		if ( j == a[i].length) {
			return locateHorse(a, i+1, 0);
		}
		if (a[i][j] == 'H') {
			
			int r = minPath(a, i, j);
			a[i][j] = 'H'; // not must
			return r;
		}
		return locateHorse(a, i, j+1);
	}

	public static int minPath(char[][] a, int i, int j) {
		if (i<0 ||  i >=a.length || j<0 || j >=a[i].length || a[i][j] == '!') {
			return -1;
		}
		if ( a[i][j] == 'K') {
			return 0;
		}
		a[i][j]= '!';//mark the locate where have we been 
		int op1 = minPath(a, i -2, j -1);
		int op2 = minPath(a, i -2, j +1);
		int op3 = minPath(a, i -1, j +2);
		int op4 = minPath(a, i +1, j +2);
		int op5 = minPath(a, i +2, j +1);
		int op6 = minPath(a, i +2, j -1);
		int op7 = minPath(a, i +1, j -2);
		int op8 = minPath(a, i -1, j -2);
		a[i][j] = '0';//remark
		int r = min(min(min(op1,op2),min(op3,op4)),min(min(op5,op6),min(op7,op8)));
		if ( r == -1) {
			return -1 ;
		}
		return r +1;
		
	}
	private static int min(int num1,int num2) {
		if(Math.min(num1,num2) == -1) {
			return Math.max(num1, num2);
		}
		return Math.min(num1,num2);
	}

}
