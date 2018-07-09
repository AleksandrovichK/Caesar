package Panels;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Constants.Constants;
import JBlack.JBlackButton;
import JBlack.JBlackField;

public class PermutationPanel extends JPanel {
    private JTextArea primaryText;
    private int oldest = 0;
    private int newest = 0;

    public PermutationPanel(JTextArea mainText) {
        this.setLayout(null);

        this.setBackground(Constants.Colors.MAIN_COLOR);

        JBlackButton startButton = new JBlackButton(Constants.Buttons.BUTTON_START);
        add(startButton).setBounds(Constants.Sizes.BUTTON_PERMUTATION_START_BOUNDS);
        startButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                JLabel rulerLabel = new JLabel();
                rulerLabel.setFont(Constants.Fonts.RULER_FONT);
                rulerLabel.setText("123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                rulerLabel.setForeground(Constants.Colors.GISTOGRAMM_COLOR);
                add(rulerLabel).setBounds(Constants.Sizes.LABEL_RULER_BOUNDS);

                primaryText.setText(mainText.getText());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        primaryText = new JTextArea();
        primaryText.setFont(Constants.Fonts.RULER_FONT);
        primaryText.setForeground(Color.WHITE);
        primaryText.setBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);

        JScrollPane textPane = new JScrollPane(primaryText);
        textPane.setBorder(null);
        textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(textPane).setBounds(Constants.Sizes.TEXTPANEL_PERMUTATION_BOUNDS);

        JBlackField oldNumber = new JBlackField(2, false);
        oldNumber.setFont(Constants.Fonts.FIELD_FONT);
        add(oldNumber).setBounds(Constants.Sizes.TEXTFIELD_PERMUTATION_OLD_NUMBER_BOUNDS);

        JBlackField newNumber = new JBlackField(2, false);
        newNumber.setFont(Constants.Fonts.FIELD_FONT);
        add(newNumber).setBounds(Constants.Sizes.TEXTFIELD_PERMUTATION_NEW_NUMBER_BOUNDS);

        JBlackButton swapRowsButton = new JBlackButton(Constants.Buttons.BUTTON_SWAP);
        add(swapRowsButton).setBounds(Constants.Sizes.BUTTON_SWAP_ROWS_BOUNDS);
        swapRowsButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!oldNumber.getText().equals("") && !newNumber.getText().equals("") && !oldNumber.getText().equals("0") && !newNumber.getText()
                        .equals("0")) {
                    toChangeTwoColumns(oldNumber.getText(), newNumber.getText());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.setVisible(true);
    }

    private int toCountRowLength(StringBuffer textSB) {
        int rowLength = 0;

        for (int i = 0; i < textSB.length(); i++)
            if (textSB.charAt(i) == '\n') {
                rowLength = i;
                break;
            }

        if (rowLength == 0)
            rowLength = textSB.length();
        return rowLength;
    }

    private void toChangeTwoColumns(String oldNum, String newNum) {
        toCalibrate(oldNum, newNum);

        String text = primaryText.getText();
        StringBuffer textSB = new StringBuffer(text);

        int rowLength = toCountRowLength(textSB);

        if (oldest <= rowLength + 1 && newest <= rowLength + 1) {
            toSwap(textSB, rowLength);
        }

        primaryText.setText(textSB.toString());
    }

    private void toSwap(StringBuffer textSB, int key) {
        oldest--;
        newest--;

        char temp1, temp2;
        for (int i = 0; i < textSB.length() / key; i++) {
            temp1 = textSB.charAt(oldest);
            temp2 = textSB.charAt(newest);

            textSB.setCharAt(oldest, temp2);
            textSB.setCharAt(newest, temp1);

            oldest = oldest + (key + 1);
            newest = newest + (key + 1);

            if (oldest > textSB.length() && newest > textSB.length())
                break;
        }
    }

    private void toCalibrate(String oldNumber, String newNumber) {
        if ((int) oldNumber.charAt(0) >= 48 && (int) oldNumber.charAt(0) <= 57 && (int) newNumber.charAt(0) >= 48
                && (int) newNumber.charAt(0) <= 57) {
            oldest = Integer.valueOf(oldNumber);
            newest = Integer.valueOf(newNumber);
        }

        if (((int) oldNumber.charAt(0) >= 65 && (int) oldNumber.charAt(0) <= 90) && ((int) newNumber.charAt(0) >= 65
                && (int) newNumber.charAt(0) <= 90)) {
            oldest = ((int) oldNumber.charAt(0) - 55);
            newest = ((int) newNumber.charAt(0) - 55);
        }

        if (((int) oldNumber.charAt(0) >= 65 && (int) oldNumber.charAt(0) <= 90) && ((int) newNumber.charAt(0) >= 48
                && (int) newNumber.charAt(0) <= 57)) {
            oldest = ((int) oldNumber.charAt(0) - 55);
            newest = Integer.valueOf(newNumber);
        }

        if (((int) oldNumber.charAt(0) >= 48 && (int) oldNumber.charAt(0) <= 57) && ((int) newNumber.charAt(0) >= 65
                && (int) newNumber.charAt(0) <= 90)) {
            oldest = Integer.valueOf(oldNumber);
            newest = ((int) newNumber.charAt(0) - 55);
        }
    }
}
