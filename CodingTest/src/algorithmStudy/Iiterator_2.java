package algorithmStudy;
import java.util.Scanner;

public class Iiterator_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 1; i <= 5; i++) {
			sum+=(i+(11-i));
		}
		
		int n = 15;
		int w = 4;
		
		for (int i = 0; i < n/2; i++) {
			System.out.print("+-");
		}
		if(n%2!=0) {
			System.out.print("+");
		}
		
		for (int i = 0; i < n/w; i++) {
			System.out.println("*".repeat(w));
		}
		int rest = n%w;
		if(rest!=0) {
			System.out.println("*".repeat(rest));
		}
		
		System.out.print("  |");
		for (int i = 1; i <= 9; i++) {
			System.out.print(" "+i);
		}
		System.out.println();
		System.out.println("--+-------------------");
		for (int i = 1; i <= 9; i++) {
			System.out.print(i+"|");
			for (int j = 1; j<= 9; j++) {
				System.out.print(" "+(i+j));
			}
			System.out.println();
		}
		
		int q =5;
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < q; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
