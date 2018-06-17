package ControlButton;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class RefreshButton extends JPanel{
	Color up;
	Color down;

	public RefreshButton() {

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
		gg.drawArc(x/4, y/4, x/2, y/2, 90,130);
		gg.drawArc(x/4, y/4, x/2, y/2, 270,130);
		gg.drawLine(x/2+1, 4, x/2-4, 3);
		gg.drawLine(x/2+1, 4, x/2-1, 8);
		gg.drawLine(x/2-2, y-4, x/2+4, y-3);
		gg.drawLine(x/2-2, y-4, x/2+1, y-8);
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
			
			down = new Color(0, 31, 85);
			up = new Color(0, 0, 0);
			repaint();
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
