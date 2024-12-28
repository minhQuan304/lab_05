package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	
	public Media() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String toString() {
		return "Media - "  + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - "  + this.getCost() + " $";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Media) {
			Media media = (Media) o;
			if (this.title.equals(media.title)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
//	public boolean equals(Object obj) {
//		if (obj == null || this.getClass() != obj.getClass()) {
//			return false;
//		}
//		else {
//			Media that = (Media) obj;
//			return this.getTitle() == that.getTitle();
//		}
//	}
}
