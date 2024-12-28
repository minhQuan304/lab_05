package hust.soict.dsai.aims.screen;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField artist;
	private JTextField listTrack;

	public AddCompactDiscToStoreScreen(Store store, Cart cart, ControllerScreen c) {
		super(store, cart, c);

	}

	@Override
	void updateAdd(JPanel panel) {
		this.numberInput = 6;

		JLabel artistLabel = new JLabel("artist", JLabel.TRAILING);
		panel.add(artistLabel);
		artist = new JTextField(2);
		artist.setPreferredSize(new Dimension(150, 20));
		artistLabel.setLabelFor(artist);
		panel.add(artist);
		JLabel listTrackLabel = new JLabel("List track (each track separated by a comma Ex: track-length)",
				JLabel.TRAILING);

		panel.add(listTrackLabel);
		listTrack = new JTextField(2);
		listTrackLabel.setLabelFor(listTrack);
		panel.add(listTrack);
		JButton tes = new JButton("add");
		tes.setVisible(false);
		panel.add(tes);
		panel.setPreferredSize(new Dimension(100, 300));
		addBtn = new JButton("add");
		addBtn.addActionListener(e -> {
			addMedia();
		});
		panel.add(addBtn);
	}

	public void addMedia() {
		try {
			String title = this.title.getText();
			String listTrack = this.listTrack.getText();
			String category = this.category.getText();
			float cost = Float.parseFloat(this.cost.getText());
			String artist = this.artist.getText();
			String[] arrayTrack = listTrack.trim().split(",");

			CompactDisc cd = new CompactDisc(title, category, cost, artist);

			for (String track : arrayTrack) {
				String[] trackDetails = track.split("-");
				if (trackDetails.length != 2) {
					JOptionPane.showMessageDialog(null, "Invalid track format. Please use 'Title-Length'.");
					return;
				}
				String titleTrack = trackDetails[0].trim();
				int lengthTrack;
				try {
					lengthTrack = Integer.parseInt(trackDetails[1].trim());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Track length must be a number.");
					return;
				}
				Track newTrack = new Track(titleTrack, lengthTrack);
				cd.addTrack(newTrack);
			}

			this.store.addMedia(cd);
			JOptionPane.showMessageDialog(null, "Added CD successfully!");
			clearTextField();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Cost must be a valid number.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "An error occurred. Please fill the form again.");
		}
	}

	public void clearTextField() {
		this.title.setText("");
		this.listTrack.setText("");
		this.cost.setText("");
		this.artist.setText("");
		this.category.setText("");
	}

}