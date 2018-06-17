package Component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GistogrammPanel extends JPanel {
	String[] info;
	String[] data;

	public GistogrammPanel(String[] s, String[] d) {
		info = s;
		data = d;
	}

	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		gg.setPaint(Color.WHITE);
		gg.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		gg.setPaint(Color.GRAY);
		gg.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
		gg.setPaint(Color.BLACK);
		gg.drawRect(1, 1, this.getWidth()-3, this.getHeight()-3);
		
		int n = info.length;
		double scale = 1. / Double.parseDouble(data[0]);
		for (int i = 0; i < n; i++) {
			gg.setPaint(Color.RED);
			gg.fillRect((this.getWidth() - 10 * n) / 2 + i * 10,
					(int) (this.getHeight() - Double.parseDouble(data[i]) * scale * (this.getHeight() - 17) - 15)+3, 10,
					(int) (Double.parseDouble(data[i]) * scale * (this.getHeight() - 17)));
			gg.setPaint(Color.BLACK);
			gg.drawRect((this.getWidth() - 10 * n) / 2 + i * 10,
					(int) (this.getHeight() - Double.parseDouble(data[i]) * scale * (this.getHeight() - 17) - 15)+3, 10,
					(int) (Double.parseDouble(data[i]) * scale * (this.getHeight() - 17)));

			gg.drawString(info[i], (this.getWidth() - 10 * n) / 2 + i * 10, this.getHeight() - 3);
		}
		gg.setPaint(Color.BLACK);
		int i = 0;
		while ((double) i / 100 <= Double.parseDouble(data[0])) {
			Double x = (double) (i) / 100;
			gg.drawLine(3, (int) (this.getHeight() - (scale * (this.getHeight() - 17) * x) - 15)+3, this.getWidth()-3,
					(int) (this.getHeight() - (scale * (this.getHeight() - 17) * x) - 15)+3);
			if (i % 2 == 0) {
				gg.drawString(x.toString(), 3, (int) (this.getHeight() - (scale * (this.getHeight() - 17) * x) - 15));
			}
			if (Double.parseDouble(data[0]) < 0.5) {
				if (Double.parseDouble(data[0]) < 0.2) {
					i += 1;
				} else {
					i += 2;
				}
			} else {
				i += 10;
			}
		}
	}
}
