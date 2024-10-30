package src;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED =20;
	private DigitalVideoDisc itemsOrdered[]= new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int qtyOrdered  = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    	if (qtyOrdered < MAX_NUMBERS_ORDERED ) {
    		itemsOrdered[qtyOrdered] = disc;
    		qtyOrdered +=1;
    		System.out.println("the dvd has been added");
    	} else {
    		System.out.println("your order is full, buy membership to unlock.");
    	}
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    	int index = 0;
    	if (qtyOrdered > 0 ) {
    		for (int i=0; i< qtyOrdered; i++) {
    			if (itemsOrdered[i].equals(disc)) {
    				index = i;
    				break;
    			}
    		}
    		for (int i = index; i < qtyOrdered - 1; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }

            // Set the last element to null and decrease numItems
            itemsOrdered[qtyOrdered - 1] = null;
            qtyOrdered-=1;
    	}
    }
    public float totalCost() {
    	int sum = 0;
    	for (int i = 0; i<qtyOrdered; i++) {
    		sum += itemsOrdered[i].getCost();
    	}
		return sum;
    	
    }
}
