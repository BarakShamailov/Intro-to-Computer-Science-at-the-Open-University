
public class Exam_2015_85 {
	public static void main(String[] args) {

		String a = "abcdefgh";
		String b = "bcwxftjg";
		String c = "xwd";
		String d = "kmns";
		System.out.println(lcs(b, d));
	}
	public static int lcs(String s, String t) {
		return lcs(s, t,0,0,0);
	}
	private  static int lcs(String s, String t, int i,int j, int counter) {
		if (i == s.length())   {
			return counter;
		}
		if(j == t.length()){
			return lcs(s, t, i+1, 0, counter);
		}
		if (s.charAt(i) == t.charAt(j) ) {
			return lcs(s, t, i+1, j+1,counter+1);
			
		}
		return lcs(s, t, i, j+1, counter);
		
			
	}
	
	
	
}
