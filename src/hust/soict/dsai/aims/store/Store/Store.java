package hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;


public class Store {
	private ArrayList<Media> itemsInStore;
//	private int currentIndex = 0;
	
	public Store() {
		super();
		this.itemsInStore = new ArrayList<Media>(); 
	}
	
	public void printItemsInStore() {
		for (Media media : itemsInStore) {
			System.out.println(media.toString());
		 }
	}
	
	public void addMedia(Media media) {

		if (itemsInStore.contains(media)) {
			System.out.println("Media already exists");
		}
		else {
			itemsInStore.add(media);
			System.out.println("Added");
			}
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("Removed");
		}
		else {
			System.out.println("Media does not exist");
		}
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
//	public void addDVD(DigitalVideoDisc disc) {
//		if (currentIndex < itemsInStore.length) {
//			itemsInStore[currentIndex] = disc;
//			currentIndex += 1;
//			System.out.println("Added");
//		} 
//		else {System.out.println("Full");}
//	}
//	
//	public void removeDVD(DigitalVideoDisc disc) {
//		boolean found = false;
//		for (int i = 0; i < currentIndex; i++) {
//			if (itemsInStore[i] == disc) {
//				for (int j = i; j < currentIndex - 1; j++) {
//					itemsInStore[j] = itemsInStore[j+1];
//				}
//				currentIndex -= 1;
//				itemsInStore[currentIndex] = null;
//				found = true;
//				break;
//			}
//		}
//		if (found == true) {
//			System.out.println("Removed");
//		}
//		else {System.out.println("Not found");}
//	}
}
