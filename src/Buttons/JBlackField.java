package Buttons;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import Constants.Constants;

public class JBlackField extends JTextField {
    public JBlackField(int number) {
        super(number);
        setBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        setForeground(Color.WHITE);
        setFont(Constants.Fonts.FIELD_FONT);
        setHorizontalAlignment(JTextField.CENTER);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    if (Integer.parseInt(getText()) > 9999) {
                        setText(getText().substring(0, 4));
                    }
                } catch (NumberFormatException exc) {
                    setText("");
                }
            }
        });
    }

    public JBlackField(String sentence) {
        super(sentence);
        setBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        setForeground(Color.WHITE);
        setFont(Constants.Fonts.FIELD_FONT);
        setHorizontalAlignment(JTextField.CENTER);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                    if (getText().length() > 1) {
                        setText(getText().substring(0, 1));
                    }
            }
        });
    }
}
