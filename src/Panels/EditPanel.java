package Panels;

import Constants.Constants;
import Frames.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EditPanel extends JPanel {
    private int columnsCount = 0;
    private MainFrame mainFrame;

    public EditPanel(MainFrame m) {
        mainFrame = m;

        this.setLayout(new GridLayout(5, 2));

        JTextField deleteWordTextField = new JTextField(15);
        JTextField divideColumnTextField = new JTextField(15);

        JButton deleteWordButton = new JButton(Constants.Buttons.BUTTON_DELETE_WORD);
        deleteWordButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                deleteWordFunction(deleteWordTextField.getText());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        JButton upCaseButton = new JButton(Constants.Buttons.BUTTON_UPPER_CASE);
        upCaseButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mainFrame.setTextArea(mainFrame.getTextArea().toUpperCase());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        JButton downCaseButton = new JButton(Constants.Buttons.BUTTON_LOWER_CASE);
        downCaseButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mainFrame.setTextArea(mainFrame.getTextArea().toLowerCase());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        JButton divideColumnButton = new JButton(Constants.Buttons.BUTTON_DIVIDE_INTO_COLUMNS);
        divideColumnButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                divideColumnFunction(Integer.parseInt(divideColumnTextField.getText()));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        JButton transpositionButton = new JButton(Constants.Buttons.BUTTON_TRANSPOSITION);
        transpositionButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                transposeFunction();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        add(deleteWordButton);
        add(deleteWordTextField);
        add(upCaseButton);
        add(downCaseButton);
        add(divideColumnButton);
        add(divideColumnTextField);
        add(transpositionButton);
    }

    private void transposeFunction() {
        String s = mainFrame.getTextArea();
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
        mainFrame.setTextArea(new_s);
    }

    private void deleteWordFunction(String text) {
        String s = mainFrame.getTextArea();
        String raz = text;
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
        mainFrame.setTextArea(new_s);
    }

    private boolean checkSymb(char charAt, String raz) {
        for (int i = 0; i < raz.length(); i++) {
            if (charAt == raz.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private void divideColumnFunction(int number) {
        String s = mainFrame.getTextArea();
        String new_s = "";
        int n = number;

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
            mainFrame.setTextArea(new_s);
        }
    }
}
