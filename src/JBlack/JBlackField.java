package JBlack;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import Constants.Constants;

public class JBlackField extends JTextField {
    public JBlackField(int rowNumber, boolean onlyNumbers) {
        super(rowNumber);
        setBorder(null);
        setBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        setForeground(Color.WHITE);
        setHorizontalAlignment(JTextField.CENTER);

        if (onlyNumbers) {
            setFont(Constants.Fonts.FIELD_FONT);
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {
                    try {
                        Integer.parseInt(getText());
                    } catch (NumberFormatException exc) {
                        setText("");
                    } finally {
                        if (getText().length() > rowNumber) {
                            setText(getText().substring(0, rowNumber));
                        }
                    }
                }
            });
        } else {
            setFont(Constants.Fonts.RULER_FONT);
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {
                    if (getText().length() > rowNumber) {
                        setText(getText().substring(0, rowNumber).toUpperCase());
                    } else {
                        setText(getText().toUpperCase());
                    }

                }
            });
        }
    }

    public JBlackField(char symbol) {
        super(String.valueOf(symbol));
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
