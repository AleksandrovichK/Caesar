package ControlButton;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ControlButton.RefreshButton.Listener;

public class ReplaceButton extends JPanel{
	Color up;
	Color down;

	public ReplaceButton() {

		down = new Color(0, 31, 85);
		up = new Color(0, 0, 0);

		this.addMouseListener(new Listener());
	}
	

	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		gg.setPaint(new Color(0, 0, 0));
		gg.fillRect(0, 0, this.getWidth(), this.getHeight());

		gg.setPaint(new GradientPaint(0, this.getHeight() - 4, new Color(100, 100, 100), 0, this.getHeight(),
				new Color(50, 50, 50)));
		gg.fillRect(2, this.getHeight() - 3, this.getWidth() - 4, this.getHeight());

		gg.setPaint(new GradientPaint(0, 0, down, 0, getHeight() - 4, up));
		gg.fillRoundRect(2, 2, this.getWidth() - 4, this.getHeight() - 4, 2, 2);
		gg.setPaint(Color.BLACK);
		gg.drawRoundRect(2, 2, this.getWidth() - 4, this.getHeight() - 4, 2, 2);
		
		int x=this.getWidth();
		int y=this.getHeight();
		gg.setPaint(Color.WHITE);
		gg.drawLine(35*x/100, 20*y/100, 35*x/100, 80*y/100);
		gg.drawLine(65*x/100, 20*y/100, 65*x/100, 80*y/100);
		gg.drawLine(35*x/100, 20*y/100, 35*x/100-2, 20*y/100+2);
		gg.drawLine(35*x/100, 20*y/100, 35*x/100+2, 20*y/100+2);
		gg.drawLine(65*x/100-2, 80*y/100-2, 65*x/100, 80*y/100);
		gg.drawLine(65*x/100+2, 80*y/100-2, 65*x/100, 80*y/100);
		
	}

	public class Listener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			up = new Color(0, 31, 85);
			down = new Color(140, 140, 140);
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			up = new Color(15, 46, 170);
			down = new Color(240, 240, 240);
			repaint();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			down = new Color(0, 31, 85);
			up = new Color(0, 0, 0);
			repaint();
		}

	}

}
