package algorithmStudy;

public class Max3_1 {
	static int max (int a, int b, int c) {
		int max = a;
		if(b>max) {
			max = b;
		}
		if(c>max) {
			max = c;
		}
		return max;
	}
	
	
}
