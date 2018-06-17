package Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import Component.SubstitutionWindowLetter;
import ControlButton.ClearButton;
import ControlButton.RefreshButton;
import ControlButton.ReplaceButton;
import Frames.FunctionalFrame;
import Frames.MainFrame;

public class SubstitutionPanel extends JPanel {
	private ReplaceButton replaceButton = new ReplaceButton();
	private RefreshButton refreshButton = new RefreshButton();
	private ClearButton clearButton = new ClearButton();
	private JTextArea textPane = new JTextArea();
	private MainFrame mainFrame;
	private SubstitutionWindowLetter array[] = null;

	public SubstitutionPanel(MainFrame m) {
		this.setLayout(null);
		mainFrame = m;
		clearButton.setBounds(0, 150, 20, 20);
		replaceButton.setBounds(21, 150, 20, 20);
		refreshButton.setBounds(42, 150, 20, 20);
		textPane.setBounds(0, 0, 585, 150);
		textPane.setLineWrap(true);
		textPane.setWrapStyleWord(true);
		toMakePanel();
		toRefresh();

		refreshButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				toMakePanel();
				toRefresh();
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(textPane);
		add(clearButton);
		add(replaceButton);
		add(refreshButton);
	}

	private void toMakePanel() {
		String text = mainFrame.getTextArea();

		Map<Character, Integer> Frequency = new HashMap<>();

		for (int i = 0; i < text.length(); i++)
			if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13){
			Frequency.put(text.charAt(i), 0);}

		for (int i = 0; i < text.length(); i++) {
			if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13){
			Integer value = Frequency.get(text.charAt(i));
			value = value + 1;
			Frequency.put(text.charAt(i), value);
			}
		}

		int count = 0;

		for (Map.Entry entry : Frequency.entrySet())
			if ((Integer) entry.getValue() > 0)
				count++;

		array = new SubstitutionWindowLetter[count];
		int i = 0;
		for (Map.Entry entry : Frequency.entrySet()) {
			array[i] = new SubstitutionWindowLetter(entry.getKey().toString(), "*");
			add(array[i]);
			array[i].getPodstanova().addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {

				}

				@Override
				public void keyPressed(KeyEvent e) {

				}

				@Override
				public void keyReleased(KeyEvent e) {
					toRefresh();
				}
			});
			i++;
		}
		repaint();
	}
	private void toRefresh() {
		String startText = mainFrame.getTextArea();
		StringBuilder newText = new StringBuilder();

		for (int i = 0; i < startText.length(); i++)
			for (SubstitutionWindowLetter anArray : array) {
				if (startText.charAt(i) == anArray.getLetter().charAt(0)) {
					newText.append(anArray.getPodstanova().getText().charAt(0));
					break;
				}
			}
		textPane.setText(newText.toString());
	}

	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		Color up = new Color(0, 31, 85);
		Color down = new Color(3, 15, 37);
		gg.setPaint(new RadialGradientPaint(getWidth() / 2, getHeight() / 2, getWidth() / 2, new float[] { 0f, 1f },
				new Color[] { up, down }));
		gg.fillRect(0, 0, getWidth(), getHeight());

		textPane.repaint();
		clearButton.repaint();
		replaceButton.repaint();
		refreshButton.repaint();
		if (array != null) {
			int n;
			if (array.length < 32) {
				n = array.length;
			} else {
				n = 32;
			}

			for (int i = 0; i < array.length; i++) {
				array[i].setBounds((this.getWidth() - n * 25) / 2 + i % n * 21, i / n * 60 + this.getHeight() / 2, 20,
						60);
				array[i].repaint();
			}
		}
	}
}
