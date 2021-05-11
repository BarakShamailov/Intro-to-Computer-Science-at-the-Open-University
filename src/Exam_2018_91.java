
public class Exam_2018_91 {
	public static void main(String[] args) {
		//int[] stations = { 2, 8, 3, 4, 7, 1, 3, 2 };
		//int [] a = {1,1,3,7};
		//printAllSum(a, 6);
		//System.out.println(cheapestRoute(stations));
		int [] a = {3,0,0,4,7,9,0,0,0,0,11,15,0,19,20,0,0,31,40,0};
		System.out.println(findAlmostSorted(a, 3));
	}
	
	//*************************************Q2**************************************************
	public static int findAlmostSorted(int [] a, int num) {
		int low = 0;
		int high = a.length-1;
		while(low <= high) {
			int mid = (high + low) / 2 ;
			while(mid <= high && a[mid] == 0) {
				mid++;
			}
			if(mid > high) {
				mid--;
				while(mid >= low && a[mid] == 0) {
					mid--;
				}
				if(mid < low) {
					return -1;
				}
			}
			if(a[mid] == num) {
				return mid;
				}
			if(a[mid] < num) {
				low = mid +1;
			}
			else {
				high = mid -1 ;
			}
		}
		return -1;
	}
	
	
	
	//*************************************Q1V1**************************************************	
	public static void printAllSum(int [] a, int sum) {
		printAllSum(a, sum ,0,"");
	}
	private static void printAllSum(int [] a, int sum,int i ,String s) {
		if(i == a.length ) {//when we arrived to the end of the array and sum == 0 then print s
			if(sum  == 0) {
		
			System.out.println(s);
			}
			return;//return nothing
			
		}
		printAllSum(a, sum, i+1, s +"0"); //i am not taking and moving to the next index
		printAllSum(a, sum - a[i], i+1, s+"1");//i am taking and moving to the next index
				
	}
//*************************************Q1V2**************************************************
	public static int cheapestRoute(int[] stations) {
		return cheapestRoute(stations, 0, 0);
	}

	private static int cheapestRoute(int[] stations, int i, int sum) {
		if (i >= stations.length) {
			return sum;
		}
		if (i == stations.length - 2) {
			return cheapestRoute(stations, i + 1, sum + stations[i]);
		}
		return Math.min(cheapestRoute(stations, i + 1, sum + stations[i]),
				cheapestRoute(stations, i + 2, sum + stations[i]));
	}

}
