package testTask;

public class Tset12 {

	public static void main(String[] args) {
		int mid=Integer.parseInt(args[0]);
		int fin=Integer.parseInt(args[1]);
		int rep=Integer.parseInt(args[2]);
		int abs=Integer.parseInt(args[3]);
		
		double total=((mid+fin)/2)*0.6+(rep*0.2)+(abs*0.2);
		
		int total1=(int)(total/10);
		
		switch (total1) {
		case 10 :
			System.out.printf("성적 = %.2f\n",total);
			System.out.println("학점 = A");
			System.out.println("평가 = execellent");
			break;
		case 9 :
			System.out.printf("성적 = %.2f\n",total);
			System.out.println("학점 = A");
			System.out.println("평가 = execellent");
			break;
		case 8 :
			System.out.printf("성적 = %.2f\n",total);
			System.out.println("학점 = B");
			System.out.println("평가 = execellent");
			break;
		case 7 :
			System.out.printf("성적 = %.2f\n",total);
			System.out.println("학점 = C");
			System.out.println("평가 = good");
			break;
		case 6 :
			System.out.printf("성적 = %.2f\n",total);
			System.out.println("학점 = D");
			System.out.println("평가 = good");
			break;
		default:
			System.out.printf("성적 = %.2f\n",total);
			System.out.println("학점 = F");
			System.out.println("평가 = poor");
			break;
		}
		
		

	}

}
