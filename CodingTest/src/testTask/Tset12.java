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
			System.out.printf("���� = %.2f\n",total);
			System.out.println("���� = A");
			System.out.println("�� = execellent");
			break;
		case 9 :
			System.out.printf("���� = %.2f\n",total);
			System.out.println("���� = A");
			System.out.println("�� = execellent");
			break;
		case 8 :
			System.out.printf("���� = %.2f\n",total);
			System.out.println("���� = B");
			System.out.println("�� = execellent");
			break;
		case 7 :
			System.out.printf("���� = %.2f\n",total);
			System.out.println("���� = C");
			System.out.println("�� = good");
			break;
		case 6 :
			System.out.printf("���� = %.2f\n",total);
			System.out.println("���� = D");
			System.out.println("�� = good");
			break;
		default:
			System.out.printf("���� = %.2f\n",total);
			System.out.println("���� = F");
			System.out.println("�� = poor");
			break;
		}
		
		

	}

}
