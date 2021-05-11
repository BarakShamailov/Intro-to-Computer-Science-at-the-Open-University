
public class Exam_2015_94 {
	public static void main(String[] args) {
		String s = "x12y3348";
		System.out.println(longOrdNum(s));
		int [] a = {1,4,13,6,0,19};
		int k = 43;
		smallestSub(a,k);
		
	}
	//*************************************************Q1****************************************
	public static int longOrdNum(String s) {
		if ( s == null|| s.length()==0 )
		    return 0;
		return  longOrdNum(s, 0,0,0,'0');

		}
		
		private static int longOrdNum(String s, int i, int sum, int max, int prev){
		    if(sum>max)
		        max = sum;

		    if(i==s.length())
		        return max;
		    if(s.charAt(i) > '9')
		        return longOrdNum(s, i+1, 0,max, -1); 
		    if (s.charAt(i) <= '9' && s.charAt(i) >prev)
		        return longOrdNum(s, i+1, sum+1, max,s.charAt(i)); 
		    else 
		        return longOrdNum(s,i+1, 1, max,s.charAt(i));
		}
    //********************************************Q2*******************************************
public static void smallestSub(int [] a , int k) {
	int counter = 0;
	int counterMin = Integer.MAX_VALUE;
	int sum = 0; 
	int sumMin = Integer.MAX_VALUE;
	int left = 0;
	int right = 0;
	while(right < a.length) {
		sum += a[right];
		right++;
		counter++;
		if (sum > k) {
			sumMin = Math.min(sum,sumMin);
			counterMin = Math.min(counter,counterMin);
			left++;
			right = left;
			counter = 0;
			sum = 0;
		}
		else {
			if (left == 0 && right == a.length -1 && sum <=k) {
				counterMin = a.length +1 ;
				
			}
		}
		
		
	}
	System.out.println("The minimum size is : " + counterMin);
}
}
