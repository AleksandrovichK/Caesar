package ControlButton;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class KeyButton extends JPanel{
	Color up;
	Color down;

	public KeyButton() {


		up = new Color(0,31,85);
		down = new Color(240,240,240);
		
		this.addMouseListener(new Listener());
	}
	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		gg.setPaint(new Color(0,31,85));
		gg.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		gg.setPaint(
				new GradientPaint(0, this.getHeight() - 4, new Color(100, 100, 100), 0, this.getHeight(), new Color(50, 50, 50)));
		gg.fillRect(2, this.getHeight() - 3, this.getWidth() - 4, this.getHeight());

		gg.setPaint(new GradientPaint(0, 0, down, 0, getHeight() - 4, up));
		gg.fillRoundRect(2, 2, this.getWidth() - 4, this.getHeight() - 4, 2, 2);
		gg.setPaint(Color.BLACK);
		gg.drawRoundRect(2, 2, this.getWidth() - 4, this.getHeight() - 4, 2, 2);

		gg.setPaint(Color.WHITE);
		gg.drawRect(25*this.getWidth()/100, (this.getHeight()-25*this.getHeight()/100)/2, 25*this.getWidth()/100, 25*this.getHeight()/100);
		gg.drawLine(50*this.getWidth()/100, (this.getHeight())/2, 75*this.getWidth()/100, (this.getHeight())/2);
		gg.fillRect(75*this.getWidth()/100, (this.getHeight())/2, 10*this.getWidth()/100, 20*this.getHeight()/100);
	}

	public class Listener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			up = new Color(0,31,85);
			down = new Color(140,140,140);
			repaint();
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
			up = new Color(15,46,170);
			down = new Color(240,240,240);
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			up = new Color(15,46,170);
			down = new Color(240,240,240);
			repaint();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			up = new Color(0,31,85);
			down = new Color(240,240,240);
			repaint();
		}

	}
}
