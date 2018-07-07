package Buttons;

import java.awt.*;

import javax.swing.*;

import Constants.Constants;

public class JBlackButton extends JButton {
    public JBlackButton(String name) {
        super(name);
        setBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        setForeground(Color.WHITE);
        setFont(Constants.Fonts.BUTTONS_FONT);
    }

    public JBlackButton() {
        super();
        setBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        setForeground(Color.WHITE);
        setFont(Constants.Fonts.BUTTONS_FONT);
    }
}
