
public class Exam_2019_84 {
	public static void main(String[] args) {
		int [] a = {5,7,-2,10};
		System.out.println(average(a));
		System.out.println(sumPower3(38));
	}
//****************************************************Q1**************************************
	public static boolean sumPower3(int num) {
		return sumPower3(num,0);
		
	}
	private static boolean sumPower3(int num, int power ) {
		if (num == 0)
			return true;
		if (num < 0)
			return false;
		if ((num - Math.pow(3, power)) < 0)
			return false;

		return sumPower3(num, power + 1) || sumPower3((int) (num - Math.pow(3, power)), power + 1);
		
	}
//******************************************Q2*************************************************
	
	public static int average(int []a) {
		double avgL = a[0];
		double avgR = 0;
		for(int i = 1; i < a.length; i++) {//calculate the first average
			avgR += a[i];
		}
		avgR /= a.length-1;
		 int index = 0;
		 double maxAvg = Math.abs(avgR-avgL);
		 
		 for(int i = 1; i < a.length -1 ;i++) {
			 
			 double sumSubLeft = avgL * i;
			 double sumSubRight = avgR * (a.length -i);
			 sumSubLeft += a[i];
			 sumSubRight -= a[i];
			 avgL = sumSubLeft / (i+1);
			 avgR = sumSubRight / (a.length - (i+1));
			 if(Math.abs(avgR-avgL) > maxAvg) {
				 index = i;
				 maxAvg = Math.abs(avgR-avgL);
			 }
			 
		 }
		 return index;
	}
		
}
