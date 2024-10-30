package src;

public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("the lion king","animation","roger",87,19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		System.out.println(anOrder.totalCost());
		// TODO Auto-generated method stub

	}

}
