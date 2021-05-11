
public class Exam_2017_90 {
	
	public static void main(String[] args) {
		Item i1 = new Item(10,60);
		Item i2 = new Item(20,100);
		Item i3 = new Item(30,120);
		Item i4 = new Item(15,200);
		Item [] items = {i1,i2,i3,i4};
		System.out.println(knapSack(items, 30));
		int [] a = {1,2,4,10,11,15};
		System.out.println(findSmallest(a));
	}
	
	public static int knapSack(Item [] items , int w) {
	return knapSack(items, w,0,0);
		
	}
	private static int knapSack(Item [] items , int w, int i,int sum) {
		if ( w < 0 ) {
			return 0 ;
		}
		
		if (i == items.length) {
			return sum;
		}
		
		int op1 = knapSack(items, w ,i+1,sum );
		int op2 = knapSack(items, w-items[i].getWeight(), i+1,sum + items[i].getValue());
		return Math.max(op1, op2);
		
	}
	
	//*************************************Q2**************************************
	
	public static int findSmallest(int[] a) {
		
		int nextSum = 1;
		for (int i = 0; i < a.length; i++) {
			
			if(a[i] > nextSum) {
				return nextSum;
			}
			nextSum += a[i];
		}
		return nextSum;
	}

	

		
	
	

}
