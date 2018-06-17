package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import Frames.MainFrame;

public class FreedmanPanel extends JPanel {

	private void addComponent(JComponent component, int x1, int x2, int x3, int x4) {
		component.setBounds(x1, x2, x3, x4);
		this.add(component);
	};

	private void settings() {
		this.setLayout(null);
	};

	private MainFrame TextMain;
	private JButton toCount = new JButton("Посчитать индекс Фридмана");
	private JButton toMutCount = new JButton("Посчитать индекс совпадения Фридмана");
	JScrollPane pane1 = null;
	JScrollPane pane2 = null;
	JScrollPane pane3 = null;
	private JTextArea inText = new JTextArea();
	private String value = ("");
	private String value2 = ("");

	public JTextArea toGetText() {
		return inText;
	}

	public void setText(JTextArea text) {
		inText = text;
	}

	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		Color up = new Color(0, 31, 85);
		Color down = new Color(3, 15, 37);
		gg.setPaint(new RadialGradientPaint(getWidth() / 2, getHeight() / 2, getWidth() / 2, new float[] { 0f, 1f },
				new Color[] { up, down }));
		gg.fillRect(0, 0, getWidth(), getHeight());

		gg.setFont(new Font("Times New Roman", Font.BOLD, 18));
		gg.setPaint(Color.WHITE);
		gg.drawString("Индекс Фридмана для введённого текста:", 0, 40);
		gg.drawString("Индекс Фридмана для европейских языков:", 0, 195);
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
	}

	public FreedmanPanel(MainFrame MText) {
		TextMain = MText;
		settings();

		// Background back = new Background("resources\\23bg_13.jpg");

		addComponent(inText, 0, 70, 585, 100);
		addComponent(toCount, 0, 2, 285, 20);
		addComponent(toMutCount, 300, 2, 285, 20);

		Listener listener = new Listener();
		toCount.addMouseListener(listener);
		toMutCount.addMouseListener(listener);
		toPrintFreedmanTable();
		toPrintEngTable();
		toPrintRusTable();
		toCountFreedman();
		this.updateUI();
	}

	private void toCountFreedman() {

		String text = TextMain.getTextPanel().getMainText().getText();

		int m = text.length();

		Map<Character, Integer> Frequency = new HashMap<Character, Integer>();

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

		String text = TextMain.getTextPanel().getMainText().getText();

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
		String[] columns = { "Русский", "Английский", "Французский", "Немецкий", "Итальянский", "Испанский" };
		String[][] data = new String[1][6];

		data[0][0] = "0,0553";
		data[0][1] = "0,0662";
		data[0][2] = "0,0778";
		data[0][3] = "0,0762";
		data[0][4] = "0,0738";
		data[0][5] = "0,0775";

		pane3 = new JScrollPane(new JTable(data, columns));

		addComponent(pane3, 0, 200, 585, 39);
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
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pane2 = new JScrollPane(table);
		addComponent(pane2, 0, 290, 585, 39);
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
		table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		pane1 = new JScrollPane(table);

		addComponent(pane1, 0, 360, 585, 39);
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
			if (b == toCount) {
				toCountFreedman();
			}
			if (b == toMutCount) {
				String a = inText.getText();
				toCountMutFreedman(a);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	}

}
