package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	@Override
	public int compare(Media media1, Media media2) {
		int compare_value = media1.getTitle().compareTo(media2.getTitle());
		if (compare_value == 0) {
			return Float.compare(media1.getCost(), media2.getCost()); 
		}
		return compare_value;
	}
} 
