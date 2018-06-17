package Panels;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Frames.MainFrame;

public class EditPanel extends JPanel {
	int columnsCount = 0;
	MainFrame mainFrame;
	JButton upCaseButton = new JButton("К верхнему регистру");
	JButton downCaseButton = new JButton("К нижнему регистру");
	JTextField deleteSymbTextField = new JTextField(15);
	JButton deleteSymbButton = new JButton("Удалить символы");
	JTextField deleteWordTextField = new JTextField(15);
	JButton deleteWordButton = new JButton("Удалить слово");
	JButton deviteColumnButton = new JButton("Разбить на столбцы");
	JTextField deviteColumnTextField = new JTextField(15);
	JButton transterentButton = new JButton("Транспонировать");

	public EditPanel(MainFrame m) {
		mainFrame = m;

		this.setLayout(new GridLayout(5, 2));
		Listener listener = new Listener();
		deleteSymbButton.addMouseListener(listener);
		deleteWordButton.addMouseListener(listener);
		upCaseButton.addMouseListener(listener);
		downCaseButton.addMouseListener(listener);
		deviteColumnButton.addMouseListener(listener);
		transterentButton.addMouseListener(listener);

		add(this.deleteSymbButton);
		add(this.deleteSymbTextField);
		add(this.deleteWordButton);
		add(this.deleteWordTextField);
		add(this.upCaseButton);
		add(this.downCaseButton);
		add(this.deviteColumnButton);
		add(this.deviteColumnTextField);
		add(this.transterentButton);
	}

	private void transterentFunction() {
		String s = mainFrame.getTextPanel().getMainText().getText();
		String new_s = "";
		int n = columnsCount;

		String[] strings = new String[n];
		for (int i = 0; i < n; i++)
			strings[i] = "";

		for (int i = 0; i < n; i++) {
			for (int j = i; j < s.length(); j += n + 1) {
				strings[i] += s.charAt(j);

			}
		}
		for (int i = 0; i < n; i++)
			new_s += strings[i] + '\n';

		columnsCount = strings[0].length();
		mainFrame.getTextPanel().getMainText().setText(new_s);
	}

	private void deleteWordFunction() {
		String s = mainFrame.getTextPanel().getMainText().getText();
		String raz = deleteWordTextField.getText();
		String new_s = "";

		for (int i = 0; i < s.length() - raz.length(); i++) {
			String temp = "";
			for (int j = i; j < raz.length() + i; j++) {
				temp += s.charAt(j);
			}
			if (!temp.equals(raz)) {
				new_s += s.charAt(i);
			} else {

				i += raz.length() - 1;
			}
		}
		mainFrame.getTextPanel().getMainText().setText(new_s);
	}

	private void deleteSymbFunction() {
		String s = mainFrame.getTextPanel().getMainText().getText();
		String raz = deleteSymbTextField.getText();
		String new_s = "";

		for (int i = 0; i < s.length(); i++) {
			if (!checkSymb(s.charAt(i), raz) && s.charAt(i) != '\n') {
				new_s += s.charAt(i);
			}
		}
		mainFrame.getTextPanel().getMainText().setText(new_s);
	}

	private boolean checkSymb(char charAt, String raz) {
		// TODO Auto-generated method stub
		for (int i = 0; i < raz.length(); i++) {
			if (charAt == raz.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	private void deviteColumnFunction() {
		String s = mainFrame.getTextPanel().getMainText().getText();
		String new_s = "";
		int n;
		try {
			n = Integer.parseInt(this.deviteColumnTextField.getText());
		} catch (Exception e) {
			n = 0;
		}
		if (n != 0) {
			int k = 0;
			columnsCount = n;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != '\n') {
					new_s += s.charAt(i);
					k++;
					if (k == n) {
						k = 0;
						new_s += '\n';
					}
				}
			}
			mainFrame.getTextPanel().getMainText().setText(new_s);
		}
	}

	public class Listener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton) e.getSource();
			if (b == deleteSymbButton) {
				deleteSymbFunction();
			}
			if (b == deleteWordButton) {
				deleteWordFunction();
			}
			if (b == upCaseButton) {
				mainFrame.getTextPanel().getMainText()
						.setText(mainFrame.getTextPanel().getMainText().getText().toUpperCase());
			}
			if (b == downCaseButton) {
				mainFrame.getTextPanel().getMainText()
						.setText(mainFrame.getTextPanel().getMainText().getText().toLowerCase());
			}
			if (b == deviteColumnButton) {
				deviteColumnFunction();
			}
			if (b == transterentButton) {
				transterentFunction();
			}
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
