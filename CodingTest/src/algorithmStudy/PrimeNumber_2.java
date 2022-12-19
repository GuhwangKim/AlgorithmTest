package algorithmStudy;

public class PrimeNumber_2 {
	public static void main(String[] args) {
		int counter = 0;
		for (int n = 2; n <= 1000; n++) {
			int i ;
			for (i = 2; i < n; i++) { // ³ª´©´Â °÷ 
				counter++;
				if(n%i==0) {
					break;
				}
			}
			if(n==i) {
				System.out.println(n);
			}
		}
		System.out.println("³ª´°¼À ¼öÇà ¼ö "+counter);
	}
}
