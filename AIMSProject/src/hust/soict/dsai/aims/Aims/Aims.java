package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.media.*;

import java.util.Scanner;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.CompactDisc;

public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		Track track1 = new Track("Bruh1", 13);
		Track track2 = new Track("Bruh2", 21);
		CompactDisc cd1 = new CompactDisc("Allstars", "Yes", "Smash Mouth", "Dunno", 69.420f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		Book book1 = new Book("Sherlock Holmes", "Detective", 420, 5f);
		book1.addAuthor("Conan Doyle");
		book1.addAuthor("JK Rolling");
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(cd1);
		store.addMedia(book1);
		
		Scanner scanner = new Scanner(System.in);
		int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    viewStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    seeCurrentCart(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
	
	public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
	
	public static void viewStore(Scanner scanner) {
        store.listItems();
        storeMenu(scanner);
    }
	
	public static void storeMenu(Scanner scanner) {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                seeMediaDetails(scanner);
                break;
            case 2:
                addMediaToCart(scanner);
                break;
            case 3:
                playMedia(scanner);
                break;
            case 4:
                seeCurrentCart(scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                storeMenu(scanner);
                break;
        }
	}
	 
	public static void seeMediaDetails(Scanner scanner) {
		System.out.println("Enter the title of the media:");
	    String title = scanner.nextLine();

	    Media media = store.searchMedia(title);
	    if (media != null) {
	        System.out.println(media);
	        mediaDetailsMenu(scanner, media);
	    } else {
	        System.out.println("Media not found.");
	        storeMenu(scanner);
	    }
	}
    
	public static void mediaDetailsMenu(Scanner scanner, Media media) {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");

        if (media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
            System.out.println("2. Play");
        }

        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                cart.addMedia(media);
                System.out.println("Media added to cart.");
                storeMenu(scanner);
                break;
            case 2:
                if (media instanceof DigitalVideoDisc) {
                    DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                    dvd.play();
                } else if (media instanceof CompactDisc) {
                    CompactDisc cd = (CompactDisc) media;
                    cd.play();
                }
                mediaDetailsMenu(scanner, media);
                break;
            case 0:
                storeMenu(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                mediaDetailsMenu(scanner, media);
                break;
        }
    }
	
	public static void addMediaToCart(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.searchMedia(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart.");
            System.out.println("Number of DVDs in cart: " + cart.getSize());
        } else {
            System.out.println("Media not found.");
        }
        storeMenu(scanner);
    }
	
	public static void playMedia(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.searchMedia(title);
        if (media != null) {
            if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                dvd.play();
            } else if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
                cd.play();
            }
        } else {
            System.out.println("Media not found.");
        }
        storeMenu(scanner);
    }
	
	public static void updateStore(Scanner scanner) {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                addMediaToStore(scanner);
                break;
            case 2:
                removeMediaFromStore(scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                updateStore(scanner);
                break;
        }
    }
	
	public static void addMediaToStore(Scanner scanner) {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a new CD to the store");
		System.out.println("2. Add a new DVD to the store");
		System.out.println("3. Add a new book to the store");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		switch (choice) {
			case 0:
				break;
				
			case 1:
				System.out.println("Please enter the information of the new CD");
				System.out.println("Title: ");
				String title1 = scanner.nextLine();
				System.out.println("Category: ");
				String category1 = scanner.nextLine();
				System.out.println("Artist: ");
				String artist = scanner.nextLine();
				System.out.println("Director: ");
				String director1 = scanner.nextLine();
				System.out.println("Cost: ");
				float cost1 = Float.parseFloat(scanner.nextLine());
				store.addMedia(new CompactDisc(title1, category1, artist, director1, cost1));
				System.out.println("CD added. Enter any key to continue");
				scanner.nextLine();
				updateStore(scanner);
				
			case 2: 
				System.out.println("Please enter the information of the new DVD");
				System.out.println("Title: ");
				String title2 = scanner.nextLine();
				System.out.println("Category: ");
				String category2 = scanner.nextLine();
				System.out.println("Director: ");
				String director2 = scanner.nextLine();
				System.out.println("Length: ");
				int length2 = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Price: ");
				float cost2 = Float.parseFloat(scanner.nextLine());
				store.addMedia(new DigitalVideoDisc(title2, category2, director2, length2, cost2));
				System.out.println("DVD added. Enter any key to continue");
				scanner.nextLine();
				updateStore(scanner);
	
			case 3:
				System.out.println("Please enter the information of the new book");
				System.out.println("Title: ");
				String title3 = scanner.nextLine();
				System.out.println("Category: ");
				String category3 = scanner.nextLine();
				System.out.println("Number of pages: ");
				int length3 = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Price: ");
				float price = Float.parseFloat(scanner.nextLine());
				store.addMedia(new Book(title3, category3, length3, price));
				System.out.println("Book added. Enter any key to continue");
				scanner.nextLine();
				updateStore(scanner);
				
			default:
				System.out.println("Invalid choice. Please try again.");
                updateStore(scanner);
                break;
			}
		}

    public static void removeMediaFromStore(Scanner scanner) {
		System.out.println("Please enter the title of the media you want to remove: ");
		String title = scanner.nextLine();
		Media medium = store.searchMedia(title);
		//Invalid name
		while (medium == null) {
			System.out.println("Please enter a valid product name.");
			title = scanner.nextLine();
			medium = store.searchMedia(title);
		}
		store.removeMedia(medium);
		System.out.println("Enter any key to continue");
		scanner.nextLine();
		updateStore(scanner);
    }
    
    public static void seeCurrentCart(Scanner scanner) {
        System.out.println("Current Cart:");
        cart.printCart();
        cartMenu(scanner);
    }
    
    public static void cartMenu(Scanner scanner) {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                filterMediasInCart(scanner);
                break;
            case 2:
                sortMediasInCart(scanner);
                break;
            case 3:
                removeMediaFromCart(scanner);
                break;
            case 4:
                playMediaFromCart(scanner);
                break;
            case 5:
                placeOrder(scanner);
                break;
            case 0:
                storeMenu(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                cartMenu(scanner);
                break;
        }
    }
    
    public static void filterMediasInCart(Scanner scanner) {
        System.out.println("Filter Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                // Implement filtering medias in cart by ID
                break;
            case 2:
                // Implement filtering medias in cart by title
                break;
            case 0:
                cartMenu(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                filterMediasInCart(scanner);
                break;
        }
    }
    
    public static void sortMediasInCart(Scanner scanner) {
        System.out.println("Sort Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                // Implement sorting medias in cart by title
                break;
            case 2:
                // Implement sorting medias in cart by cost
                break;
            case 0:
                cartMenu(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                sortMediasInCart(scanner);
                break;
        }
    }
    
    public static void removeMediaFromCart(Scanner scanner) {
        System.out.println("Enter the title of the media to remove:");
        String title = scanner.nextLine();
        
        Media media = cart.searchMedia(title);
        boolean removed = cart.removeMedia(media);
        if (removed) {
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found in cart.");
        }
        cartMenu(scanner);
    }
    
    public static void playMediaFromCart(Scanner scanner) {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();

        Media media = cart.searchMedia(title);
        if (media != null) {
            if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                dvd.play();
            } else if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
                cd.play();
            }
        } else {
            System.out.println("Media not found in cart.");
        }
        cartMenu(scanner);
    }
    
    public static void placeOrder(Scanner scanner) {
    	if (cart.getSize() == 0) {
			System.out.println("You cannot place an empty order\n");
			cartMenu(scanner);
		} else {
			cart = new Cart();
			System.out.println("Your order has been placed\n");
			showMenu();
		}
    }

//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		
		
		
	

}
