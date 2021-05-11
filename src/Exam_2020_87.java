
public class Exam_2020_87 {
	public static void main(String[] args) {
		//int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
		//printTriplets(a, 30);
		int [] [] mat = {{0,1,2},{3,4,5},{6,7,8}};
		System.out.println(totalWays(mat, 1));
	}
	//**************************************Q1**********************************************
	
	public static int totalWays(int [] [] mat,int k) {
		return totalWays(mat, k,0,1,false) + totalWays(mat, k,1,0,true);
	}
	private static int totalWays(int [] [] mat,int k,int i,int j, boolean isDown) {
		if( i >= mat.length || j >= mat[i].length || k < 0) {
			return 0;
		}
		if(i == mat.length -1 && j == mat[i].length -1 && k == 0) {
			return 1;
		}
		int op1 = totalWays(mat, isDown ? k : k-1,i+1,j,true);
		int op2 = totalWays(mat,!isDown ? k : k-1, i,j+1,false);
		
		return op1 +op2;
	}

	//**************************************Q2***********************************************
	public static void printTriplets(int[] a, int num) {
		for (int high = a.length - 1; high > 1; high--) {
			int low = 0;
			int mid = high - 1;
			while (low < mid) {
				if (a[low] * a[mid] * a[high] == num) {
					System.out.println(a[low] + "\t" + a[mid] + "\t" + a[high]);
				}
				if (a[low] * a[mid] * a[high] > num) {
					mid--;
				} else {
					low++;
				}
			}
		}
	}
}
