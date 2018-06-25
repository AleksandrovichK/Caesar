package Panels;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Buttons.JBlackButton;
import Buttons.JBlackField;
import Constants.Constants;

public class EditPanel extends JPanel {
    private JTextArea mainText;

    public EditPanel(JTextArea text) {
        mainText = text;

        this.setLayout(null);
        this.setBackground(Constants.Colors.MAIN_COLOR);

        JBlackField divideColumnTextField = new JBlackField(10);

        JBlackButton upCaseButton = new JBlackButton(Constants.Buttons.BUTTON_UPPER_CASE);
        upCaseButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mainText.setText(mainText.getText().toUpperCase());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JBlackButton downCaseButton = new JBlackButton(Constants.Buttons.BUTTON_LOWER_CASE);
        downCaseButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mainText.setText(mainText.getText().toLowerCase());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JBlackButton divideColumnButton = new JBlackButton(Constants.Buttons.BUTTON_DIVIDE_INTO_COLUMNS);
        divideColumnButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!divideColumnTextField.getText().equals("")) {
                    divideColumnFunction(Integer.parseInt(divideColumnTextField.getText()));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        
        JBlackButton cleanButton = new JBlackButton(Constants.Buttons.BUTTON_CLEAN);
        cleanButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
               //TODO TEXT CLEANING FROM !@#$%^&*()_+
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        add(upCaseButton).setBounds(Constants.Sizes.BUTTON_UPCASE_BOUNDS);
        add(cleanButton).setBounds(Constants.Sizes.BUTTON_CLEAN_BOUNDS);
        add(downCaseButton).setBounds(Constants.Sizes.BUTTON_DOWNCASE_BOUNDS);
        add(divideColumnButton).setBounds(Constants.Sizes.BUTTON_DIVIDECOLUMN_BOUNDS);
        add(divideColumnTextField).setBounds(Constants.Sizes.TEXTFIELD_DIVIDECOLUMN_BOUNDS);
    }

    private void divideColumnFunction(int number) {
        if (number == 0)
            return;

        String rawText = mainText.getText();
        StringBuilder dividedText = new StringBuilder();

        int iterator = 0;
        for (int i = 0; i < rawText.length(); i++) {
            if (rawText.charAt(i) != '\n') {
                dividedText.append(rawText.charAt(i));
                iterator++;
                if (iterator == number) {
                    iterator = 0;
                    dividedText.append('\n');
                }
            }
        }
        mainText.setText(dividedText.toString());
    }
}
