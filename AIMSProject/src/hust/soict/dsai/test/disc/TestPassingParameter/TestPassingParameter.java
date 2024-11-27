package hust.soict.dsai.test.disc.TestPassingParameter;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderelaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderelaDVD);
		//Swap(jungleDVD, cinderelaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderelaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderelaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
	// Write a swap() method that can correctly swap the two objects
	public static void Swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String tmp = dvd1.getTitle();
		dvd1.setTitle(dvd2.getTitle()); 
		dvd2.setTitle(tmp);
	}

}
