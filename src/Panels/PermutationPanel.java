package Panels;
//123456789ABCDEFGHIJKLMNOPQRSTU
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Buttons.JBlackButton;
import Buttons.KeyButton;
import Main.MainFrame;

public class PermutationPanel extends JPanel {


	private JTextArea primaryText = new JTextArea();
	private JBlackButton butChange = new JBlackButton("Поменять");
	private JTextField labelOld = new JTextField();
	private JTextField labelNew = new JTextField();
	private JTextField keyInput = new JTextField("");
	private KeyButton keyButton = new KeyButton();

	int oldest =0,newest =0;

	Listener listener = new Listener();
	Listener2 listener2 = new Listener2();
	MainFrame MText;

	private void addComponent(JComponent component, int x1, int y1, int x2, int y2) {
		component.setBounds(x1, y1, x2, y2);
		this.add(component);
	}
	private void settings() {
		this.setLayout(null);
		primaryText.setFont(new Font("Consolas", Font.BOLD, 18));
		primaryText.setForeground(Color.BLACK);
		labelNew.setFont(new Font("Consolas", Font.BOLD, 18));
		labelNew.setForeground(Color.BLACK);
		labelOld.setFont(new Font("Consolas", Font.BOLD, 18));
		labelOld.setForeground(Color.BLACK);
		keyInput.setFont(new Font("Consolas", Font.BOLD, 18));
		keyInput.setForeground(Color.BLACK);

		primaryText.setText(MText.getTextArea());
	}
	public PermutationPanel(MainFrame mainText) throws HeadlessException {
		MText = mainText;
		settings();

		addComponent(primaryText, 10, 17, 304, 355);
		addComponent(butChange, 340, 37, 110, 20);
		addComponent(labelOld, 340, 15, 50, 20);
		addComponent(labelNew, 400, 15, 50, 20);
		addComponent(keyInput, 10, 375, 304, 20);
		addComponent(keyButton,320, 375, 40, 20);


		butChange.addMouseListener(listener);
		keyButton.addMouseListener(listener2);
		this.setVisible(true);
	}

	private int toCountKey(StringBuffer textSB) {
		int key = 0;

		for (int i = 0; i < textSB.length(); i++)
			if (textSB.charAt(i) == '\n') {
				key = i;
				break;
			}

		if (key == 0)
			key = textSB.length();
		return key;
	}
	private void toChangeTwoColumns() {
		String gettedOld = labelOld.getText().toUpperCase();
		String gettedNew = labelNew.getText().toUpperCase();
        toCalibrate(gettedOld,gettedNew);

		String text = primaryText.getText();
		StringBuffer textSB = new StringBuffer(text);
		int key = toCountKey(textSB);

		toSwap(textSB, oldest, newest, key);

		text = String.valueOf(textSB);
		primaryText.setText(text);
	}
	private void toSwap(StringBuffer textSB, int oldest, int newest, int key) {
		oldest--;
		newest--;
		for (int i = 0; i < textSB.length() / key; i++) {
			char temp1 = textSB.charAt(oldest);
			char temp2 = textSB.charAt(newest);

			textSB.setCharAt(oldest, temp2);
			textSB.setCharAt(newest, temp1);

			oldest = oldest + (key + 1);
			newest = newest + (key + 1);

			if (oldest > textSB.length() && newest > textSB.length())
				break;
		}
	}
	public class Listener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {

		}
		@Override
		public void mousePressed(MouseEvent e) {

		}
		@Override
		public void mouseReleased(MouseEvent e) {
			JButton b = new JButton();
			b = (JButton) e.getSource();
			if (b == butChange) {
				toChangeTwoColumns();
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {

		}
		@Override
		public void mouseExited(MouseEvent e) {

		}
	}
	public class Listener2 implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {

		}
		@Override
		public void mousePressed(MouseEvent e) {

		}
		@Override
		public void mouseReleased(MouseEvent e) {
			KeyButton c = new KeyButton();
			c = (KeyButton) e.getSource();
			if (c == keyButton) {
				String key = keyInput.getText();
				toSortAccordingToKey(key);
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {

		}
		@Override
		public void mouseExited(MouseEvent e) {

		}
	}
	private void toSortAccordingToKey(String key) {
		key = key.toUpperCase();
		StringBuffer textKey = new StringBuffer(key);
		int keyLength = toCountKey(textKey);

		String text = primaryText.getText();
		StringBuffer textUS = new StringBuffer(text);
		StringBuffer readyText = new StringBuffer(text);
		char temp;
        int now=0;
		for (int i=0;i<keyLength;i++){
             temp=key.charAt(i);
			 toCalibrate(String.valueOf(0),String.valueOf(temp));
			 toPlusColumn(textUS, readyText,now, newest,keyLength);
			 now++;
		}

		text = String.valueOf(readyText);
		primaryText.setText(text);
	}

	private void toPlusColumn(StringBuffer textUS, StringBuffer readyText, int now, int temp, int key) {
		newest--;
		for (int i = 0; i < textUS.length() / key; i++) {
			char temp2 = textUS.charAt(newest);
			readyText.setCharAt(now, temp2);

			newest = newest + (key + 1);
			now = now + (key+ 1);

			if (newest > textUS.length() || now>textUS.length())
				break;
		}
	}

	private void toCalibrate(String gettedOld, String gettedNew){

		if ((int) gettedOld.charAt(0) >= 48 && (int) gettedOld.charAt(0)<= 57 && (int) gettedNew.charAt(0) >= 48 && (int) gettedNew.charAt(0)<= 57)
		{
			oldest = Integer.valueOf(gettedOld);
			newest = Integer.valueOf(gettedNew);
		}

		if (((int) gettedOld.charAt(0) >= 65 && (int) gettedOld.charAt(0)<= 90) && ((int) gettedNew.charAt(0) >= 65 && (int) gettedNew.charAt(0)<= 90))
		{
			oldest = ((int) gettedOld.charAt(0)-55);
			newest = ((int) gettedNew.charAt(0)-55);
		}

		if (((int) gettedOld.charAt(0) >= 65 && (int) gettedOld.charAt(0)<= 90) && ((int) gettedNew.charAt(0) >= 48 && (int) gettedNew.charAt(0)<= 57))
		{
			oldest = ((int) gettedOld.charAt(0)-55);
			newest = Integer.valueOf(gettedNew);
		}

		if (((int) gettedOld.charAt(0) >= 48 && (int) gettedOld.charAt(0)<= 57) && ((int) gettedNew.charAt(0) >= 65 && (int) gettedNew.charAt(0)<= 90))
		{
			oldest = Integer.valueOf(gettedOld);
			newest = ((int) gettedNew.charAt(0)-55);
		}
	}
	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D) g;

		gg.setFont(new Font("Consolas", Font.BOLD, 18));
		gg.setPaint(Color.WHITE);
		gg.drawString("123456789ABCDEFGHIJKLMNOPQRSTU",primaryText.getBounds().x,primaryText.getBounds().y -2);

		primaryText.repaint();
		butChange.repaint();
		labelOld.repaint();
		labelNew.repaint();
        keyInput.repaint();
		keyButton.repaint();

	}

}
