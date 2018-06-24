package Panels;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import Buttons.JBlackButton;

public class FreedmanPanel extends JPanel {

	private void settings() {
		this.setLayout(null);
	}

	private JTextArea mainText;
	private JBlackButton toCount = new JBlackButton("Посчитать индекс Фридмана");
	private JBlackButton toMutCount = new JBlackButton("Посчитать индекс совпадения Фридмана");
	private JScrollPane pane1 = null;
	private JScrollPane pane2 = null;
	private JScrollPane pane3 = null;
	private JTextArea inText = new JTextArea();
	private String value = ("");
	private String value2 = ("");

	private JLabel input;
	private JLabel euro;

	public JTextArea toGetText() {
		return inText;
	}

	public void setText(JTextArea text) {
		inText = text;
	}

	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D) g;

		gg.setFont(new Font("Calibri", Font.BOLD, 18));
		gg.setPaint(Color.WHITE);

		gg.drawString("Взаимный индекс совпадения Фридмана:", 0, 60);
		gg.drawString("Сдвиг для русского языка:", 0, 355);
		gg.drawString("Сдвиг для английского языка:", 0, 285);
		gg.drawString(value, 347, 40);
		gg.drawString(value2, 340, 60);

		if (pane1 != null)
			pane1.repaint();
		if (pane2 != null)
			pane2.repaint();
		if (pane3 != null)
			pane3.repaint();

		inText.repaint();
		toCount.repaint();
		toMutCount.repaint();

	//	input.repaint();
		euro.repaint();
	}

	public FreedmanPanel(JTextArea MText) {
		mainText = MText;
		settings();
		input = new JLabel("Индекс Фридмана для введённого текста:");
		euro = new JLabel ("Индекс Фридмана для европейских языков:");
		this.add(euro).setBounds(0, 195, 300, 20);
		this.add(input).setBounds(0, 40, 300,20);

		this.add(inText).setBounds(0, 70, 585, 100);
		this.add(toCount).setBounds(0, 2, 285, 20);
		this.add(toMutCount).setBounds(300, 2, 285, 20);

		toCount.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				toCountFreedman(mainText.getText());
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		toMutCount.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				String a = inText.getText();
				toCountMutFreedman(a);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});

		toPrintFreedmanTable();
		toPrintEngTable();
		toPrintRusTable();
		this.updateUI();
	}

	private void toCountFreedman(String text) {
		Map<Character, Integer> Frequency = new HashMap<>();

		text = text.toUpperCase();

		for (int i = 0; i < text.length(); i++) {
			if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13) {
				Frequency.put(text.charAt(i), 0);
			}
		}
		for (int i = 0; i < text.length(); i++) {
			if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13) {
				Integer value = Frequency.get(text.charAt(i));
				value = value + 1;
				Frequency.put(text.charAt(i), value);
			}
		}

		Double length = new Double(Double.valueOf(text.length()));
		Double Ic = new Double(0.0);
		Double pi = new Double(0.0);

		int i = 0;
		for (Map.Entry entry : Frequency.entrySet()) {
			pi = Double.valueOf(entry.getValue().toString()) / length;
			Ic = Ic + Math.pow(pi, 2);
		}

		value = String.valueOf(Ic);
		repaint();
	}

	private void toCountMutFreedman(String text2) {

		String text = mainText.getText();

		Map<Character, Integer> Frequency = new HashMap<Character, Integer>();
		Map<Character, Integer> Frequency2 = new HashMap<Character, Integer>();

		text = text.toUpperCase();
		text2 = text2.toUpperCase();

		for (int i = 0; i < text.length(); i++)
			if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13) {
				Frequency.put(text.charAt(i), 0);
			}
		for (int i = 0; i < text2.length(); i++)
			if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13) {
				Frequency2.put(text2.charAt(i), 0);
			}
		for (int i = 0; i < text.length(); i++) {
			if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13) {
				Integer value = Frequency.get(text.charAt(i));
				value = value + 1;
				Frequency.put(text.charAt(i), value);
			}
		}

		for (int i = 0; i < text2.length(); i++) {
			if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13) {
				Integer value2 = Frequency2.get(text2.charAt(i));
				value2 = value2 + 1;
				Frequency2.put(text2.charAt(i), value2);
			}
		}

		Double length = new Double(Double.valueOf(text.length()));
		Double length2 = new Double(Double.valueOf(text2.length()));

		Double MIc = new Double(0.0);
		Double pi1 = new Double(0.0);
		Double pi2 = new Double(0.0);

		int i = 0;
		for (Map.Entry entry : Frequency.entrySet()) {
			pi1 = Double.valueOf(entry.getValue().toString()) / length;
			if (Frequency2.get(entry.getKey()) != null)
				pi2 = Double.valueOf(Frequency2.get(entry.getKey())) / length2;
			MIc = MIc + pi1 * pi2;
		}

		value2 = String.valueOf(MIc);
		repaint();
	}

	private void toPrintFreedmanTable() {
		String[] columns = { "Russian", "English", "French", "German", "Italian", "Spanish" };
		String[][] data = new String[1][6];

		data[0][0] = "0,0553";
		data[0][1] = "0,0662";
		data[0][2] = "0,0778";
		data[0][3] = "0,0762";
		data[0][4] = "0,0738";
		data[0][5] = "0,0775";

		pane3 = new JScrollPane(new JTable(data, columns));

		this.add(pane3).setBounds(0, 200, 585, 39);
	}

	private void toPrintEngTable() {
		String[] columns = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" };
		String[][] data = new String[1][14];

		data[0][0] = "0,0644";
		data[0][1] = "0,0394";
		data[0][2] = "0,0319";
		data[0][3] = "0,0345";
		data[0][4] = "0,0436";
		data[0][5] = "0,0332";
		data[0][6] = "0,0363";
		data[0][7] = "0,0389";
		data[0][8] = "0,0338";
		data[0][9] = "0,0342";
		data[0][10] = "0,0378";
		data[0][11] = "0,0440";
		data[0][12] = "0,0387";
		data[0][13] = "0,0428";

		JTable table = new JTable(data, columns);
		table.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		pane2 = new JScrollPane(table);
		this.add(pane2).setBounds(0, 290, 585, 39);
	}

	private void toPrintRusTable() {
		String[] columns = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
				"16" };
		String[][] data = new String[1][17];

		data[0][0] = "0,0553";
		data[0][1] = "0,0366";
		data[0][2] = "0,0345";
		data[0][3] = "0,0400";
		data[0][4] = "0,0340";
		data[0][5] = "0,0360";
		data[0][6] = "0,0326";
		data[0][7] = "0,0241";
		data[0][8] = "0,0287";
		data[0][9] = "0,0317";
		data[0][10] = "0,0265";
		data[0][11] = "0,0251";
		data[0][12] = "0,0244";
		data[0][13] = "0,0291";
		data[0][14] = "0,0322";
		data[0][15] = "0,0244";
		data[0][16] = "0,0249";

		JTable table = new JTable(data, columns);
		table.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10));
		pane1 = new JScrollPane(table);

		this.add(pane1).setBounds(0, 360, 585, 39);
	}
}
