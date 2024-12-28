package hust.soict.dsai.aims.cart.Cart;
import java.util.ArrayList;
import javax.naming.LimitExceededException;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
//	private int qtyOrdered = 0;
	public static final int MAX_ORDERED = 20;
//	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_ORDERED];
//	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
//	public void addDigitalVideoDisc (DigitalVideoDisc disc) {
//		if (qtyOrdered == MAX_ORDERED) {
//			System.out.println("Reached max number ordered");
//		}
//		else {
//			itemsOrdered[qtyOrdered] = disc;
//			qtyOrdered += 1;
//			System.out.println("Added");
//		}
//	
//	}
//	
//	public void addDigitalVideoDisc (DigitalVideoDisc[] dvdList) {
//		for (DigitalVideoDisc disc: dvdList) {
//			int space = MAX_ORDERED - qtyOrdered;
//			if (space == 0) {
//				System.out.println("Full");
//				return;
//			}
//			else {
//				itemsOrdered[qtyOrdered] = disc;
//				qtyOrdered += 1;
//				System.out.println("Add" + disc.getTitle());
//				}
//		}
//	}
//	
//	public void addDigitalVideoDisc (DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
//		DigitalVideoDisc[] discs = {disc1, disc2};
//		for (DigitalVideoDisc disc : discs) {
//			int space = MAX_ORDERED - qtyOrdered;
//			if (space == 0) {
//				System.out.println("Full");
//				return;
//			}
//			else {
//				itemsOrdered[qtyOrdered] = disc;
//				qtyOrdered += 1;
//				System.out.println("Add" + disc.getTitle());
//				}
//		}
//	}
	
	public void addMedia(Media media) throws LimitExceededException {
		if ((itemsOrdered.size()) >= MAX_ORDERED) {
//			System.out.println("Full");
			throw new LimitExceededException("Full");
		}
		else if (itemsOrdered.contains(media)) {
			System.out.println("Media already exists");
		}

		else {
			itemsOrdered.add(media);
			System.out.println("Added");
			}
	}
	
//	public void removeDigitalVideoDisc (DigitalVideoDisc disc) {
//		for (int i = 0; i < qtyOrdered; i++) {
//			if (itemsOrdered[i].equals(disc)) {
//				for (int j = i; i < qtyOrdered - 1; i++) {
//					itemsOrdered[j] = itemsOrdered[j+1];
//				}
//				itemsOrdered[qtyOrdered-1] = null;
//				qtyOrdered -= 1;
//				System.out.println("Removed");
//				return;
//			}
//		}
//		System.out.println("Cannot find the disc");
//	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Removed");
		}
		else {
			System.out.println("Media does not exist");
		}
	}
	public float totalCost() {
		float totalCost = 0;
		for (Media media : itemsOrdered) {
			totalCost += media.getCost();
		}	
		return totalCost;
	}
	
//	public ArrayList<Media> getItemsOrdered() {
////		String[] listOrdered = new String[qtyOrdered];
////		for (int i = 0; i< qtyOrdered; i++) {
////			listOrdered[i] = itemsOrdered[i].getTitle();
////		}
////		return listOrdered;
//		return itemsOrdered;
//	}
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	 public void print() {
		 System.out.println("***********************CART***********************");
		 System.out.println("Ordered Items:");
		 for (Media media : itemsOrdered) {
			 System.out.println(media.toString());
			}		 
		 System.out.println("Total cost: " + totalCost());
	 }
	 
	 public void sortCartCostTitle() {
		 Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	 }
	 public void sortCartTitleCost() {
		 Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	 }
	 
	 public void idSearch(int id) {
		 boolean found = false;
		 for (Media media : itemsOrdered) {
			 if (media == null) {
				 break;
			 }
			 else if (media.getId() == id) {
				 System.out.println("found: " + media.toString());
				 found = true;
				 break;
			 } 
		 }
		 if (found == false) {
			 System.out.println("Empty");
			 }
	 }	
	 
	 public void titleSearch(String title) {
		 boolean found = false;
		 String lowercaseTitle = title.toLowerCase();
		 for (Media media : itemsOrdered) {
			 if (media == null) {
				 break;
			 }
			 String[] keywords = lowercaseTitle.split(" ");
			 String lowercaseDVDTitle = media.getTitle().toLowerCase();
			 for (String keyword : keywords) {
			        if (lowercaseDVDTitle.contains(keyword)) {
			            found = true;
			            System.out.println("found: " + media.toString());
			            break;
			        }
			    }
		 }

		 if (found == false) {
			 System.out.println("Empty");
			 }
	 }
}