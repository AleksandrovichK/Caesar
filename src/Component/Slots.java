package Component;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Frames.MainFrame;

public class Slots extends JPanel {
	private String[] names;
	private Slot[] slots;
	private JPanel[] frames;
	private MainFrame mainFrame;

	public Slots(MainFrame m, String[] s, JPanel[] framess) {
		frames = framess;
		names = s;
		slots = new Slot[names.length];
		this.setLayout(new GridLayout(names.length, 1));
		for (int i = 0; i < names.length; i++) {
			mainFrame = m;
			slots[i] = new Slot(names[i]);
			slots[i].addMouseListener(new Listener());
			this.add(slots[i]);
		}
	}
	public class Listener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			Slot s = (Slot) e.getSource();
			for (int i = 0; i < names.length; i++) {
				if (s == slots[i]) {

					for (int j = 0; j < frames.length; j++) {
						frames[i].setVisible(false);
					}
					((CardLayout) mainFrame.getPanel().getLayout()).show(mainFrame.getPanel(), i + "");
					frames[i].setVisible(true);
					frames[i].repaint();
				}
			}

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

}
