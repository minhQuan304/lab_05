package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;
	private ControllerScreen c;
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addMediaBookMenu= new JMenuItem("addMedia Book");
		addMediaBookMenu.addActionListener(e->{
			c.showAddBookScreen();
		});
		smUpdateStore.add(addMediaBookMenu);
		JMenuItem addMediaCDMenu=new JMenuItem("addMedia CD");
		addMediaCDMenu.addActionListener(e->{
			c.showAddCDCreen();
		});
		smUpdateStore.add(addMediaCDMenu);
		JMenuItem addMediaDVDMenu= new JMenuItem("addMedia DVD");
		addMediaDVDMenu.addActionListener(e->{
			c.showAddDVDScreen();
		});
		smUpdateStore.add(addMediaDVDMenu);

		menu.add(smUpdateStore);
		JMenuItem viewStoreMenu= new JMenuItem("View store");
		viewStoreMenu.addActionListener(e->{
			c.showStoreScreen();
		});
		menu.add(viewStoreMenu);
		
		JMenuItem viewCartMenu= new JMenuItem("View cart");
		viewCartMenu.addActionListener(e->{
			c.showCartScreen();
		});
		menu.add(viewCartMenu);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton btnCart = new JButton("View cart");
		
		btnCart.setPreferredSize(new Dimension(100, 50));
		btnCart.setMaximumSize(new Dimension(100, 50));
		btnCart.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					c.showCartScreen();
				}
		});
		
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(btnCart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i=0; i< mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}
		
		return center;
	}
	
	public StoreScreen(Store store, Cart cart,ControllerScreen c) {
		this.store = store;
		this.cart = cart;
		this.c=c;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
		
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		store.addMedia(new Book("Java Programming", "Education", 29.95f));
    	store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", 19.95f, 148, "Christopher Nolan"));
    	store.addMedia(new CompactDisc("Hahaa", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new Book("C Programming", "Education", 29.95f));
    	store.addMedia(new DigitalVideoDisc("Inono", "Sci-Fi", 19.95f, 148, "Christopher Nolan"));
    	store.addMedia(new CompactDisc("Huhu3", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu2", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu1", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu7", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu9", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu8", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu6", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu5", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu4", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhuu", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhuuu", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhuuuu", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));store.addMedia(new Book(1, "Java Programming", "Education", 29.95f));
    	store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", 19.95f, 148, "Christopher Nolan"));
    	store.addMedia(new CompactDisc("Hahaa", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new Book("C Programming", "Education", 29.95f));
    	store.addMedia(new DigitalVideoDisc("Inono", "Sci-Fi", 19.95f, 148, "Christopher Nolan"));
    	store.addMedia(new CompactDisc("Huhu3", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu2", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu1", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu7", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu9", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu8", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu6", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu5", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhu4", "Music", 15.95f, 0, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhuu", "Music", 15.95f, 0, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhuuu", "Music", 15.95f, 0, "Michael Jackson", "Michael Jackson"));
    	store.addMedia(new CompactDisc("Huhuuuu", "Music", 15.95f, 42, "Michael Jackson", "Michael Jackson"));
    	Cart cart = new Cart();
		ControllerScreen controller = new ControllerScreen(cart, store);
		new StoreScreen(store, cart, controller);
		
	}

}