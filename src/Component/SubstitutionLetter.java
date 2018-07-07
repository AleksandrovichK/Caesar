package Component;

import java.awt.*;

import javax.swing.*;

import Buttons.JBlackField;
import Constants.Constants;

public class SubstitutionLetter extends JPanel {
    private JBlackField substitution;
    private JLabel letter;

    public SubstitutionLetter(String inLetter, String inField) {
        letter = new JLabel(inLetter);
        letter.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        setBackground(Constants.Colors.MAIN_COLOR);

        letter.setFont(Constants.Fonts.FIELD_FONT);
        letter.setForeground(Color.WHITE);
        add(letter);

        substitution = new JBlackField(inField);
        substitution.setBorder(null);
        substitution.setFont(Constants.Fonts.FIELD_FONT);
        substitution.setForeground(Color.WHITE);
        add(substitution);
    }

    public JBlackField getSubstitution() {
        return substitution;
    }

    public JLabel getLetter() {
        return letter;
    }
}