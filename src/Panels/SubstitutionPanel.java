package Panels;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import Component.Substitution;
import Constants.Constants;
import JBlack.JBlackButton;

public class SubstitutionPanel extends JPanel {
    private JTextArea textArea;
    private JTextArea mainText;
    private Substitution[] array;

    public SubstitutionPanel(JTextArea mText) {
        this.setLayout(null);
        mainText = mText;
        setBackground(Constants.Colors.MAIN_COLOR);

        JBlackButton startButton = new JBlackButton(Constants.Buttons.BUTTON_START);
        add(startButton).setBounds(Constants.Sizes.BUTTON_SUBST_START_BOUNDS);
        startButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                toMakePanel();
                toSubstitute();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        textArea = new JTextArea();
        textArea.setBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(Constants.Fonts.TEXTAREA_FONT);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane textPane = new JScrollPane(textArea);
        textPane.setBorder(null);
        textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(textPane).setBounds(Constants.Sizes.TEXTPANEL_SUBST_BOUNDS);
    }

    private void toMakePanel() {
        String text = mainText.getText();

        Map<Character, Integer> Frequency = new HashMap<>();

        for (int i = 0; i < text.length(); i++)
            if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13) {
                Frequency.put(text.charAt(i), 1);
            }

        if (array != null) {
            for (Substitution arrayIter : array) {
                this.remove(arrayIter);
            }
        }

        array = new Substitution[Frequency.size()];

        int i = 0;
        for (Map.Entry entry : Frequency.entrySet()) {
            array[i] = new Substitution(entry.getKey().toString(), "*");
            array[i].getSubstitution().addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    toSubstitute();
                }
            });
            this.add(array[i]);
            i++;
        }

        if (array != null) {
            int n;
            if (array.length < 21) {
                n = array.length;
            } else {
                n = 21;
            }

            for (int j = 0; j < array.length; j++) {
                array[j].setBounds(Constants.Sizes.TEXTPANEL_SUBST_BOUNDS.x + j % n * (Constants.Sizes.LABEL_LETTER_SUBST_BOUNDS.width + 10),
                        j / n * 60 + this.getHeight() / 2,
                        Constants.Sizes.LABEL_LETTER_SUBST_BOUNDS.width,
                        Constants.Sizes.LABEL_LETTER_SUBST_BOUNDS.height * 2);
            }

        }

        updateUI();
    }

    private void toSubstitute() {
        String startText = mainText.getText();
        StringBuilder newText = new StringBuilder();

        for (int i = 0; i < startText.length(); i++)
            for (Substitution anArray : array) {
                if (!anArray.getSubstitution().getText().isEmpty() && startText.charAt(i) == anArray.getLetter().getText().charAt(0)) {
                    newText.append(anArray.getSubstitution().getText().charAt(0));
                    break;
                }
            }
        textArea.setText(newText.toString());
    }
}
