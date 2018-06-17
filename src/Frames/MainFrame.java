package Frames;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Component.Slots;
import Component.TextPanel;
import ControlButton.ExitButton;
import ControlButton.IconifiedButton;

public class MainFrame extends JFrame {
	private Slots slots;
	private JPanel panel = new JPanel();
	private TextPanel textPanel = new TextPanel();
	IconifiedButton iconfieldButton = new IconifiedButton(this);
	ExitButton exitButton = new ExitButton();

	public TextPanel getTextPanel() {
		return textPanel;
	}
	public void setTextPanel(TextPanel textPanel) {
		this.textPanel = textPanel;
	}

	public MainFrame(String ss[], JPanel ff[]) {
		setting();
		slots = new Slots(this, ss, ff);
		
		panel.setBounds(110, 290, 850, 505);
		slots.setBounds(5, 290, 100, 405);
		textPanel.setBounds(110, 20, 585, 265);
		exitButton.setBounds(679, 2, 16, 16);
		iconfieldButton.setBounds(662, 2, 16, 16);

		this.add(iconfieldButton);
		this.add(exitButton);
		this.add(panel);
		this.add(textPanel);
		this.add(slots);
		getPanel().setLayout(new CardLayout());

	}

	private void setting() {
		// TODO Auto-generated method stub
		this.setFont(new Font("Consolas", Font.BOLD, 18));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 5 * Toolkit.getDefaultToolkit().getScreenSize().height / 100, 900, 900);
		this.setLayout(null);
		this.addMouseListener(new Listener());
		this.getContentPane().setBackground(Color.WHITE);
		this.setUndecorated(true);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D) this.getGraphics();
		Color up = new Color(0, 31, 85);
		Color down = new Color(3, 15, 37);
		gg.setPaint(new Color(0, 0, 0, 0));
		gg.fillRect(0, 0, this.getWidth(), this.getHeight());

		gg.setPaint(new GradientPaint(0, 0, up, 0, 285, down));
		gg.fillRect(0, 0, this.getWidth(), this.getHeight());
		gg.setPaint(Color.BLACK);
		gg.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);

		slots.repaint();
		textPanel.repaint();
		exitButton.repaint();
		iconfieldButton.repaint();
		panel.repaint();

	}

	boolean press=false;
	int x,y;
	public class Listener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			press = true;
			x=e.getX();
			y=e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			press =false;
			setBounds(getBounds().x-(x-e.getX()),getBounds().y-(y-e.getY()),900,900);
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
