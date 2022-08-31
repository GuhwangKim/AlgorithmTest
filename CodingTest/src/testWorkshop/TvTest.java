package testWorkshop;


public class TvTest extends Tv {
	public TvTest(String name, int price, String description) {
		super(name, price, description);
	}

	public static void main(String[] args) {
		
		TvTest tv[]=new TvTest[3];
		tv[0]=new TvTest("INFINIA", 1500000, "LED TV");
		tv[1]=new TvTest("XCANVAS", 1000000, "LCD TV");
		tv[2]=new TvTest("CINEMA", 2000000, "3D TV");
	
		for (int i = 0; i < tv.length; i++) {
			System.out.println(tv[i].toString());
		}
		
	}

}
