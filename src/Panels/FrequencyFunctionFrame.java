package Panels;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Component.GistogrammPanel;
import Frames.MainFrame;

public class FrequencyFunctionFrame extends JPanel {
	private JButton toCount = new JButton("To count");
	private MainFrame TextMain;
	private JTable table = null;
	private JScrollPane Pane = null;
	GistogrammPanel qwer = null;
	public void paint(Graphics g){	
		Graphics2D gg =(Graphics2D) g;
		Color up = new Color(0,31,85);
		Color down = new Color(3,15,37);
		gg.setPaint(new RadialGradientPaint( getWidth ()/2, getHeight()/2, getWidth()/2, new float[]{ 0f, 1f },
                new Color[]{ up, down }));
		gg.fillRect(0, 0, getWidth(), getHeight());
		
		toCount.repaint();
		if(qwer!=null){
			qwer.repaint();
		}
		
	}
	public FrequencyFunctionFrame(MainFrame MText) throws HeadlessException {
		TextMain = MText;
		toCount.setFont(new Font("Times New Roman", Font.BOLD, 30));
		add(toCount);
		toCount.addMouseListener(new Listener());
	}

	int q = 0;

	private void toCountFrequency(MainFrame MText) {

		MainFrame main = MText;
		String text = MText.getTextPanel().getMainText().getText();
		Map<Character, Integer> Frequency = new HashMap<Character, Integer>();

		//text = text.toUpperCase();

		for (int i = 0; i < text.length(); i++)
			Frequency.put(text.charAt(i), 0);

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != '\n') {
				Integer value = Frequency.get(text.charAt(i));
				value = value + 1;
				Frequency.put(text.charAt(i), value);
			}
		}

		String[] columns = { "Буква", "Частота", "Вероятность" };
		String[][] data = null;
		if (Frequency.size() < 30) {
			data = new String[30][3];
		} else {
			data = new String[Frequency.size()][3];
		}

		Double[] quantity = new Double[Frequency.size()];
		for (int i = 0; i < Frequency.size(); i++)
			quantity[i] = Double.valueOf(0.0);
		Double length = new Double(Double.valueOf(text.length()));

		int j = 0;
		for (Map.Entry entry : Frequency.entrySet()) {
			data[j][1] = entry.getValue().toString();
			String temp = entry.getValue().toString();
			quantity[j] = Double.valueOf(temp);
			data[j][0] = entry.getKey().toString();

			Double res = Double.valueOf(quantity[j] / length);
			data[j][2] = String.valueOf(res);
			j++;
		}

		String[] tmp = new String[3];

		for (int i = 0; i < Frequency.size() - 1; i++)
			for (int k = i; k < Frequency.size(); k++)
				if (Integer.parseInt(data[i][1]) < Integer.parseInt(data[k][1])) {
					tmp = data[i];
					data[i] = data[k];
					data[k] = tmp;
				}

		
		if (q == 1) {
			remove(qwer);
		} else {
			q = 1;
		}
		table = new JTable(data, columns);
		Pane = new JScrollPane(table);
		updateUI();

		String s[] = new String[Frequency.size()];
		String d[] = new String[Frequency.size()];
		for(int i=0; i<Frequency.size(); i++){
			s[i]=data[i][0];
			System.out.print(s[i]);
			System.out.print(" = ");
			d[i]=data[i][2];
			System.out.print(d[i]);
			System.out.println();
		}
		qwer = new GistogrammPanel(s,d);

		qwer.setPreferredSize(new Dimension(585,330));
		JScrollPane qwer2 = new JScrollPane(qwer);
		add(qwer2);
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
				toCountFrequency(TextMain);
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
