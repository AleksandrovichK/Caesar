
package Component;

import javax.swing.*;
import java.awt.*;

public class SubstitutionWindowLetter extends JPanel {
	private String letter;
	private JTextField podstanova = new JTextField();

	public JTextField getPodstanova() {

		return podstanova;
	}

	public String getLetter() {

		return letter;
	}

	public void setPodstanova(String podstanova) {

		this.podstanova.setText(podstanova);
	}

	public void setLetter(String letter) {

		this.letter = letter;
	}

	public SubstitutionWindowLetter(String inLetter, String inField) {
		letter = inLetter;
		podstanova.setText(inField);
		podstanova.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		podstanova.setFont(new Font("Times New Roman", Font.BOLD, 20));
		podstanova.setForeground(Color.BLACK);
		//.setLayout(null);
		
		add(podstanova);
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		Color up = new Color(0, 31, 85);
		Color down = new Color(3, 15, 37);
		gg.setPaint(new RadialGradientPaint(getWidth() / 2, getHeight() / 2, getWidth() / 2, new float[] { 0f, 1f },
				new Color[] { up, down }));
		gg.fillRect(0, 0, getWidth(), getHeight());
		gg.setColor(Color.GRAY);
		gg.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
		gg.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
		gg.setPaint(Color.BLACK);
		gg.drawRect(1, 1, this.getWidth()-3, this.getHeight()-3);

		gg.setFont(new Font("Times New Roman", Font.BOLD, 20));
		gg.setPaint(Color.WHITE);
		gg.drawString(letter, (this.getWidth()-gg.getFontMetrics().stringWidth(letter))/2, 20);

		podstanova.setBounds(4, this.getHeight()/2+4, this.getWidth()-8, this.getHeight()/2-8);
		
		podstanova.repaint();
	}
}