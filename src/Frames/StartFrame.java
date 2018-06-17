package Frames;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class StartFrame extends JFrame {
	private int width = 450;
	private int height = 300;
	JProgressBar loadBar = new JProgressBar();
	private Image logo = new ImageIcon("resourse/onlinelogomaker-102615-1923.png").getImage();

	public StartFrame() {
		setting();
		addComponent(loadBar, 10, height - 30, width - 20, 20);
		loadBar.setIndeterminate(true);

	}

	private void addComponent(JComponent com, int x1, int x2, int x3, int x4) {
		// TODO Auto-generated method stub
		com.setBounds(x1, x2, x3, x4);
		this.add(com);
	}

	public void startLoading() {

	}

	public void paint(Graphics g) {
		int borderSize = 1;
		g.setColor(Color.white);
		// g.setColor(new Color(123,22,41,0.1f));
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, width, borderSize);
		g.fillRect(0, 0, borderSize, height);
		g.fillRect(0, height - borderSize, width, height);
		g.fillRect(width - borderSize, 0, width, height);
		g.drawImage(logo, (width - 400) / 2, (height - 199) / 2, 400, 199, null);

	}

	private void setting() {
		this.setLayout(null);
		this.setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - height) / 2, width, height);
		this.dispose();
		this.setUndecorated(true);
		this.isDoubleBuffered();
		this.setVisible(true);
	}
}
